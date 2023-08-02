package com.app.daofab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Table(name = "PAYMENT_INSTALLMENT")
@Entity
public class PaymentInstallment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PAID_AMOUNT")
    private Long paidAmount;

    @Column(name = "PARENT_ID")
    private Integer parentId;

    @Transient
    private String sender;

    @Transient
    private String receiver;

    @Transient
    private Long totalAmount;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID", insertable = false, updatable = false)
    @JsonIgnore
    private TransactionInformation parent;

    public PaymentInstallment() {
    }

    public PaymentInstallment(Long paidAmount, TransactionInformation parent) {
        this.paidAmount = paidAmount;
        this.parent = parent;
    }

    public PaymentInstallment(Integer id, Long paidAmount, TransactionInformation parent) {
        this.id = id;
        this.paidAmount = paidAmount;
        this.parent = parent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSender() {
        return parent.getSender();
    }

    public String getReceiver() {
        return parent.getReceiver();
    }

    public Long getTotalAmount() {
        return parent.getTotalAmount();
    }

    public Long getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Long paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public TransactionInformation getParent() {
        return parent;
    }

    public void setParent(TransactionInformation parent) {
        this.parent = parent;
    }

}
