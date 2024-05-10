import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner busca = new Scanner(System.in);
        System.out.println("Digite o nome do livro que deseja buscar: ");
        var livro = busca.nextLine();

        String chave = "AAIzaSyBCpFtz79BXozNFsvWvLmqrhRGqM8bbG3A";
        String endereco = "https://www.googleapis.com/books/v1/volumes?q=" + livro + "&key=" + chave;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}