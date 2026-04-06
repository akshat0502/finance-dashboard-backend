package com.finance.dashboard.dto;

import com.finance.dashboard.entity.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RecordRequest {

    @NotNull
    private Double amount;

    @NotNull
    private Type type;

    @NotBlank
    private String category;

    private LocalDate date;
    private String notes;
}