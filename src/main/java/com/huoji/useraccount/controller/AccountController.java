package com.huoji.useraccount.controller;

import com.huoji.useraccount.model.Account;
import com.huoji.useraccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping
	public List<Account> getAccounts(Principal principal) {
		return accountService.getAccounts(principal.getName());
	}

	@PostMapping
	public Account createAccount(@RequestBody Account newAccount, Principal principal) {
		return accountService.addAccount(newAccount, principal.getName());
	}

}
