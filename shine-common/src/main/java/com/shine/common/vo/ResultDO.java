package com.shine.common.vo;

import java.io.Serializable;

public class ResultDO<T> implements Serializable {
    private Boolean isSuccess;
    private String errorMsg;
    private T obj;

    public ResultDO() {
        this.isSuccess = true;
    }
    public ResultDO(T result) {
        this.isSuccess = true;
        this.obj = result;
    }

    public ResultDO(Boolean isSuccess, String errorMsg) {
        this.isSuccess = isSuccess;
        this.errorMsg = errorMsg;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
