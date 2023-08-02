package com.app.daofab.repository;

import com.app.daofab.model.TransactionInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionInformationRepository extends JpaRepository<TransactionInformation, Integer> {
}
