package com.example.CurrencyExchangeApp.controller;

import com.example.CurrencyExchangeApp.dto.response.CurrencyDTO;
import com.example.CurrencyExchangeApp.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
@CrossOrigin
public class Controller {
    @Autowired
    private Service service;

    @GetMapping("/updaterates")
    public List<CurrencyDTO> update(){
        return service.getCurrencyRates();
    }
}
