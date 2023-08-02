package com.app.daofab.controller;

import com.app.daofab.constant.HttpStatus;
import com.app.daofab.model.TransactionInformation;
import com.app.daofab.response.TransactionInformationResponse;
import com.app.daofab.service.TransactionInformationService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionInformationController {
    private final TransactionInformationService transactionInformationService;

    public TransactionInformationController(TransactionInformationService transactionInformationService) {
        this.transactionInformationService = transactionInformationService;
    }

    @GetMapping("/all")
    public ResponseEntity<TransactionInformationResponse> getAll(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "2") Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = "asc") String sortOrder
    ) {
        return ResponseEntity.ok(this.transactionInformationService.getAll(page, pageSize, sortBy, sortOrder));
    }
}
