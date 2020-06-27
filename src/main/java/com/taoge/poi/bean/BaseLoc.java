package com.taoge.poi.bean;

import com.taoge.poi.util.CheckUtil;

/**
 * @author taoxuefeng
 * @date 2019/11/27
 */
public class BaseLoc {

    /**
     * 纬度
     */
    private double lat;

    /**
     * 经度
     */
    private double lng;

    public BaseLoc(){}

    public BaseLoc(double lat,double lng){
        this.lat=lat;
        this.lng=lng;
    }

    public BaseLoc(String lng,String lat){
        if(CheckUtil.isNumber(lat)){
            this.lat=Double.parseDouble(lat);
        }
        if(CheckUtil.isNumber(lng)){
            this.lng=Double.parseDouble(lng);
        }
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "BaseLoc{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
