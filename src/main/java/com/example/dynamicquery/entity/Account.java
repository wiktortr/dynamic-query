package com.example.dynamicquery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "accounts")
@Data
public class Account {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy = "senderAccount", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Transaction> transactionsAsSender;

    @OneToMany(mappedBy = "recipientAccount", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Transaction> transactionsAsRecipient;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "card_type", nullable = false)
    private String cardType;

}

