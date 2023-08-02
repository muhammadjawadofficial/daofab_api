package com.app.daofab.repository;

import com.app.daofab.model.PaymentInstallment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentInstallmentRepository extends JpaRepository<PaymentInstallment, Integer> {
    List<PaymentInstallment> findByParentId(Long parentId);
}
