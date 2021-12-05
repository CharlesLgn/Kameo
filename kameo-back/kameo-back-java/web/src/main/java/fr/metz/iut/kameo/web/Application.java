package fr.metz.iut.kameo.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;
import fr.metz.iut.kameo.web.rest.resource.hello.HelloResource;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Application {

  public static void main(String[] args) throws IOException {
    int serverPort = 8000;
    HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);
    var helloResource = new HelloResource();
    server.createContext("/hello", (exchange -> {
      if ("GET".equals(exchange.getRequestMethod())) {
        var req = exchange.getRequestURI().toString().split("\\?");
        Object response = helloResource.greeting((req.length > 1) ? req[1].substring(5) : "world");
        ObjectMapper objectMapper = new ObjectMapper();
        String respText = objectMapper.writer().writeValueAsString(response);
        exchange.sendResponseHeaders(200, respText.getBytes().length);
        OutputStream output = exchange.getResponseBody();
        output.write(respText.getBytes());
        output.flush();
      } else {
        exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed
      }
      exchange.close();
    }));
    server.setExecutor(null);
    server.start();
  }
}
