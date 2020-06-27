package com.taoge.poi.bean;

/**
 * @author taoxuefeng
 * @date 2019/11/21
 */
public class TypeCode {

    private int id;

    private String typeCode;

    private String bigCateZhName;

    private String midCateZhName;

    private String smCateZhName;

    private String bigCateEnName;

    private String midCateEnName;

    private String subCateEnName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getBigCateZhName() {
        return bigCateZhName;
    }

    public void setBigCateZhName(String bigCateZhName) {
        this.bigCateZhName = bigCateZhName;
    }

    public String getMidCateZhName() {
        return midCateZhName;
    }

    public void setMidCateZhName(String midCateZhName) {
        this.midCateZhName = midCateZhName;
    }

    public String getSmCateZhName() {
        return smCateZhName;
    }

    public void setSmCateZhName(String smCateZhName) {
        this.smCateZhName = smCateZhName;
    }

    public String getBigCateEnName() {
        return bigCateEnName;
    }

    public void setBigCateEnName(String bigCateEnName) {
        this.bigCateEnName = bigCateEnName;
    }

    public String getMidCateEnName() {
        return midCateEnName;
    }

    public void setMidCateEnName(String midCateEnName) {
        this.midCateEnName = midCateEnName;
    }

    public String getSubCateEnName() {
        return subCateEnName;
    }

    public void setSubCateEnName(String subCateEnName) {
        this.subCateEnName = subCateEnName;
    }

    @Override
    public String toString() {
        return "TypeCode{" +
                "id=" + id +
                ", typeCode='" + typeCode + '\'' +
                ", bigCateZhName='" + bigCateZhName + '\'' +
                ", midCateZhName='" + midCateZhName + '\'' +
                ", smCateZhName='" + smCateZhName + '\'' +
                ", midCateEnName='" + midCateEnName + '\'' +
                ", subCateEnName='" + subCateEnName + '\'' +
                '}';
    }
}
