package com.app.daofab.controller;

import com.app.daofab.constant.HttpStatus;
import com.app.daofab.model.PaymentInstallment;
import com.app.daofab.response.PaymentInstallmentResponse;
import com.app.daofab.service.PaymentInstallmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("payments")
public class PaymentInstallmentController {
    private final PaymentInstallmentService paymentInstallmentService;

    public PaymentInstallmentController(PaymentInstallmentService paymentInstallmentService) {
        this.paymentInstallmentService = paymentInstallmentService;
    }

    @GetMapping("/all")
    public ResponseEntity<PaymentInstallmentResponse> getAll() {
        List<PaymentInstallment> paymentInstallments = paymentInstallmentService.findAll();
        return ResponseEntity.ok(new PaymentInstallmentResponse(HttpStatus.SUCCESS_STATUS, HttpStatus.SUCCESS_CODE, paymentInstallments));
    }

    @GetMapping("/{parent_id}")
    public ResponseEntity<PaymentInstallmentResponse> getById(@PathVariable("parent_id") Long parentId) {
        List<PaymentInstallment> paymentInstallment = paymentInstallmentService.findByParentId(parentId);
        return ResponseEntity.ok(new PaymentInstallmentResponse(HttpStatus.SUCCESS_STATUS, HttpStatus.SUCCESS_CODE, paymentInstallment));
    }
}
