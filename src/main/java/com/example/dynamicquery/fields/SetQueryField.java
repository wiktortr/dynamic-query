package com.example.dynamicquery.fields;

import com.example.dynamicquery.dto.FilterRequest;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.StringExpression;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SetQueryField extends QueryField {

    private StringExpression expression;
    private Set<String> availableValues;

    @Override
    public Expression<?> getExpression() {
        return expression;
    }

    @Override
    public void applyFilter(BooleanBuilder builder, FilterRequest request) {

        var values = Arrays.stream(request.value().split(";"))
                .map(String::toUpperCase)
                .filter(availableValues::contains)
                .collect(Collectors.toSet());

        builder.and(expression.upper().in(values));

    }

}
