package net.lr.spring.boot.tracing;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(App.class, args);
    }
    
    /**
     * Create RestTemplate as bean to allow sleuth to intercept calls
     * 
     * @return
     */
    @Bean
    public static RestTemplate template() {
        return new RestTemplate();
    }
    
}
