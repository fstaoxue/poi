package com.taoge.poi.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author taoxuefeng
 * @date 2019/11/19
 * 解析固列表格式的excel文件
 */
public interface ParseExcelService {

    /**
     * 将excel文件解析
     * @param fileName
     * @return
     */
    Map<Integer,List<Object>> parseExcel(String fileName);

    /**
     * 将excel文件解析
     * 并根据传入的class类自动转换
     * @param fileName
     * @param clazz
     * @param fieldNameMap
     * @param <T>
     * @return
     */
    <T> List<T> parseExcel(String fileName,Class<T> clazz,Map<String,String> fieldNameMap);
}
