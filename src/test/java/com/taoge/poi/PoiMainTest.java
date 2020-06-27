package com.taoge.poi;

import com.taoge.poi.bean.AreaCode;
import com.taoge.poi.bean.TypeCode;
import com.taoge.poi.dao.AreaCodeDao;
import com.taoge.poi.dao.TypeCodeDao;
import com.taoge.poi.service.ParseExcelService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PoiMain Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class PoiMainTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testAreaExcel(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.taoge.poi");
        String fileName="AMap_adcode_citycode.xlsx";
        ParseExcelService parseExcelService=applicationContext.getBean(ParseExcelService.class);
        Map<String,String> dictionary=new HashMap<>(5);
        dictionary.put("中文名","areaName");
        dictionary.put("adcode","adCode");
        dictionary.put("citycode","cityCode");
        List<AreaCode> resultList=parseExcelService.parseExcel(fileName, AreaCode.class,dictionary);
        if(resultList!=null){
            resultList.forEach((item)->{
                System.out.println(item.toString());
            });
        }
        AreaCodeDao areaCodeDao=applicationContext.getBean(AreaCodeDao.class);
        int[] insertResult=areaCodeDao.insert(resultList);
        for(int i=0;i<insertResult.length;i++){
            if(insertResult[i]>0){
                System.out.println("第"+i+"条插入成功！");
            }else{
                System.out.println("第"+i+"条插入失败！");
            }
        }
    }

    /**
     * Method: main(String[] args)
     */
    @Test
    public void testPoiExcel() throws Exception {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.taoge.poi");
        String fileName="amap_poicode.xlsx";
        ParseExcelService parseExcelService=applicationContext.getBean(ParseExcelService.class);
        Map<String,String> dictionary=new HashMap<>(5);
        dictionary.put("序号","id");
        dictionary.put("NEW_TYPE","typeCode");
        dictionary.put("大类","bigCateZhName");
        dictionary.put("中类","midCateZhName");
        dictionary.put("小类","smCateZhName");
        dictionary.put("Big Category","bigCateEnName");
        dictionary.put("Mid Category","midCateEnName");
        dictionary.put("Sub Category","subCateEnName");
        List<TypeCode> resultList=parseExcelService.parseExcel(fileName, TypeCode.class,dictionary);
        if(resultList!=null){
            resultList.forEach((item)->{
                System.out.println(item.toString());
            });
        }
        TypeCodeDao typeCodeDao=applicationContext.getBean(TypeCodeDao.class);
        int[] insertResult=typeCodeDao.insertMany(resultList);
        for(int i=0;i<insertResult.length;i++){
            if(insertResult[i]>0){
                System.out.println("第"+i+"条插入成功！");
            }else{
                System.out.println("第"+i+"条插入失败！");
            }
        }
    }

    @Test
    public void getPoiInfo(){

    }


} 
