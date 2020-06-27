package com.taoge.poi.bean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author taoxuefeng
 * @date 2019/11/17
 */
public class QueryPoiInfo {

    private int count;

    private Map<String,String> params;

    private String url;

    private LocalDateTime queryStartTime;

    private LocalDateTime queryEndTime;

    private List<PoiInfo> allPoiInfoList;

    public QueryPoiInfo(){}

    public QueryPoiInfo(String url,Map<String,String> params){
        this.url=url;
        this.params=params;
        this.queryStartTime=LocalDateTime.now();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getQueryStartTime() {
        return queryStartTime;
    }

    public void setQueryStartTime(LocalDateTime queryStartTime) {
        this.queryStartTime = queryStartTime;
    }

    public LocalDateTime getQueryEndTime() {
        return queryEndTime;
    }

    public void setQueryEndTime(LocalDateTime queryEndTime) {
        this.queryEndTime = queryEndTime;
    }

    public List<PoiInfo> getAllPoiInfoList() {
        return allPoiInfoList;
    }

    public void setAllPoiInfoList(List<PoiInfo> allPoiInfoList) {
        this.allPoiInfoList = allPoiInfoList;
    }
}
