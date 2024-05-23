import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {


    public Moeda buscarRequisicao(String base_code, String target_code, double valorTotal) {

        String chave = "88cd5c5ba71e8d3819eaed02";
        URI url = URI.create("https://v6.exchangerate-api.com/v6/" + chave + "/pair/" + base_code + "/" + target_code + "/" + valorTotal);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        HttpResponse<String> response;
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possível realizar a conversão devido a um erro.");
        }
        return new Gson().fromJson(response.body(), Moeda.class);
    }

}
