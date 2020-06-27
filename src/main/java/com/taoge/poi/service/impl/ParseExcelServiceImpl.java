package com.taoge.poi.service.impl;

import com.taoge.poi.service.ParseExcelService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author taoxuefeng
 * @date 2019/11/19
 * 解析excel文件的接口实现类
 */
@Service
public class ParseExcelServiceImpl implements ParseExcelService {

    @Override
    public Map<Integer,List<Object>> parseExcel(String fileName) {
        Map<Integer,List<Object>> resultMap=new LinkedHashMap<>();
        Workbook book=null;
        try (InputStream inputStream=ParseExcelServiceImpl.class.getClassLoader().getResourceAsStream(fileName);){
            book=new XSSFWorkbook(inputStream);
            Sheet sheet=book.getSheetAt(0);
            int rowNumber=sheet.getPhysicalNumberOfRows();
            for(int i=0;i<rowNumber;i++){
                List<Object> tempResult=new ArrayList<>();
                Row tempRow=sheet.getRow(i);
                int columnNumber=tempRow.getLastCellNum();
                for(int j=0;j<columnNumber;j++){
                    Cell cell=tempRow.getCell(j);
                    String value="";
                    if(CellType.STRING==cell.getCellType()){
                        value=cell.getStringCellValue();
                    }else if(CellType.NUMERIC==cell.getCellType()){
                        value=String.valueOf(cell.getNumericCellValue());
                    }
                    if(StringUtils.isNotEmpty(value)){
                        tempResult.add(value);
                    }
                }
                if(tempResult.size()>0){
                    resultMap.put(i,tempResult);
                }
            }
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    @Override
    public <T> List<T> parseExcel(String fileName, Class<T> clazz,Map<String,String> dictionary) {
        List<T> result=new ArrayList<>();
        Map<Integer,List<Object>> resultMap=parseExcel(fileName);
        Map<Integer,String> fieldNameMap=new HashMap<>(5);
        if(resultMap!=null&&resultMap.containsKey(0)){
            List<Object> firstRow=resultMap.get(0);
            if(firstRow!=null&&firstRow.size()>0){
                for(int i=0;i<firstRow.size();i++){
                    Object obj=firstRow.get(i);
                    String name=obj.toString();
                    if(StringUtils.isNotEmpty(name)){
                        if(dictionary.containsKey(name)){
                            fieldNameMap.put(i,dictionary.get(name));
                        }else{
                            fieldNameMap.put(i,name);
                        }
                    }
                }
            }
        }
        Map<String,Class> fieldTypeMap=new HashMap<>(5);
        Field[] fields=clazz.getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            Field temp=fields[i];
            String name=temp.getName();
            Class fieldClazz=temp.getType();
            if(fieldNameMap.containsValue(name)){
                fieldTypeMap.put(name,fieldClazz);
            }
        }
        resultMap.forEach((key,value)->{
            if(key>0){
                T temp=createBean(clazz,value,fieldNameMap,fieldTypeMap);
                if(temp!=null){
                    result.add(temp);
                }
            }
        });
        return result;
    }

    private <T> T createBean(Class<T> clazz,List<Object> row,Map<Integer,String> fieldNameMap,Map<String,Class> fieldTypeMap){
        if(row==null||row.size()<=0){
            return null;
        }
        T bean=null;
        for(int i=0;i<row.size();i++){
            Object obj=row.get(i);
            if(fieldNameMap.containsKey(i)){
                String fieldName=fieldNameMap.get(i);
                String methodName=getInvokeMethodName(fieldName);
                Class fieldType=fieldTypeMap.get(fieldName);
                try {
                    Method method=clazz.getMethod(methodName,fieldType);
                    if(bean==null){
                        bean=clazz.newInstance();
                    }
                    method.invoke(bean,convert(obj,fieldType));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }

    private String getInvokeMethodName(String fieldName){
        return "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
    }

    private Object convert(Object obj,Class clazz){
        String value=obj.toString();
        if(clazz==String.class){
            return value;
        }
        if(clazz==Integer.TYPE){
            if(StringUtils.isNumeric(value)){
                return Integer.parseInt(value);
            }
            return (int)Math.round(Double.parseDouble(value));
        }
        if(clazz==Double.TYPE){
            return Double.parseDouble(value);
        }
        if(clazz==Float.TYPE){
            return Float.parseFloat(value);
        }
        if(clazz==Long.TYPE){
            return Long.parseLong(value);
        }
        return obj;
    }
}
