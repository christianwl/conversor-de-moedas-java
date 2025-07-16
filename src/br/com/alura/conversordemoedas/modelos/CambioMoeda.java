package br.com.alura.conversordemoedas.modelos;

import java.util.Map;

public record CambioMoeda(String baseCode, Map<String, Double> conversionRates) {
}
