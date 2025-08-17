package com.example.upispends.controller;

import com.example.upispends.domain.Category;
import com.example.upispends.dto.CreateTransactionRequest;
import com.example.upispends.dto.TransactionResponse;
import com.example.upispends.service.UpiTransactionService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class UpiTransactionController {
	private final UpiTransactionService service;

	public UpiTransactionController(UpiTransactionService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<TransactionResponse> create(@Valid @RequestBody CreateTransactionRequest request) {
		TransactionResponse response = service.create(request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping
	public List<TransactionResponse> listAll() {
		return service.listAll();
	}

	@GetMapping("/by-date")
	public List<TransactionResponse> listByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return service.listByDate(date);
	}

	@GetMapping("/by-category/{category}")
	public List<TransactionResponse> listByCategory(@PathVariable("category") Category category) {
		return service.listByCategory(category);
	}
}