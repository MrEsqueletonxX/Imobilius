package br.com.imobilius;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ImobiliusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImobiliusApplication.class, args);
	}
	
	@GetMapping("/")
    public String home() {
        return "Home Page";
    }

}
