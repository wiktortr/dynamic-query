package com.example.dynamicquery.fields;

import com.example.dynamicquery.dto.FilterRequest;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Expression;

public abstract class QueryField {

    public abstract Expression<?> getExpression();

    public abstract void applyFilter(BooleanBuilder builder, FilterRequest request);

}
