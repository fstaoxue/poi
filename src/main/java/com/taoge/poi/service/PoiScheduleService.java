package com.taoge.poi.service;

import com.taoge.poi.bean.PoiInfo;

import java.util.List;

/**
 * @author taoxuefeng
 * @date 2019/12/08
 */
public interface PoiScheduleService {

    List<PoiInfo> schedulePoiInfo(double lat,double lng,double radius);

}
