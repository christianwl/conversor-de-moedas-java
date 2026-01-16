package br.com.alura.conversordemoedas.modelos;

import br.com.alura.conversordemoedas.excecoes.InvalidKeyException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConsultaTaxaMoedas extends ConexaoHttp {
    private String apiKey = System.getenv("EXCHANGE_API_KEY");

    public CambioMoeda buscarMoeda(String moeda){
        if (apiKey == null){
            throw new InvalidKeyException("A variável de ambiente EXCHANGE_API_KEY não foi configurada!");
        }
        String endereco = "https://v6.exchangerate-api.com/v6/" + this.apiKey +"/latest/" + moeda;
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        String responseMoeda = responseHttp(endereco);
        if(responseMoeda.contains("invalid-key")) {
            throw new InvalidKeyException("Chave de Api inválida ou inexistente");
        }

        return gson.fromJson(responseHttp(endereco), CambioMoeda.class);
    }
}
