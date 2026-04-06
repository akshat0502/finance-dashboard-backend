package com.finance.dashboard.controller;

import com.finance.dashboard.entity.Type;
import com.finance.dashboard.service.FinancialRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/records")
@RequiredArgsConstructor
public class FinancialRecordController {

    private final FinancialRecordService service;

    @PostMapping
    public Object create(@RequestBody com.finance.dashboard.dto.RecordRequest request) {
        return service.createRecord(request);
    }

    @GetMapping
    public Object getRecords(
            @RequestParam(required = false) Type type,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate
    ) {
        return service.filterRecords(type, category, startDate, endDate);
    }
}