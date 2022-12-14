package com.huoji.useraccount.service;

import com.huoji.useraccount.dao.AccountRepository;
import com.huoji.useraccount.dao.UserRepository;
import com.huoji.useraccount.model.Account;
import com.huoji.useraccount.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private UserRepository userRepository;

	public Account addAccount(Account account, String email) {
		Optional<User> op = userRepository.getUserByEmail(email);
		op.ifPresent(user -> account.setUser(user));
		return accountRepository.save(account);
	}

	public List<Account> getAccounts(String email) {
		return accountRepository.findAccountsByUserEmail(email);
	}

}
