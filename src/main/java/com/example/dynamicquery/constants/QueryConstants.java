package com.example.dynamicquery.constants;

import com.example.dynamicquery.entity.QAccount;
import com.example.dynamicquery.entity.QCustomer;
import com.example.dynamicquery.entity.QTransaction;

public class QueryConstants {
    public static final QTransaction Q_TRANSACTION = QTransaction.transaction;
    public static final QAccount Q_SENDER_ACCOUNT = QTransaction.transaction.senderAccount;
    public static final QCustomer Q_SENDER_CUSTOMER = QTransaction.transaction.senderAccount.customer;
    public static final QAccount Q_RECIPIENT_ACCOUNT = QTransaction.transaction.recipientAccount;
    public static final QCustomer Q_RECIPIENT_CUSTOMER = QTransaction.transaction.recipientAccount.customer;
}
