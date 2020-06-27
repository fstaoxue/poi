package com.taoge.poi.service;

import com.taoge.poi.bean.BaseLoc;
import com.taoge.poi.bean.PoiInfo;
import com.taoge.poi.exception.PoiParseException;

import java.util.List;
import java.util.Map;

/**
 * @author taoxuefeng
 * @date 2019/11/27
 */
public interface ParsePoiService {

    List<PoiInfo> parsePoiInfo(String url, Map<String,String> params) throws PoiParseException;

    BaseLoc parseAreaLocation(String url,Map<String,String> param) throws PoiParseException;

}
