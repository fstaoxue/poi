package com.taoge.poi.service.impl;

import com.taoge.poi.bean.PoiInfo;
import com.taoge.poi.service.CommonQueryPoiService;
import com.taoge.poi.service.PoiScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author taoxuefeng
 * @date 2019/12/08
 */
@Service
public class PoiScheduleServiceImpl implements PoiScheduleService {

    @Autowired
    private CommonQueryPoiService commonQueryPoiService;

    @Override
    public List<PoiInfo> schedulePoiInfo(double lat, double lng, double radius) {
        return null;
    }
}
