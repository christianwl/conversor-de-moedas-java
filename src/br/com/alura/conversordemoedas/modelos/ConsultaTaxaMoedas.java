package br.com.alura.conversordemoedas.modelos;

import br.com.alura.conversordemoedas.config.Config;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConsultaTaxaMoedas extends ConexaoHttp {
    private String apiKey = Config.getApiKey();

    public CambioMoeda buscarMoeda(String moeda){
        String endereco = "https://v6.exchangerate-api.com/v6/" + this.apiKey +"/latest/" + moeda;
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        return gson.fromJson(responseHttp(endereco), CambioMoeda.class);
    }
}
