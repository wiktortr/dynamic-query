package com.example.dynamicquery.dto;

import java.util.List;

public record TransactionResponse(
        Long totalCount,
        Long filteredCount,
        List<TransactionRecord> records
) {
}
