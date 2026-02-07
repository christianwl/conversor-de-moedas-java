package br.com.alura.conversordemoedas.modelos;

import br.com.alura.conversordemoedas.excecoes.InvalidKeyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InicializadorDeTaxas {
    private String[] moedasPadrao = {"USD", "ARS", "BRL", "COP"};

    public List<ExchangeRateDTO> inicializar(ConsultaTaxaMoedas consultaTaxaMoedas) {
        List<ExchangeRateDTO> cambiosPadrao = new ArrayList<>();
        try {
            for (String moeda : this.moedasPadrao) {

                ExchangeRateDTO exchangeRateDTO = consultaTaxaMoedas.buscarMoeda(moeda);
                Map<String, Double> taxasValidas = obterTaxas(moeda, exchangeRateDTO.conversionRates());
                cambiosPadrao.add(new ExchangeRateDTO(moeda, taxasValidas));

            }
        } catch (InvalidKeyException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return cambiosPadrao;
    }

    public Map<String, Double> obterTaxas(String chaveInvalida, Map<String, Double> taxas) {
        Map<String, Double> novasTaxas = new HashMap<>();
        for (String moeda : this.moedasPadrao) {
            if (!moeda.equals(chaveInvalida) && taxas.containsKey(moeda)) {
                novasTaxas.put(moeda, taxas.get(moeda));
            }
        }
        return novasTaxas;
    }
}

