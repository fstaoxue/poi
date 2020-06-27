package com.taoge.poi.exception;

import com.taoge.poi.bean.PoiParseStatus;

/**
 * @author taoxuefeng
 * @date 2019/11/25
 */
public class PoiParseException extends Exception{

    private PoiParseStatus status;

    private String msg;

    public PoiParseException(PoiParseStatus status){
        this.status=status;
    }

    public PoiParseException(PoiParseStatus status,String msg){
        this.status=status;
        this.msg=msg;
    }

    public PoiParseStatus getStatus() {
        return status;
    }

    public void setStatus(PoiParseStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
