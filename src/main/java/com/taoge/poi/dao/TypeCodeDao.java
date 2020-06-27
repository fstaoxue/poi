package com.taoge.poi.dao;

import com.taoge.poi.bean.TypeCode;

import java.util.List;

/**
 * @author taoxuefeng
 * @date 2019/11/21
 */
public interface TypeCodeDao {

    /**
     * 插入单条记录
     * @param code
     * @return
     */
    boolean insertOne(TypeCode code);

    /**
     * 插入多条记录
     * @param typeCodes
     * @return
     */
    int[] insertMany(List<TypeCode> typeCodes);

}
