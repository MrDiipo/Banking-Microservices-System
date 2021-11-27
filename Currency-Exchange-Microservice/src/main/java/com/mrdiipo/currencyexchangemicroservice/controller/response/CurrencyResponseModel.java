package com.mrdiipo.currencyexchangemicroservice.controller.response;

import lombok.Builder;
import lombok.Data;

import javax.money.MonetaryAmount;
import java.math.BigDecimal;
@Data
@Builder
public class CurrencyResponseModel {
    private BigDecimal convertedAmount;
}
