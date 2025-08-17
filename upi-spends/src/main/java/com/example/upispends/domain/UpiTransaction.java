package com.example.upispends.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "upi_transaction")
public class UpiTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false)
	private String upiId; // payer/payee UPI

	@NotBlank
	@Column(nullable = false)
	private String merchantOrPeer; // counterparty

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 16)
	private TransactionType type;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 16)
	private TransactionStatus status = TransactionStatus.SUCCESS;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 24)
	private Category category = Category.OTHER;

	@NotNull
	@Positive
	@Column(nullable = false, precision = 18, scale = 2)
	private BigDecimal amount;

	@NotNull
	@Column(nullable = false)
	private LocalDateTime occurredAt = LocalDateTime.now();

	@Column(length = 64)
	private String referenceId; // UTR or txn reference

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getUpiId() { return upiId; }
	public void setUpiId(String upiId) { this.upiId = upiId; }

	public String getMerchantOrPeer() { return merchantOrPeer; }
	public void setMerchantOrPeer(String merchantOrPeer) { this.merchantOrPeer = merchantOrPeer; }

	public TransactionType getType() { return type; }
	public void setType(TransactionType type) { this.type = type; }

	public TransactionStatus getStatus() { return status; }
	public void setStatus(TransactionStatus status) { this.status = status; }

	public Category getCategory() { return category; }
	public void setCategory(Category category) { this.category = category; }

	public BigDecimal getAmount() { return amount; }
	public void setAmount(BigDecimal amount) { this.amount = amount; }

	public LocalDateTime getOccurredAt() { return occurredAt; }
	public void setOccurredAt(LocalDateTime occurredAt) { this.occurredAt = occurredAt; }

	public String getReferenceId() { return referenceId; }
	public void setReferenceId(String referenceId) { this.referenceId = referenceId; }
}