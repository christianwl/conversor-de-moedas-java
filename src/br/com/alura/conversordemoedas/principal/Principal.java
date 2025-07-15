package br.com.alura.conversordemoedas.principal;

import br.com.alura.conversordemoedas.modelos.CambioMoeda;
import br.com.alura.conversordemoedas.modelos.ConsultaTaxaMoedas;
import br.com.alura.conversordemoedas.modelos.InicializadorDeTaxas;

import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var consultaTaxaMoedas = new ConsultaTaxaMoedas();

        var inicializadorDeTaxas = new InicializadorDeTaxas();
        List<CambioMoeda> moedas = inicializadorDeTaxas.inicializar(consultaTaxaMoedas);

        scanner.close();
    }
}
