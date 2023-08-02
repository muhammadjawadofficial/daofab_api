package com.app.daofab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Table(name = "TRANSACTION_INFORMATION")
@Entity
public class TransactionInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "SENDER")
    private String sender;

    @Column(name = "RECEIVER")
    private String receiver;

    @Column(name = "TOTAL_AMOUNT")
    private Long totalAmount;

    @OneToMany(mappedBy = "parent")
    @JsonIgnore
    Set<PaymentInstallment> installmentList;

    public TransactionInformation() {
    }

    public TransactionInformation(String sender, String receiver, Long totalAmount) {
        this.sender = sender;
        this.receiver = receiver;
        this.totalAmount = totalAmount;
    }

    public TransactionInformation(Integer id, String sender, String receiver, Long totalAmount) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.totalAmount = totalAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getTotalPaidAmount() {
        return installmentList.stream().mapToLong(PaymentInstallment::getPaidAmount).sum();
    }

    public Set<PaymentInstallment> getInstallmentList() {
        return installmentList;
    }
}
