package com.taoge.poi.dao.impl;

import com.taoge.poi.bean.AreaCode;
import com.taoge.poi.dao.AreaCodeDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author taoxuefeng
 * @date 2019/11/20
 */
@Repository
public class AreaCodeDaoImpl implements AreaCodeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean insert(AreaCode code) {
        String sql="insert into areacode(codename,adcode,citycode) values(?,?,?)";
        int result=jdbcTemplate.update(sql,code.getAreaName(),code.getAdCode(),code.getCityCode());
        if(result>0){
            return true;
        }
        return false;
    }

    @Override
    public int[] insert(List<AreaCode> codeList) {
        String sql="insert into areacode(areaname,adcode,citycode) values(?,?,?)";
        List<Object[]> paramList=codeList.stream().map((code)->{
            String areaName=code.getAreaName();
            String adCode=code.getAdCode();
            String cityCode=code.getCityCode();
            if(StringUtils.isEmpty(areaName)){
                areaName="";
            }
            if(StringUtils.isEmpty(adCode)){
                adCode="";
            }
            if(StringUtils.isEmpty(cityCode)){
                cityCode="";
            }
            return new Object[]{areaName,adCode,cityCode};
        }).collect(Collectors.toList());
        int[] result=jdbcTemplate.batchUpdate(sql,paramList);
        return result;
    }

    @Override
    public List<AreaCode> queryAll() {
        return null;
    }

    @Override
    public List<AreaCode> queryAllByProvinceCode(String provinceCode) {
        return null;
    }

    @Override
    public List<AreaCode> queryAllByCityCode(String cityCode) {
        return null;
    }
}
