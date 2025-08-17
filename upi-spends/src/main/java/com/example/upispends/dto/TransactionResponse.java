package com.example.upispends.dto;

import com.example.upispends.domain.Category;
import com.example.upispends.domain.TransactionStatus;
import com.example.upispends.domain.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponse {
	private Long id;
	private String upiId;
	private String merchantOrPeer;
	private TransactionType type;
	private TransactionStatus status;
	private Category category;
	private BigDecimal amount;
	private LocalDateTime occurredAt;
	private String referenceId;

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