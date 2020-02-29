package com.syx.nian.demo.ali.core.util;

import java.io.Serializable;
import java.util.Map;

public class R<T> implements Serializable {
    public static final int ERROR_CODE=500;
    public static final int SUCCESS_CODE=200;
    public static final String COMMON_ERROR_MSG="系统异常";
    public static final int CODE_NOT_EXIST = 501 ;//对象不存在
    private int code;
    private String msg;
    private T date;

    public static R<String> OK(String id){
        R<String> r = new R<String>();
        r.setDate(id);
        r.setCode(SUCCESS_CODE);
        return r;
    }


    public static <T> R<T> OK(T data){
        R<T> r = new R<T>();
        r.setDate(data);
        r.setMsg("操作成功!");
        r.setCode(SUCCESS_CODE);
        return r;
    }

    public static <T> R<T> OK(T data,String msg){
        R<T> r = new R<T>();
        r.setDate(data);
        r.setMsg(msg);
        r.setCode(SUCCESS_CODE);
        return r;
    }


    public static <T> R<Map<String,T>> MAP(Map<String,T> data){
        R<Map<String,T>> r = new R<Map<String,T>>();
        r.setDate(data);
        r.setCode(SUCCESS_CODE);
        return r;
    }


    public static  R<String> OK(){
        R<String> r = new R<String>();
        r.setCode(SUCCESS_CODE);
        return r;
    }


    public static <T> R<T> K(T date){
        R<T> r = new R<T>();
        r.setDate(date);
        r.setCode(SUCCESS_CODE);
        return r;
    }

    public static  R<String> ERROR(String msg){
        R<String> r = new R<String>();
        r.setCode(ERROR_CODE);
        r.setMsg(msg);
        return r;
    }

    public static  R<String> ERROR(){
        R<String> r = new R<String>();
        r.setCode(ERROR_CODE);
        r.setMsg(COMMON_ERROR_MSG);
        return r;
    }

    public static  R<?> ERROR(int code,String msg){
        R<String> r = new R<String>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
