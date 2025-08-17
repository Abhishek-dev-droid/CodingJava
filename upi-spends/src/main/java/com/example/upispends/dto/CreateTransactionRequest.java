package com.example.upispends.dto;

import com.example.upispends.domain.Category;
import com.example.upispends.domain.TransactionType;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateTransactionRequest {
	@NotBlank
	private String upiId;

	@NotBlank
	private String merchantOrPeer;

	@NotNull
	private TransactionType type;

	@NotNull
	@Positive
	private BigDecimal amount;

	private Category category = Category.OTHER;

	private String referenceId;

	private LocalDateTime occurredAt; // optional; default now

	public String getUpiId() { return upiId; }
	public void setUpiId(String upiId) { this.upiId = upiId; }

	public String getMerchantOrPeer() { return merchantOrPeer; }
	public void setMerchantOrPeer(String merchantOrPeer) { this.merchantOrPeer = merchantOrPeer; }

	public TransactionType getType() { return type; }
	public void setType(TransactionType type) { this.type = type; }

	public BigDecimal getAmount() { return amount; }
	public void setAmount(BigDecimal amount) { this.amount = amount; }

	public Category getCategory() { return category; }
	public void setCategory(Category category) { this.category = category; }

	public String getReferenceId() { return referenceId; }
	public void setReferenceId(String referenceId) { this.referenceId = referenceId; }

	public LocalDateTime getOccurredAt() { return occurredAt; }
	public void setOccurredAt(LocalDateTime occurredAt) { this.occurredAt = occurredAt; }
}