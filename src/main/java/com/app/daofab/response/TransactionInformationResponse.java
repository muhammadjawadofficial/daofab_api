package com.app.daofab.response;

import com.app.daofab.model.TransactionInformation;

import java.util.List;

public class TransactionInformationResponse extends BaseResponse {
    private long totalRecords;
    private List<TransactionInformation> data;

    public TransactionInformationResponse() {
    }

    public TransactionInformationResponse(Boolean success, Integer status, long totalRecords, List<TransactionInformation> data) {
        super(success, status);
        this.totalRecords = totalRecords;
        this.data = data;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<TransactionInformation> getData() {
        return data;
    }

    public void setData(List<TransactionInformation> data) {
        this.data = data;
    }
}
