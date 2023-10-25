package nl.alimjan.countriessorter.country;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Slf4j
public class CountryController {

    private final CountryService countryService;

    @RequestMapping("/countries-by-population-density-in-desc")
    public List<Country> getAllCountriesByPopulationDensityInDescOrder(){
        return countryService.getAllCountriesByPopulationDensityInDescOrder();
    }

    @RequestMapping("/asia-most-different-region-bordering-country")
    public Country getAsiaMostDifferentRegionBorderingCountries(){
        return countryService.getAsiaMostDifferentRegionBorderingCountries();
    }
}
