package com.example.dynamicquery.fields;

import com.example.dynamicquery.dto.FilterRequest;
import com.example.dynamicquery.enums.FilterType;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.NumberExpression;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LongQueryField extends QueryField {

    private NumberExpression<Long> expression;

    @Override
    public Expression<?> getExpression() {
        return expression;
    }

    @Override
    public void applyFilter(BooleanBuilder builder, FilterRequest request) {

        var value = Long.valueOf(request.value());

        if (request.type().equals(FilterType.EQUALS)) {
            builder.and(expression.eq(value));
        }

        if (request.type().equals(FilterType.GREATER_THAN)) {
            builder.and(expression.gt(value));
        }

        if (request.type().equals(FilterType.LESS_THAN)) {
            builder.and(expression.lt(value));
        }

    }

}
