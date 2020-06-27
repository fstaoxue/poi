package com.taoge.poi.service.impl;

import com.taoge.poi.bean.PoiInfo;
import com.taoge.poi.dao.PoiInfoDao;
import com.taoge.poi.exception.PoiParseException;
import com.taoge.poi.service.CommonQueryPoiService;
import com.taoge.poi.service.ParsePoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author taoxuefeng
 * @date 2019/11/27
 */
@Service
public class CommonQueryPoiServiceImpl implements CommonQueryPoiService {

    @Autowired
    private ParsePoiService parsePoiService;

    @Autowired
    private PoiInfoDao poiInfoDao;

    private static final String KEY="26fd9dae7ae6d3769c88c1e85f2062da";

    private static final String POI_URL="https://restapi.amap.com/v3/place/around";

    private static final String AREA_LOCATION_URL="https://restapi.amap.com/v3/config/district";

    @Override
    public List<PoiInfo> queryPoi(double lat, double lng, int radius) {
        List<PoiInfo> result=new ArrayList<>();
        Map<String,String> params=new HashMap<>(5);
        params.put("location",lng+","+lat);
        params.put("radius",radius+"");
        params.put("offset","20");
        params.put("key",KEY);
        try {
            int i=1;
            while(true){
                params.put("page",i+"");
                List<PoiInfo> poiInfoList=parsePoiService.parsePoiInfo(POI_URL,params);
                if(poiInfoList!=null&&poiInfoList.size()>0){
                    poiInfoList.forEach(System.out::println);
                    result.addAll(poiInfoList);
                }else{
                    break;
                }
                i++;
                if(i>1000){
                    break;
                }
            }
        } catch (PoiParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insert(List<PoiInfo> poiInfoList) {
        return poiInfoDao.insert(poiInfoList);
    }
}
