package com.huoji.useraccount.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private Account account;
	@Column(nullable = false)
	private Double amount;
	private String type;
	private String status;
	private String category;
	private String description;
	private LocalDate date;
	private String merchantName;


	public Transaction(Account account, Double amount, String type, String status, String category, String description,
	                   LocalDate date, String merchantName) {
		this.account = account;
		this.amount = amount;
		this.type = type;
		this.status = status;
		this.category = category;
		this.description = description;
		this.date = date;
		this.merchantName = merchantName;
	}
}
