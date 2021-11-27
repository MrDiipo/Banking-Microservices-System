package com.mrdiipo.currencyexchangemicroservice.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mrdiipo.currencyexchangemicroservice.controller.request.CurrencyRequestModel;
import com.mrdiipo.currencyexchangemicroservice.controller.response.CurrencyResponseModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class CurrencyExchangeController {

    String API_KEY = "https://v6.exchangerate-api.com/v6/a0400acdd22ea970ab5a5a9c/pair/";


    @PostMapping("/api/v1/getExchangeValue")
    public CurrencyResponseModel getExchangeValue(@RequestBody CurrencyRequestModel currencyRequestModel) throws IOException {

        String fromCurrency = currencyRequestModel.getFrom();
        String toCurrency = currencyRequestModel.getTo();
        BigDecimal amount =  currencyRequestModel.getValue();

        String requestString = API_KEY + fromCurrency + "/" + toCurrency + "/" + amount.toString();

        URL url = new URL(requestString);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        String result = jsonobj.get("conversion_result").getAsString();
        return CurrencyResponseModel.builder()
                .value(
                        BigDecimal.valueOf(Double.parseDouble(result)))
                .build();



//        CurrencyRequestModel requestModel = CurrencyRequestModel.builder().value(currencyRequestModel.getValue())
//                .from(currencyRequestModel.getFrom())
//                .to(currencyRequestModel.getTo())
//                .build();
//
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
