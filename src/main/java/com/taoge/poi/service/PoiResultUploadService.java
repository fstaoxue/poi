package com.taoge.poi.service;

import java.util.Map;

/**
 * @author taoxuefeng
 * @date 2019/11/27
 */
public interface PoiResultUploadService {

    String uploadPoiResult(String jsonResult, Map<String,String> params, String url);

}
