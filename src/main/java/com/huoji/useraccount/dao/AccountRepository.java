package com.huoji.useraccount.dao;

import com.huoji.useraccount.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	List<Account> findAccountsById(int i);

	List<Account> findAccountsByUserEmail(String email);

}
