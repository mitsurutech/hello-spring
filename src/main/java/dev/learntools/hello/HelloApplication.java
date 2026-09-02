package dev.learntools.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A hello-world Spring Boot app for learntools.dev.
 *
 * <p>The one rule this platform asks: listen on the port it gives you. Spring Boot reads
 * {@code SERVER_PORT} from the environment on its own, so nothing in this class does it —
 * see application.properties for the local default.
 */
@SpringBootApplication
@RestController
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

    @GetMapping("/")
    public String hello() {
        String port = System.getenv().getOrDefault("SERVER_PORT", "8080");
        return "<h1>Hello from Spring Boot</h1><p>Serving on port " + port + ".</p>"
                + "<p>Written by a student, hosted for an hour.</p>";
    }

    @GetMapping("/healthz")
    public String healthz() {
        return "{\"ok\":true}";
    }
}
