package br.com.alura.conversordemoedas.principal;

import br.com.alura.conversordemoedas.calculo.ConverterMoeda;
import br.com.alura.conversordemoedas.modelos.CambioMoeda;
import br.com.alura.conversordemoedas.modelos.ConsultaTaxaMoedas;
import br.com.alura.conversordemoedas.modelos.InicializadorDeTaxas;
import br.com.alura.conversordemoedas.modelos.TipoConversor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var consultaTaxaMoedas = new ConsultaTaxaMoedas();

        var inicializadorDeTaxas = new InicializadorDeTaxas();
        List<CambioMoeda> moedas = inicializadorDeTaxas.inicializar(consultaTaxaMoedas);

        int opcao = 0;
        String[] nomeMoedas = {"Dólar", "Peso Argentino", "Real Brasileiro", "Peso Colombiano"};
        List<TipoConversor> conversores = new ArrayList<>();

        String decoracao = "*****************************************************************";

        var converterMoeda = new ConverterMoeda();

        do{
            System.out.println(decoracao);
            System.out.println("Seja bem-vindo/a ao Conversor de Moeda :]");

            int indiceOpcao = 0;
            for (int i = 1; i < nomeMoedas.length; i++) {
                indiceOpcao += i;
                System.out.println(indiceOpcao + ") " + nomeMoedas[0] + " =>> " + nomeMoedas[i]);
                conversores.add(new TipoConversor(moedas.getFirst().baseCode(), moedas.get(i).baseCode()));
                System.out.println((indiceOpcao + 1) + ") " + nomeMoedas[i] + " =>> " + nomeMoedas[0]);
                conversores.add(new TipoConversor(moedas.get(i).baseCode(), moedas.getFirst().baseCode()));
            }

            System.out.println("0) Sair");
            System.out.println(decoracao);
            opcao = scanner.nextInt();

            if(opcao == 0) break;

            TipoConversor tipoConversor = conversores.get(opcao - 1);
            for(CambioMoeda moeda : moedas){
                if(moeda.baseCode().equals(tipoConversor.moedaEscolhida())){
                    converterMoeda.configurar(tipoConversor, moeda);
                    break;
                }
            }

            System.out.println("\nDigite o valor que deseja converter:");
            double valor = scanner.nextDouble();

            converterMoeda.converter(valor);

        } while (opcao != 0);

        scanner.close();
    }
}
