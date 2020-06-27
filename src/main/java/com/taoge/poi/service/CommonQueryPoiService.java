package com.taoge.poi.service;

import com.taoge.poi.bean.PoiInfo;

import java.util.List;

/**
 * @author taoxuefeng
 * @date 2019/11/27
 */
public interface CommonQueryPoiService {

    List<PoiInfo> queryPoi(double lat, double lng, int radius);


    int insert(List<PoiInfo> poiInfoList);

}
