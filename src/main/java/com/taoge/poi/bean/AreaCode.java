package com.taoge.poi.bean;

/**
 * @author taoxuefeng
 * @date 2019/11/19
 * 城市编码类
 */
public class AreaCode {

    private String areaName;

    private String adCode;

    private String cityCode;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Override
    public String toString() {
        return "AreaCode{" +
                "areaName='" + areaName + '\'' +
                ", adCode='" + adCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                '}';
    }
}
