package com.mrdiipo.currencyexchangemicroservice.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class CurrencyExchangeServiceImp implements CurrencyExchangeService{

    @Value("${API_KEY}")
    String API_KEY;

    @Override
    public BigDecimal getCurrencyExchangeResult(BigDecimal convertAmount, String fromCurrencyCode, String toCurrencyCode) throws IOException {

        String fromCurrency = fromCurrencyCode;
        String toCurrency = toCurrencyCode;
        BigDecimal amount = convertAmount;

        String requestString = API_KEY + fromCurrency + "/" + toCurrency + "/" + amount.toString();

        URL url = new URL(requestString);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonElement root =  JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        String result = jsonobj.get("conversion_result").getAsString();

        return BigDecimal.valueOf(Double.parseDouble(result));
    }
}
