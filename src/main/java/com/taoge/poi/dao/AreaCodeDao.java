package com.taoge.poi.dao;

import com.taoge.poi.bean.AreaCode;

import java.util.List;

/**
 * @author taoxuefeng
 * @date 2019/11/20
 */
public interface AreaCodeDao {

    /**
     * 单条插入
     * @param code
     */
    boolean insert(AreaCode code);

    /**
     * 批量插入
     * @param codeList
     */
    int[] insert(List<AreaCode> codeList);

    /**
     * 查询全部区域记录
     * @return
     */
    List<AreaCode> queryAll();

    /**
     * 查询该省份所有区域记录
     * @param provinceCode
     * @return
     */
    List<AreaCode> queryAllByProvinceCode(String provinceCode);

    /**
     * 查询该城市下所有区域记录
     * @param cityCode
     * @return
     */
    List<AreaCode> queryAllByCityCode(String cityCode);

}
