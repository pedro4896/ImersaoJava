import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
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

        // extrair somente os dados que interessam (titulo, poster, classificação)
        var parser= new JsonParser();
        List <Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados
        var geradora = new GeradoraDeFigurinhas();
        var diretorio = new File("figurinhas/");
        diretorio.mkdir();

        for (Map<String,String> filme : listaDeFilmes) {
            //Cria as figurinhas
            String urlImagem = filme.get("image");
            String title = filme.get("title");
            double classificação = Double.parseDouble(filme.get("imDbRating"));

            String textoFigurinha;
            InputStream imagemStatus;
            if(classificação >= 9.2){
                textoFigurinha = "APROVADO";
                imagemStatus = new FileInputStream(new File("sobreposicao/aprovado.jpg"));
            }
            else{
                textoFigurinha = "REPROVADO";
                imagemStatus = new FileInputStream(new File("sobreposicao/reprovado.jpg"));
            }

            String titulo = title.trim(); //tira os espacos em branco nas extremidades do titulo
            InputStream inputStream = new URL(urlImagem).openStream();

            String nomeArquivo = "figurinhas/" + titulo + ".png";
            geradora.cria(inputStream, nomeArquivo , textoFigurinha, imagemStatus);

            //Exibe as informações no terminal
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
