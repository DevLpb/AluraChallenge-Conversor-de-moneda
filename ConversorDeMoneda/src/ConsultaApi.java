import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    public Divisas setDivisa(String base, String objetivo, String monto) {

        String apiKey = "f80d773e8a962a7cf6dd5ddf";
        String divisas = base + "/" + objetivo + "/" + monto;
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+divisas))
                .build();

       try {
           HttpResponse<String> response = client
                   .send(request, HttpResponse.BodyHandlers.ofString());
           return new Gson().fromJson(response.body(), Divisas.class);
       } catch (Exception e) {
           throw new RuntimeException("Fallo en ejecución.");
       }

    }

}
