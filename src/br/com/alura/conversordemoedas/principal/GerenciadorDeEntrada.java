package br.com.alura.conversordemoedas.principal;

import br.com.alura.conversordemoedas.calculo.ConverterMoeda;
import br.com.alura.conversordemoedas.modelos.ExchangeRateDTO;
import br.com.alura.conversordemoedas.modelos.TipoConversor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class GerenciadorDeEntrada {
    private final Scanner scanner;
    private final ConverterMoeda converterMoeda;

    public void iniciar(List<ExchangeRateDTO> moedas, List<TipoConversor> conversores) {
        int opcao = 0;

        do {
            try {
                if (moedas == null) {
                    throw new NullPointerException("Não foram encontrados valores de taxas devido a um erro");
                }

                conversores = exibirEAtribuirOpcoes(moedas);

                opcao = scanner.nextInt();

                if (opcao < 0 || opcao > conversores.size()) {
                    System.out.println("Opção inválida! Tente novamente");
                } else {
                    if (opcao == 0) break;

                    TipoConversor tipoConversor = conversores.get(opcao - 1);

                    for (ExchangeRateDTO moeda : moedas) {
                        if (moeda.baseCode().equals(tipoConversor.moedaEscolhida())) {
                            converterMoeda.configurar(tipoConversor, moeda);
                            break;
                        }
                    }

                    System.out.println("\nDigite o valor que deseja converter:");
                    double valor = 0;

                    while (valor <= 0) {
                        valor = scanner.nextDouble();
                        if (valor <= 0) System.out.println("Valor inválido, tente novamente");
                    }

                    converterMoeda.converter(valor);
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido foi inserido");
                scanner.nextLine();
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                break;
            }
        } while (true);

        System.out.println("Programa Encerrado com sucesso!");
    }

    public List<TipoConversor> exibirEAtribuirOpcoes(List<ExchangeRateDTO> moedas){
        String[] nomeMoedas = {"Dólar", "Peso Argentino", "Real Brasileiro", "Peso Colombiano"};
        String decoracao = "*****************************************************************";
        List<TipoConversor> conversores = new ArrayList<>();

        System.out.println(decoracao);
        System.out.println("Seja bem-vindo/a ao Conversor de Moeda :]");

        int indiceOpcao = 0;
        for (int i = 1; i < nomeMoedas.length; i++) {
            indiceOpcao += i;
            System.out.println(indiceOpcao + ") " + nomeMoedas[0] + " =>> " + nomeMoedas[i]);
            conversores.add(new TipoConversor(moedas.get(0).baseCode(), moedas.get(i).baseCode()));
            System.out.println((indiceOpcao + 1) + ") " + nomeMoedas[i] + " =>> " + nomeMoedas[0]);
            conversores.add(new TipoConversor(moedas.get(i).baseCode(), moedas.get(0).baseCode()));
        }

        System.out.println("0) Sair");
        System.out.println(decoracao);

        return conversores;
    }
}