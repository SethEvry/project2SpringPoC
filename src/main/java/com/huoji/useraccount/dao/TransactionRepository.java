package com.huoji.useraccount.dao;

import com.huoji.useraccount.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
