package com.example.CurrencyExchangeApp.service;

import com.example.CurrencyExchangeApp.dto.response.CurrencyDTO;
import com.example.CurrencyExchangeApp.model.Currency;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@org.springframework.stereotype.Service
public class Service {

    public List<CurrencyDTO> getCurrencyRates() {
        List<CurrencyDTO> currencies = new ArrayList<>();
        CurrencyDTO dto;
        String API_URL = "https://cbu.uz/oz/arkhiv-kursov-valyut/json/";
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            Gson gson = new Gson();
            Currency[] currencyObjs = gson.fromJson(reader, Currency[].class);
            System.out.println(currencyObjs[0]);
            for (Currency currencyObj : currencyObjs) {
                dto = new CurrencyDTO();
                dto.setCurrencyCode(currencyObj.getCcy());
                dto.setNominal(Integer.parseInt(currencyObj.getNominal()));
                dto.setNameEn(currencyObj.getCcyNm_EN());
                dto.setNameUz(currencyObj.getCcyNm_UZ());
                dto.setRate(Double.parseDouble(currencyObj.getRate()));
                dto.setDiff(Double.parseDouble(currencyObj.getDiff()));
                dto.setUpdatedAt(currencyObj.getDate());

                currencies.add(dto);
            }
            System.out.println("Currency rates were fetched successfully at " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currencies;
    }
}
