import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class call {
    public static void main(String[] args) throws Exception{
        // Definindo os dados da url em string
        String url = "https://gist.githubusercontent.com/lucasfugisawa/cbb0d10ee3901bd0541468e431c629b3/raw/1fe1f3340dfe5b5876a209c0e8226d090f6aef10/Top250Movies.json";
        //Comunicação com banco de dados da API
        HttpClient cliente = HttpClient.newHttpClient();
        //Requisição, passando a URL usando URI e GET para pegar os dados
        HttpRequest requisicao = HttpRequest.newBuilder(URI.create(url)).GET().build();
        //BodyHandlers para pegar os dados e trata-lo como string
        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
        //Armazena a resposta em uma string json
        String json = resposta.body();
        // Imprimindo o valor da json
        System.out.println(json);
    }
}