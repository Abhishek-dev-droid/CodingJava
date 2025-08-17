package com.example.upispends.service;

import com.example.upispends.domain.Category;
import com.example.upispends.domain.TransactionStatus;
import com.example.upispends.domain.UpiTransaction;
import com.example.upispends.dto.CreateTransactionRequest;
import com.example.upispends.dto.TransactionResponse;
import com.example.upispends.repository.UpiTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UpiTransactionService {
	private final UpiTransactionRepository repository;

	public UpiTransactionService(UpiTransactionRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public TransactionResponse create(CreateTransactionRequest request) {
		UpiTransaction txn = new UpiTransaction();
		txn.setUpiId(request.getUpiId());
		txn.setMerchantOrPeer(request.getMerchantOrPeer());
		txn.setType(request.getType());
		txn.setAmount(request.getAmount());
		txn.setCategory(request.getCategory());
		txn.setReferenceId(request.getReferenceId());
		txn.setStatus(TransactionStatus.SUCCESS);
		txn.setOccurredAt(request.getOccurredAt() != null ? request.getOccurredAt() : LocalDateTime.now());
		txn = repository.save(txn);
		return toResponse(txn);
	}

	@Transactional(readOnly = true)
	public List<TransactionResponse> listAll() {
		return repository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<TransactionResponse> listByDate(LocalDate date) {
		LocalDateTime start = date.atStartOfDay();
		LocalDateTime end = date.atTime(LocalTime.MAX);
		return repository.findByOccurredAtBetween(start, end)
				.stream().map(this::toResponse).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<TransactionResponse> listByCategory(Category category) {
		return repository.findByCategory(category).stream().map(this::toResponse).collect(Collectors.toList());
	}

	private TransactionResponse toResponse(UpiTransaction txn) {
		TransactionResponse r = new TransactionResponse();
		r.setId(txn.getId());
		r.setUpiId(txn.getUpiId());
		r.setMerchantOrPeer(txn.getMerchantOrPeer());
		r.setType(txn.getType());
		r.setStatus(txn.getStatus());
		r.setCategory(txn.getCategory());
		r.setAmount(txn.getAmount());
		r.setOccurredAt(txn.getOccurredAt());
		r.setReferenceId(txn.getReferenceId());
		return r;
	}
}