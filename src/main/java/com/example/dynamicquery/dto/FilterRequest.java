package com.example.dynamicquery.dto;

import com.example.dynamicquery.enums.ColumnKey;
import com.example.dynamicquery.enums.FilterType;

public record FilterRequest(
        ColumnKey column,
        FilterType type,
        String value
) {
}

