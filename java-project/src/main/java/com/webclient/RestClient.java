package main.java.com.webclient;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;


public class RestClient {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://jsonplaceholder.typicode.com/posts/1");


        try (CloseableHttpResponse response = httpClient.execute(request)) {
            System.out.println("Response status: " + response.getStatusLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
