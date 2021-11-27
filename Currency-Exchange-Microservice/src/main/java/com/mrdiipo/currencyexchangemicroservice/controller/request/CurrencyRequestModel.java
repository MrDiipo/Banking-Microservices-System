package com.mrdiipo.currencyexchangemicroservice.controller.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CurrencyRequestModel {
    private BigDecimal amount;
    private String from;
    private String to;
}
