package com.taoge.poi.dao.impl;

import com.taoge.poi.bean.TypeCode;
import com.taoge.poi.dao.TypeCodeDao;
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
public class TypeCodeDaoImpl implements TypeCodeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean insertOne(TypeCode code) {
        String sql="insert into poicode(id,type_code,big_category_zh_name,middle_category_zh_name,"+
                "small_category_zh_name,big_category_en_name,middle_category_en_name,sub_category_en_name) values("+
                "?,?,?,?,?,?,?,?)";
        int result=jdbcTemplate.update(sql,code.getId(),code.getTypeCode(),code.getBigCateZhName()
        ,code.getMidCateZhName(),code.getSmCateZhName(),code.getBigCateEnName(),code.getMidCateEnName()
        ,code.getSubCateEnName());
        if(result>0){
            return true;
        }
        return false;
    }

    @Override
    public int[] insertMany(List<TypeCode> typeCodes) {
        String sql="insert into poicode(id,type_code,big_category_zh_name,middle_category_zh_name,"+
                "small_category_zh_name,big_category_en_name,middle_category_en_name,sub_category_en_name) values("+
                "?,?,?,?,?,?,?,?)";
        List<Object[]> params=typeCodes.stream().map((code)->{
            int id=code.getId();
            String typeCode=code.getTypeCode();
            String bigCateZhName=code.getBigCateZhName();
            String midCateZhName=code.getMidCateZhName();
            String smCateZhName=code.getSmCateZhName();
            String bigCateEnName=code.getBigCateEnName();
            String midCateEnName=code.getMidCateEnName();
            String subCateEnName=code.getSubCateEnName();
            return new Object[]{id,typeCode,bigCateZhName,midCateZhName,smCateZhName,bigCateEnName,midCateEnName,subCateEnName};
        }).collect(Collectors.toList());
        int[] result=jdbcTemplate.batchUpdate(sql,params);
        return result;
    }
}
