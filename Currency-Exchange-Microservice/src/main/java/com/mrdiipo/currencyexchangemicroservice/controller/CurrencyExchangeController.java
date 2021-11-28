package com.mrdiipo.currencyexchangemicroservice.controller;

import com.mrdiipo.currencyexchangemicroservice.controller.request.CurrencyRequestModel;
import com.mrdiipo.currencyexchangemicroservice.controller.response.CurrencyResponseModel;
import com.mrdiipo.currencyexchangemicroservice.service.CurrencyExchangeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;

@RibbonClient("accounts-query-service")
@RestController
public class CurrencyExchangeController {

    @Autowired CurrencyExchangeServiceImp currencyExchangeServiceImp;

    @PostMapping("/api/v1/getConvertedValue")
    public CurrencyResponseModel getExchangeValue(@RequestBody CurrencyRequestModel currencyRequestModel) throws IOException {

        CurrencyRequestModel requestModel = CurrencyRequestModel.builder().amount(currencyRequestModel.getAmount())
                .from(currencyRequestModel.getFrom())
                .to(currencyRequestModel.getTo())
                .build();

        BigDecimal returnValue = currencyExchangeServiceImp.getCurrencyExchangeResult(requestModel.getAmount(), requestModel.getFrom(), requestModel.getTo());

        return  CurrencyResponseModel.builder().convertedAmount(returnValue).build();
//        MonetaryAmount convertCurrency = Monetary.getDefaultAmountFactory()
//                .setCurrency(requestModel.getFrom())
//                .setNumber(requestModel.getValue())
//                .create();
//
//        CurrencyConversion toCurrency = MonetaryConversions.getConversion(requestModel.getTo());
//
//        MonetaryAmount  convertedValue = convertCurrency.with(toCurrency);
    }
}
