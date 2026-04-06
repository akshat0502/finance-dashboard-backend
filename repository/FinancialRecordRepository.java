package com.finance.dashboard.repository;

import com.finance.dashboard.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {

    @Query("SELECT SUM(f.amount) FROM FinancialRecord f WHERE f.type = :type")
    Double sumByType(@Param("type") Type type);

    @Query("SELECT f FROM FinancialRecord f WHERE " +
            "(:type IS NULL OR f.type = :type) AND " +
            "(:category IS NULL OR f.category = :category) AND " +
            "(:startDate IS NULL OR f.date >= :startDate) AND " +
            "(:endDate IS NULL OR f.date <= :endDate)")
    List<FinancialRecord> filterRecords(
            @Param("type") Type type,
            @Param("category") String category,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    @Query("SELECT f.category, SUM(f.amount) FROM FinancialRecord f GROUP BY f.category")
    List<Object[]> getCategoryWiseTotals();
}