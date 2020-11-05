package com.evvil;
import java.lang.module.FindException;
import java.net.*;
import java.net.http.*;

public class YrConnect {

    public static String getBody(String adres) {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse response = client.send(
                    HttpRequest.newBuilder()
                            .uri(URI.create(adres))
                            .GET()
                            .build(),
                    HttpResponse.BodyHandlers.ofString());
            String content = (String) response.body();
            return content;
        } catch (Exception e) {
            return "No connection";}

    }



}









