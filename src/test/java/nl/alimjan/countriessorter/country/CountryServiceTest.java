package nl.alimjan.countriessorter.country;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CountryServiceTest {

    @InjectMocks
    private CountryService countryService;

    @Mock
    private CountryClient countryClient;

    @Test
    void getAllCountriesByPopulationDensityInDescOrder() {

        // given
        List<Country> testCountries = new ArrayList<>();

        Country country1 = new Country();
        country1.setPopulation(1000000);
        country1.setArea(3000);
        testCountries.add(country1);

        Country country2 = new Country();
        country2.setPopulation(1000000);
        country2.setArea(2000);
        testCountries.add(country2);

        Country country3 = new Country();
        country2.setPopulation(1000000);
        country2.setArea(1000);
        testCountries.add(country3);

        // when
        Mockito.when(countryClient.getAllCountries()).thenReturn(testCountries);

        // then
        List<Country> sortedCountries = countryService.getAllCountriesByPopulationDensityInDescOrder();

        // Assert
        assertEquals(3, sortedCountries.size());
        assertEquals(country3, sortedCountries.get(0));
        assertEquals(country2, sortedCountries.get(1));
        assertEquals(country1, sortedCountries.get(2));
    }

    @Test
    void getAsiaMostDifferentRegionBorderingCountries() {

        // given
        List<Country> testCountries = new ArrayList<>();

        Country asianCountry = new Country();
        asianCountry.setRegion("Asia");
        asianCountry.setSubregion("Subregion2");
        asianCountry.setBorders(List.of("Bordering3", "Bordering4"));
        testCountries.add(asianCountry);

        // Add non-Asian countries
        Country nonAsianCountry1 = new Country();
        nonAsianCountry1.setRegion("Europe");
        nonAsianCountry1.setSubregion("Subregion1");
        nonAsianCountry1.setBorders(List.of("Bordering1"));
        testCountries.add(nonAsianCountry1);

        Country nonAsianCountry2 = new Country();
        nonAsianCountry2.setRegion("Africa");
        nonAsianCountry2.setSubregion("Subregion3");
        nonAsianCountry2.setBorders(List.of("Bordering2"));
        testCountries.add(nonAsianCountry2);

        // when
        Mockito.when(countryClient.getAllCountries()).thenReturn(testCountries);

        // then
        Country result = countryService.getAsiaMostDifferentRegionBorderingCountries();

        // Assert
        assertNotNull(result);
        assertEquals("Asia", result.getRegion());
        assertEquals("Subregion2", result.getSubregion());
        List<String> borders = result.getBorders();
        assertNotNull(borders);
        assertEquals(2, borders.size());
        assertTrue(borders.contains("Bordering3"));
        assertTrue(borders.contains("Bordering4"));
    }
}