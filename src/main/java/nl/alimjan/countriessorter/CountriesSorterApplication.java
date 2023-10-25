package nl.alimjan.countriessorter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CountriesSorterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountriesSorterApplication.class, args);
    }

}
