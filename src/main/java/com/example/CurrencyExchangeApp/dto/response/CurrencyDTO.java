package com.example.CurrencyExchangeApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDTO {
    private String currencyCode;
    private String nameUz;
    private String nameEn;
    private Integer nominal;
    private Double rate;
    private Double diff;
    private String updatedAt;
}
