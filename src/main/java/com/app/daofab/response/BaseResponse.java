package com.app.daofab.response;

public class BaseResponse {
    private Boolean success;
    private Integer status;

    public BaseResponse() {
    }

    public BaseResponse(Boolean success, Integer status) {
        this.success = success;
        this.status = status;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
