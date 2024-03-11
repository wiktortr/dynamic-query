package com.example.dynamicquery.enums;

import com.example.dynamicquery.fields.*;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

import static com.example.dynamicquery.constants.QueryConstants.*;

@Getter
@AllArgsConstructor
public enum ColumnKey {

    TRANSACTION_ID("transactionId", new LongQueryField(Q_TRANSACTION.id)),
    TRANSACTION_AMOUNT("transactionAmount", new BigDecimalQueryField(Q_TRANSACTION.amount)),
    TRANSACTION_FEE("transactionFee", new BigDecimalQueryField(Q_TRANSACTION.fee)),
    TRANSACTION_ADDRESS("transactionAddress", new TextQueryField(Q_TRANSACTION.address)),
    TRANSACTION_COUNTRY("transactionCountry", new TextQueryField(Q_TRANSACTION.country)),
    TRANSACTION_APPROVAL_STATUS("transactionApprovalStatus", new TextQueryField(Q_TRANSACTION.approvalStatus)),
    TRANSACTION_APPROVAL_DATE("transactionApprovalDate", new TextQueryField(Q_TRANSACTION.approvalDate)),
    TRANSACTION_DATE("transactionDate", new TextQueryField(Q_TRANSACTION.transactionDate)),
    TRANSACTION_STATUS("transactionStatus", new TextQueryField(Q_TRANSACTION.status)),
    TRANSACTION_CATEGORY("transactionCategory", new TextQueryField(Q_TRANSACTION.category)),
    SENDER_ACCOUNT_NUMBER("senderAccountNumber", new TextQueryField(Q_SENDER_ACCOUNT.accountNumber)),
    SENDER_ACCOUNT_CURRENCY("senderAccountCurrency", new TextQueryField(Q_SENDER_ACCOUNT.currency)),
    SENDER_ACCOUNT_CARD_NUMBER("senderAccountCardNumber", new TextQueryField(Q_SENDER_ACCOUNT.cardNumber)),
    SENDER_ACCOUNT_CARD_TYPE("senderAccountCardType", new TextQueryField(Q_SENDER_ACCOUNT.cardType)),
    SENDER_CUSTOMER_FULLNAME("senderCustomerFullname", new TextQueryField(
            Q_SENDER_CUSTOMER.firstname
                    .append(Expressions.constant(" "))
                    .append(Q_SENDER_CUSTOMER.lastname)
    )),
    SENDER_CUSTOMER_FIRSTNAME("senderCustomerFirstname", new TextQueryField(Q_SENDER_CUSTOMER.firstname)),
    SENDER_CUSTOMER_LASTNAME("senderCustomerLastname", new TextQueryField(Q_SENDER_CUSTOMER.lastname)),
    SENDER_CUSTOMER_AGE("senderCustomerAge", new LongQueryField(Q_SENDER_CUSTOMER.age)),
    SENDER_CUSTOMER_RETIRED_IND("senderCustomerRetiredInd", new SetQueryField(
            new CaseBuilder()
                    .when(Q_SENDER_CUSTOMER.age.goe(65)).then("Y")
                    .otherwise("N"),
            Set.of("Y", "N")
    )),
    SENDER_CUSTOMER_EMAIL("senderCustomerEmail", new TextQueryField(Q_SENDER_CUSTOMER.email)),
    SENDER_CUSTOMER_COUNTRY("senderCustomerCountry", new TextQueryField(Q_SENDER_CUSTOMER.country)),
    SENDER_CUSTOMER_POSTAL_CODE("senderCustomerPostalCode", new TextQueryField(Q_SENDER_CUSTOMER.postalCode)),
    SENDER_CUSTOMER_PHONE_NUMBER("senderCustomerPhoneNumber", new TextQueryField(Q_SENDER_CUSTOMER.phoneNumber)),
    RECIPIENT_ACCOUNT_NUMBER("recipientAccountNumber", new TextQueryField(Q_RECIPIENT_ACCOUNT.accountNumber)),
    RECIPIENT_ACCOUNT_CURRENCY("recipientAccountCurrency", new TextQueryField(Q_RECIPIENT_ACCOUNT.currency)),
    RECIPIENT_ACCOUNT_CARD_NUMBER("recipientAccountCardNumber", new TextQueryField(Q_RECIPIENT_ACCOUNT.cardNumber)),
    RECIPIENT_ACCOUNT_CARD_TYPE("recipientAccountCardType", new TextQueryField(Q_RECIPIENT_ACCOUNT.cardType)),
    RECIPIENT_CUSTOMER_FULLNAME("recipientCustomerFullname", new TextQueryField(
            Q_RECIPIENT_CUSTOMER.firstname
                    .append(Expressions.constant(" "))
                    .append(Q_RECIPIENT_CUSTOMER.lastname)
    )),
    RECIPIENT_CUSTOMER_FIRSTNAME("recipientCustomerFirstname", new TextQueryField(Q_RECIPIENT_CUSTOMER.firstname)),
    RECIPIENT_CUSTOMER_LASTNAME("recipientCustomerLastname", new TextQueryField(Q_RECIPIENT_CUSTOMER.lastname)),
    RECIPIENT_CUSTOMER_AGE("recipientCustomerAge", new LongQueryField(Q_RECIPIENT_CUSTOMER.age)),
    RECIPIENT_CUSTOMER_RETIRED_IND("recipientCustomerRetiredInd", new SetQueryField(
            new CaseBuilder()
                    .when(Q_RECIPIENT_CUSTOMER.age.goe(65)).then("Y")
                    .otherwise("N"),
            Set.of("Y", "N")
    )),
    RECIPIENT_CUSTOMER_EMAIL("recipientCustomerEmail", new TextQueryField(Q_RECIPIENT_CUSTOMER.email)),
    RECIPIENT_CUSTOMER_COUNTRY("recipientCustomerCountry", new TextQueryField(Q_RECIPIENT_CUSTOMER.country)),
    RECIPIENT_CUSTOMER_POSTAL_CODE("recipientCustomerPostalCode", new TextQueryField(Q_RECIPIENT_CUSTOMER.postalCode)),
    RECIPIENT_CUSTOMER_PHONE_NUMBER("recipientCustomerPhoneNumber", new TextQueryField(Q_RECIPIENT_CUSTOMER.phoneNumber)),
    ;

    private final String fieldName;
    private final QueryField queryField;

    public static Optional<ColumnKey> getByFieldName(String fieldName) {
        return Arrays.stream(ColumnKey.values())
                .filter(columnKey -> columnKey.getFieldName().equalsIgnoreCase(fieldName))
                .findFirst();
    }

}
