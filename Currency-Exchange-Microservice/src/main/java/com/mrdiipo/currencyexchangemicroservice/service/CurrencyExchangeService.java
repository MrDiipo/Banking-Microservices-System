package com.mrdiipo.currencyexchangemicroservice.service;

import java.io.IOException;
import java.math.BigDecimal;

public interface CurrencyExchangeService {
    BigDecimal getCurrencyExchangeResult(BigDecimal amount, String fromCurrencyCode, String toCurrencyCode) throws IOException;
}
