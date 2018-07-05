import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.*;
import java.io.IOException;

public class ExternalModuleDepSample{
    public static void main(String[] args) throws Exception{
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create("https://reqres.in/api/users"))
            .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());     
    }
}