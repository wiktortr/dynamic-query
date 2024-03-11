package com.example.dynamicquery.dto;

import com.example.dynamicquery.enums.ColumnKey;

import java.util.List;
import java.util.Set;

public record TransactionRequest(
        Set<ColumnKey> selectedColumns,
        List<FilterRequest> filters,
        Long pageSize) {
}

