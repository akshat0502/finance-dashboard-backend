package com.finance.dashboard.controller;

import com.finance.dashboard.service.FinancialRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final FinancialRecordService service;

    @GetMapping("/summary")
    public Object summary() {
        return service.getSummary();
    }

    @GetMapping("/category-wise")
    public Object categoryWise() {
        return service.getCategoryWiseTotals();
    }
}