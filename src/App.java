import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // fazer uma conexão HTTP e buscar os filmes
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        // extrair somente os dados que interessam (titulo, poster, classificação)
        var parser= new JsonParser();
        List <Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("\u001b[1mTítulo: \u001b[m" + "\u001b[36m"+ filme.get("fullTitle") + "\u001b[m");
            System.out.println("\u001b[1mPoster: \u001b[m" + "\u001b[34m" + filme.get("image") + "\u001b[m");
            float estrelas = Float.parseFloat(filme.get("imDbRating"));
            float estrelasArredondado = Math.round(estrelas);
            System.out.print("\u001b[1mNota: \u001b[m" + "\u001b[33m"+ filme.get("imDbRating"));
            for (int i = 0; i < estrelasArredondado; i++){
                System.out.print(" \u2605");
            }
            System.out.print(" \u001b[m");
            System.out.println("\n");
        }
    }
}
