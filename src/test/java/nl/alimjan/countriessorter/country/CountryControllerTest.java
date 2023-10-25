package nl.alimjan.countriessorter.country;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@WebMvcTest(CountryController.class)
class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService countryService;

    @Test
    void getAllCountriesByPopulationDensityInDescOrder() throws Exception {

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
        when(countryService.getAllCountriesByPopulationDensityInDescOrder()).thenReturn(testCountries);

        // then
        this.mockMvc.perform(get("/api/v1/countries-by-population-density-in-desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    void getAsiaMostDifferentRegionBorderingCountries() throws Exception {
        // given
        Country country = new Country();
        country.setRegion("Asia");
        country.setSubregion("Subregion2");
        country.setBorders(List.of("Bordering3", "Bordering4"));

        // when
        when(countryService.getAsiaMostDifferentRegionBorderingCountries()).thenReturn(country);

        // then
        this.mockMvc.perform(get("/api/v1/asia-most-different-region-bordering-country"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.region", is("Asia")))
                .andExpect(jsonPath("$.subregion", is("Subregion2")))
                .andExpect(jsonPath("$.borders", hasSize(2)))
                .andExpect(jsonPath("$.borders[0]", is("Bordering3")))
                .andExpect(jsonPath("$.borders[1]", is("Bordering4")));
    }
}