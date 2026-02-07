package br.com.alura.conversordemoedas.calculo;

import br.com.alura.conversordemoedas.modelos.ExchangeRateDTO;
import br.com.alura.conversordemoedas.modelos.TipoConversor;

public class ConverterMoeda {
    private String moeda;
    private String conversor;
    private ExchangeRateDTO taxa;

    public void configurar(TipoConversor tipoConversor, ExchangeRateDTO taxa){
        this.moeda = tipoConversor.moedaEscolhida();
        this.conversor = tipoConversor.conversor();
        this.taxa = taxa;
    }

    public void converter(double valor){
        double taxaDesejada = taxa.conversionRates().get(this.conversor);
        double resultado = valor * taxaDesejada;

        exibirResultado(valor,resultado);
    }

    public void exibirResultado(double valor, double resultado){
        System.out.printf("\nValor %.2f [%s] corresponde ao valor final de =>> %.2f [%s]\n",
                valor, this.moeda, resultado, this.conversor);
    }

}
