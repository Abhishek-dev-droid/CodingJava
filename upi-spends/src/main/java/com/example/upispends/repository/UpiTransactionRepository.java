package com.example.upispends.repository;

import com.example.upispends.domain.Category;
import com.example.upispends.domain.UpiTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface UpiTransactionRepository extends JpaRepository<UpiTransaction, Long> {
	List<UpiTransaction> findByUpiId(String upiId);
	List<UpiTransaction> findByCategory(Category category);
	List<UpiTransaction> findByOccurredAtBetween(LocalDateTime start, LocalDateTime end);

	@Query("select coalesce(sum(t.amount),0) from UpiTransaction t where t.category = ?1 and t.occurredAt between ?2 and ?3")
	BigDecimal sumAmountByCategoryAndPeriod(Category category, LocalDateTime start, LocalDateTime end);
}