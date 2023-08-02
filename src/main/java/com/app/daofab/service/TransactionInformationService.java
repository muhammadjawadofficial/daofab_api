package com.app.daofab.service;

import com.app.daofab.constant.HttpStatus;
import com.app.daofab.model.TransactionInformation;
import com.app.daofab.repository.TransactionInformationRepository;
import com.app.daofab.response.TransactionInformationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionInformationService {
    private final TransactionInformationRepository transactionInformationRepository;

    public TransactionInformationService(TransactionInformationRepository transactionInformationRepository) {
        this.transactionInformationRepository = transactionInformationRepository;
    }

    public TransactionInformationResponse getAll(Integer page, Integer pageSize, String sortBy, String sortOrder) {
        Sort sort = Sort.by(sortBy);
        sort = sortOrder.equalsIgnoreCase("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        Page<TransactionInformation> pageResult = transactionInformationRepository.findAll(pageable);
        long totalRecords = pageResult.getTotalElements();
        List<TransactionInformation> transactionInformationList = pageResult.stream().toList();

        return new TransactionInformationResponse(HttpStatus.SUCCESS_STATUS, HttpStatus.SUCCESS_CODE, totalRecords, transactionInformationList);
    }
}
