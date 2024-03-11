package com.example.dynamicquery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sender_id", nullable = false)
    @JsonIgnore
    private Account senderAccount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipient_id", nullable = false)
    @JsonIgnore
    private Account recipientAccount;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "fee")
    private BigDecimal fee;

    @Column(name = "address")
    private String address;

    @Column(name = "country")
    private String country;

    @Column(name = "approval_status")
    private String approvalStatus;

    @Column(name = "approval_date")
    private String approvalDate;

    @Column(name = "transaction_date")
    private String transactionDate;

    @Column(name = "status")
    private String status;

    @Column(name = "category")
    private String category;


}