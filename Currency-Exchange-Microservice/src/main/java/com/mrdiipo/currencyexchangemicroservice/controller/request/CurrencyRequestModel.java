package com.mrdiipo.currencyexchangemicroservice.controller.request;

import lombok.Builder;
import lombok.Data;

import javax.money.MonetaryAmount;
import java.math.BigDecimal;

@Data
@Builder
public class CurrencyRequestModel {
    private BigDecimal value;
    private String from;
    private String to;
}
