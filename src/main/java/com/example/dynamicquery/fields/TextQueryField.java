package com.example.dynamicquery.fields;

import com.example.dynamicquery.dto.FilterRequest;
import com.example.dynamicquery.enums.FilterType;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.StringExpression;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TextQueryField extends QueryField {

    private StringExpression expression;

    @Override
    public Expression<?> getExpression() {
        return expression;
    }

    @Override
    public void applyFilter(BooleanBuilder builder, FilterRequest request) {

        if (request.type().equals(FilterType.EQUALS)) {
            builder.and(expression.equalsIgnoreCase(request.value()));
        }

        if (request.type().equals(FilterType.CONTAINS)) {
            builder.and(expression.containsIgnoreCase(request.value()));
        }

    }

}
