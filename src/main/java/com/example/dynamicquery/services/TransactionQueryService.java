package com.example.dynamicquery.services;

import com.example.dynamicquery.dto.TransactionRecord;
import com.example.dynamicquery.dto.TransactionRequest;
import com.example.dynamicquery.entity.QTransaction;
import com.example.dynamicquery.enums.ColumnKey;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionQueryService {

    private final JPAQueryFactory queryFactory;

    public Long countAllTransactions() {
        return queryFactory
                .select(QTransaction.transaction.count())
                .from(QTransaction.transaction)
                .fetchFirst();
    }

    public Long countFilteredTransactions(TransactionRequest request) {
        return queryFactory
                .select(QTransaction.transaction.count())
                .from(QTransaction.transaction)
                .where(buildPredicate(request))
                .fetchFirst();
    }

    public List<TransactionRecord> getTransactions(TransactionRequest request) {
        return queryFactory
                .select(buildProjection(request))
                .from(QTransaction.transaction)
                .where(buildPredicate(request))
                .limit(request.pageSize())
                .fetch();
    }

    private Predicate buildPredicate(TransactionRequest request) {
        var builder = new BooleanBuilder();

        if (request.filters() == null) {
            return builder.getValue();
        }

        request.filters()
                .forEach(filter -> filter.column()
                        .getQueryField()
                        .applyFilter(builder, filter));

        return builder.getValue();

    }

    private Expression<TransactionRecord> buildProjection(TransactionRequest request) {

        var selectExpressions = Arrays.stream(TransactionRecord.class.getDeclaredFields())
                .map(field -> getSelectExpression(field, request))
                .toArray(Expression<?>[]::new);

        return Projections.constructor(
                TransactionRecord.class,
                selectExpressions
        );

    }

    private Expression<?> getSelectExpression(Field field, TransactionRequest request) {
        var columnDefOpt = ColumnKey.getByFieldName(field.getName());

        if (columnDefOpt.isEmpty()) {
            return Expressions.nullExpression(field.getType());
        }

        var columnDef = columnDefOpt.get();

        if (request.selectedColumns().contains(columnDef)) {
            return columnDef.getQueryField().getExpression();
        }

        return Expressions.nullExpression(field.getType());
    }

}
