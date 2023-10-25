package nl.alimjan.countriessorter.country;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CountryService {

    private final CountryClient countryClient;

    public List<Country> getAllCountriesByPopulationDensityInDescOrder() {

        List<Country> sortedCountries = countryClient.getAllCountries();

        // soring by population density in order
        sortedCountries.sort((country1, country2) -> {
            double density1 = (double) country1.getPopulation() / country1.getArea();
            double density2 = (double) country2.getPopulation() / country2.getArea();
            return Double.compare(density2, density1);
        });

        return sortedCountries;
    }

    public Country getAsiaMostDifferentRegionBorderingCountries() {
        List<Country> allCountries = countryClient.getAllCountries();

        List<Country> asianCountries = allCountries.stream()
                .filter(country -> "Asia".equals(country.getRegion()))
                .toList();

        Country mostBorderingAsianCountry = asianCountries.stream()
                .max((country1, country2) -> {
                    long count1 = country1.getBorders() != null ?
                            country1.getBorders().stream()
                                    .filter(border -> {
                                        // Check if the bordering country is in a different region
                                        String region1 = country1.getSubregion();
                                        String region2 = allCountries.stream()
                                                .filter(c -> c != null && c.getCca3() != null && c.getCca3().equals(border))
                                                .findFirst()
                                                .map(Country::getSubregion)
                                                .orElse(null);
                                        return region1 != null && region2 != null && !region1.equals(region2);
                                    })
                                    .count()
                            : 0;

                    long count2 = country2.getBorders() != null ?
                            country2.getBorders().stream()
                                    .filter(border -> {
                                        // Check if the bordering country is in a different region
                                        String region1 = country2.getSubregion();
                                        String region2 = allCountries.stream()
                                                .filter(c -> c != null && c.getCca3() != null && c.getCca3().equals(border))
                                                .findFirst()
                                                .map(Country::getSubregion)
                                                .orElse(null);
                                        return region1 != null && region2 != null && !region1.equals(region2);
                                    })
                                    .count()
                            : 0;

                    return Long.compare(count1, count2);
                })
                .orElse(null);

        return mostBorderingAsianCountry;
    }
}
