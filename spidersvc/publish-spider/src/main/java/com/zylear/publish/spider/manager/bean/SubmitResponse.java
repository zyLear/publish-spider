package com.zylear.publish.spider.manager.bean;

/**
 * Created by xiezongyu on 2018/8/12.
 */
public class SubmitResponse  {

    private Integer refId;
    private Integer errorCode;
    private String errorMessage;


    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getRefId() {
        return refId;
    }

    public void setRefId(Integer refId) {
        this.refId = refId;
    }
}
