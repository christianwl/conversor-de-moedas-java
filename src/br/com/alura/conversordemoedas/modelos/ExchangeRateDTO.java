package br.com.alura.conversordemoedas.modelos;

import java.util.Map;

public record ExchangeRateDTO(
        String baseCode,
        Map<String, Double> conversionRates) {
}
