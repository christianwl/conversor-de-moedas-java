package br.com.alura.conversordemoedas;

import br.com.alura.conversordemoedas.calculo.ConverterMoeda;
import br.com.alura.conversordemoedas.modelos.ExchangeRateDTO;
import br.com.alura.conversordemoedas.modelos.ConsultaTaxaMoedas;
import br.com.alura.conversordemoedas.modelos.InicializadorDeTaxas;
import br.com.alura.conversordemoedas.modelos.TipoConversor;
import br.com.alura.conversordemoedas.principal.GerenciadorDeEntrada;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var consultaTaxaMoedas = new ConsultaTaxaMoedas();
        var inicializadorDeTaxas = new InicializadorDeTaxas();
        List<ExchangeRateDTO> moedas = inicializadorDeTaxas.inicializar(consultaTaxaMoedas);

        List<TipoConversor> conversores = new ArrayList<>();

        var converterMoeda = new ConverterMoeda();

        var gerenciadorDeEntrada = new GerenciadorDeEntrada(scanner, converterMoeda);
        gerenciadorDeEntrada.iniciar(moedas, conversores);

        scanner.close();
    }
}
