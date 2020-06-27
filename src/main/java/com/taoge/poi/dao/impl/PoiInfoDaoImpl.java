package com.taoge.poi.dao.impl;

import com.taoge.poi.bean.PoiInfo;
import com.taoge.poi.dao.PoiInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoxuefeng
 * @date 2019/11/20
 */
@Repository
public class PoiInfoDaoImpl implements PoiInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(PoiInfo info) {

        String sql="insert into poiinfo(id, name,address, type, typecode,adName, " +
                "pName, tel,lat,lng,cityName) values(?,?,?,?,?,?,?,?,?,?,?);";
        int result = jdbcTemplate.update(sql, info.getId(), info.getName(), info.getAddress(), info.getType(), info.getTypeCode(),
                info.getAdName(), info.getpName(), info.getTel(), info.getLocation().split(",")[1], info.getLocation().split(",")[0],
                info.getCityName());
        return result;
    }

    @Override
    public int insert(List<PoiInfo> infoList) {
        String sql="insert into poiinfo(id, name,address, type, typecode,adName, " +
                "pName, tel,lat,lng,cityName) values(?,?,?,?,?,?,?,?,?,?,?)";
        List<Object[]> argsList=new ArrayList<>();
        for(int i=0;i<infoList.size();i++){
            PoiInfo info=infoList.get(i);
            Object[] temp=new Object[11];
            temp[0]=info.getId();
            temp[1]=info.getName();
            temp[2]=info.getAddress();
            temp[3]=info.getType();
            temp[4]=info.getTypeCode();
            temp[5]=info.getAdName();
            temp[6]=info.getpName();
            temp[7]=info.getTel();
            temp[8]=info.getLocation().split(",")[1];
            temp[9]= info.getLocation().split(",")[0];
            temp[10]=info.getCityName();
            argsList.add(temp);
        }
        int[] result = jdbcTemplate.batchUpdate(sql, argsList);
        return 1;
    }
}




