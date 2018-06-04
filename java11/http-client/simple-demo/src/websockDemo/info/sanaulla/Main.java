package info.sanaulla;

import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.*;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        HttpClient client = HttpClient.newHttpClient();

        WebSocket.Listener listener = new WebSocket.Listener() { 
            List<String> parts = new ArrayList<>();
            CompletableFuture<?> accumulatedMessage = new CompletableFuture<>();    

            public void onOpen(WebSocket ws){
                System.out.println("Websocket connection open");
            }

            public CompletionStage<?> onText(WebSocket webSocket,
                CharSequence message, boolean last) {
                    System.out.println("received " + message);
                parts.add(message.toString());
                webSocket.request(1);
                if (last) {
                    //processWholeText(parts);
                    System.out.println(parts.stream().collect(Collectors.joining("\n")));

                    parts = new ArrayList<>();
                    accumulatedMessage.complete(null);
                    CompletionStage<?> cf = accumulatedMessage;
                    accumulatedMessage = new CompletableFuture<>();
                    return cf;
                }
                return accumulatedMessage;
            }

            public void onError(WebSocket ws, Throwable error){
                System.out.println("Error occurred");
            }
        };

        CompletableFuture<WebSocket> webSocket = client.newWebSocketBuilder()
            .buildAsync(new URI("ws://echo.websocket.org"), listener);
        webSocket.thenCompose(ws -> ws.sendText("Some message", false))
            .thenCompose(ws -> ws.sendText("completed", true))
            .join();
        
    }
}