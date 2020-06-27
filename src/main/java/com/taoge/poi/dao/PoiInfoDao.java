package com.taoge.poi.dao;

import com.taoge.poi.bean.PoiInfo;

import java.util.List;

/**
 * @author taoxuefeng
 * @date 2019/11/20
 */
public interface PoiInfoDao {

    int insert(PoiInfo info);

    int insert(List<PoiInfo> infoList);

}
