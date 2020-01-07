package com.spectrum.crm.util;

public class CommonResult<T> {

    private T data;
    private String message;
    private String code;

    public CommonResult(){}

    public CommonResult(T data, String message, String code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public CommonResult(String message, String code) {
        this(null, message, code);
    }

    public CommonResult(T data) {
        this(data, "操作成功", "00000");
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
