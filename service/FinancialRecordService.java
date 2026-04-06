package com.finance.dashboard.service;

import com.finance.dashboard.dto.DashboardResponse;
import com.finance.dashboard.dto.RecordRequest;
import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.entity.Type;
import com.finance.dashboard.repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class FinancialRecordService {

    private final FinancialRecordRepository repo;

    // ✅ Create
    public FinancialRecord createRecord(RecordRequest req) {

        FinancialRecord record = new FinancialRecord();
        record.setAmount(req.getAmount());
        record.setType(req.getType());
        record.setCategory(req.getCategory());
        record.setDate(req.getDate() != null ? req.getDate() : LocalDate.now());
        record.setNotes(req.getNotes());

        return repo.save(record);
    }

    // ✅ Get All / Filter
    public List<FinancialRecord> filterRecords(
            Type type,
            String category,
            LocalDate startDate,
            LocalDate endDate
    ) {
        return repo.filterRecords(type, category, startDate, endDate);
    }

    // ✅ Dashboard Summary
    public DashboardResponse getSummary() {
        Double income = repo.sumByType(Type.INCOME);
        Double expense = repo.sumByType(Type.EXPENSE);

        income = (income == null) ? 0 : income;
        expense = (expense == null) ? 0 : expense;

        return new DashboardResponse(income, expense, income - expense);
    }

    // ✅ Category-wise
    public Map<String, Double> getCategoryWiseTotals() {
        Map<String, Double> result = new HashMap<>();

        for (Object[] row : repo.getCategoryWiseTotals()) {
            result.put((String) row[0], (Double) row[1]);
        }

        return result;
    }
}