package com.app.daofab.service;

import com.app.daofab.model.PaymentInstallment;
import com.app.daofab.repository.PaymentInstallmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentInstallmentService {
    private final PaymentInstallmentRepository paymentInstallmentRepository;

    public PaymentInstallmentService(PaymentInstallmentRepository paymentInstallmentRepository) {
        this.paymentInstallmentRepository = paymentInstallmentRepository;
    }

    public List<PaymentInstallment> findAll() {
        return paymentInstallmentRepository.findAll();
    }

    public List<PaymentInstallment> findByParentId(Long parentId) {
        return paymentInstallmentRepository.findByParentId(parentId);
    }
}
