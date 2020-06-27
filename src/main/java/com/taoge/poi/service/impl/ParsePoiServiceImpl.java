package com.taoge.poi.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taoge.poi.bean.BaseLoc;
import com.taoge.poi.bean.PoiInfo;
import com.taoge.poi.bean.PoiParseStatus;
import com.taoge.poi.exception.PoiParseException;
import com.taoge.poi.service.ParsePoiService;
import com.taoge.poi.util.HttpClientUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author taoxuefeng
 * @date 2019/11/27
 */
@Service
public class ParsePoiServiceImpl implements ParsePoiService {

    @Override
    public List<PoiInfo> parsePoiInfo(String url, Map<String, String> params) throws PoiParseException {
        if(StringUtils.isEmpty(url)||params==null||params.size()<=0){
            return null;
        }
        url+="?";
        for(Map.Entry<String,String> entry:params.entrySet()){
            if(!url.endsWith("?")){
                url+="&";
            }
            url+=entry.getKey()+"="+entry.getValue();
        }
        System.out.println(url);
        String poiJsonStr= HttpClientUtil.getHttpResponse(url);
        if(StringUtils.isEmpty(poiJsonStr)){
            throw new PoiParseException(PoiParseStatus.EMPTY);
        }
        JSONObject result= JSONObject.parseObject(poiJsonStr);
        if(result==null){
            throw new PoiParseException(PoiParseStatus.FAILED);
        }
        try{
            String status=result.getString("status");
            if("1".equals(status)){
                JSONArray pois=result.getJSONArray("pois");
                List<PoiInfo> poiInfoList=JSONArray.parseArray(pois.toJSONString(),PoiInfo.class);
                if(poiInfoList!=null){
                    return poiInfoList;
                }
            }
        }catch (Exception e){
            throw new PoiParseException(PoiParseStatus.FAILED);
        }
        return null;
    }

    @Override
    public BaseLoc parseAreaLocation(String url, Map<String, String> params) throws PoiParseException {
        if(StringUtils.isEmpty(url)||params==null){
            return null;
        }
        params.put("keywords","南京");
        params.put("subdistrict","0");
        for(Map.Entry<String,String> entry:params.entrySet()){
            if(!url.endsWith("?")){
                url+="&";
            }
            url+=entry.getKey()+"="+entry.getValue();
        }
        String resultJson= HttpClientUtil.getHttpResponse(url);
        JSONObject result= JSONObject.parseObject(resultJson);
        if(result==null){
            throw new PoiParseException(PoiParseStatus.FAILED);
        }
        try{
            String status=result.getString("status");
            if("1".equals(status)){
                JSONArray districts=result.getJSONArray("districts");
                if(districts!=null&&districts.size()>0){
                    for(int i=0;i<districts.size();i++){
                        JSONObject obj=districts.getJSONObject(i);
                        if(obj.containsKey("location")){
                            String location=obj.getString("location");
                            String[] lngAndLat=location.split(",");
                            return new BaseLoc(lngAndLat[0],lngAndLat[1]);
                        }
                    }
                }
            }
        }catch (Exception e){
            throw new PoiParseException(PoiParseStatus.FAILED);
        }
        return null;
    }
}
