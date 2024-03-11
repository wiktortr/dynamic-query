package com.example.dynamicquery.controllers;

import com.example.dynamicquery.dto.TransactionRequest;
import com.example.dynamicquery.dto.TransactionResponse;
import com.example.dynamicquery.services.TransactionQueryService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TransactionController {

    private final TransactionQueryService transactionQueryService;

    @PostMapping(value = "/api/transactions", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> queryTransactions(@RequestBody TransactionRequest transactionRequest) {

        var totalCount = transactionQueryService.countAllTransactions();
        var filteredCount = transactionQueryService.countFilteredTransactions(transactionRequest);
        var result = transactionQueryService.getTransactions(transactionRequest);

        return ResponseEntity.ok(new TransactionResponse(totalCount, filteredCount, result));
    }

}
