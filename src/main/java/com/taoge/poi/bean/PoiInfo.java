package com.taoge.poi.bean;

/**
 * @author taoxuefeng
 * @date 2019/11/25
 */
public class PoiInfo {

    private String id;

    private String name;

    private String address;

    private String type;

    private String typeCode;

    private String adName;

    private String pName;

    private String tel;

    private String location;

    private String cityName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "PoiInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", adName='" + adName + '\'' +
                ", pName='" + pName + '\'' +
                ", tel='" + tel + '\'' +
                ", location='" + location + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
