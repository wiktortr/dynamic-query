package com.example.dynamicquery.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TransactionRecord(
        Long transactionId,
        BigDecimal transactionAmount,
        BigDecimal transactionFee,
        String transactionAddress,
        String transactionCountry,
        String transactionApprovalStatus,
        String transactionApprovalDate,
        String transactionDate,
        String transactionStatus,
        String transactionCategory,
        String senderAccountNumber,
        String senderAccountCurrency,
        String senderAccountCardNumber,
        String senderAccountCardType,
        String senderCustomerFullname,
        String senderCustomerFirstname,
        String senderCustomerLastname,
        Long senderCustomerAge,
        String senderCustomerRetiredInd,
        String senderCustomerEmail,
        String senderCustomerCountry,
        String senderCustomerPostalCode,
        String senderCustomerPhoneNumber,
        String recipientAccountNumber,
        String recipientAccountCurrency,
        String recipientAccountCardNumber,
        String recipientAccountCardType,
        String recipientCustomerFullname,
        String recipientCustomerFirstname,
        String recipientCustomerLastname,
        Long recipientCustomerAge,
        String recipientCustomerRetiredInd,
        String recipientCustomerEmail,
        String recipientCustomerCountry,
        String recipientCustomerPostalCode,
        String recipientCustomerPhoneNumber
) {
}
