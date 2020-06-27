package com.taoge.poi;

import com.taoge.poi.bean.PoiInfo;
import com.taoge.poi.service.CommonQueryPoiService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class PoiInfoTest {

    @Test
    public void getPoiInfo(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.taoge.poi");
        String fileName="AMap_adcode_citycode.xlsx";
        CommonQueryPoiService commonQueryPoiService=applicationContext.getBean(CommonQueryPoiService.class);
        List<PoiInfo> poiInfoList=commonQueryPoiService.queryPoi(39.993015,116.473168,100);
        commonQueryPoiService.insert(poiInfoList);
        System.out.println(poiInfoList.size());

    }
}
