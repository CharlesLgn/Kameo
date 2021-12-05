package fr.metz.iut.kameo.web.rest.resource.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

public class HelloResource {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  public Hello greeting(String name) {
    return new Hello(counter.incrementAndGet(), String.format(template, name));
  }

  private record Hello(long id, String content){}
}
