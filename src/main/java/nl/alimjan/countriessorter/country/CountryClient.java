package nl.alimjan.countriessorter.country;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "restcountries", url = "${restcountries.base.url}")
public interface CountryClient {

    @GetMapping("/all")
    List<Country> getAllCountries();
}
