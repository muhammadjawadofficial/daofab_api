package com.app.daofab.response;

import com.app.daofab.model.PaymentInstallment;

import java.util.List;

public class PaymentInstallmentResponse extends BaseResponse {
    private List<PaymentInstallment> data;

    public PaymentInstallmentResponse() {
    }

    public PaymentInstallmentResponse(Boolean success, Integer status, List<PaymentInstallment> data) {
        super(success, status);
        this.data = data;
    }

    public List<PaymentInstallment> getData() {
        return data;
    }

    public void setData(List<PaymentInstallment> data) {
        this.data = data;
    }
}
