# Countries sorter

### Fetch data from [restcountries](https://restcountries.com/v3.1/all) and sorting countries

#### Usage

Compile, test and generate Jar file
```text
./mvnw clean install
```
run application
```text
./mvnw spring-boot:run
```

#### Current available endpoint:
Sorted list of countries by population density in descending order.
```text
/api/v1/countries-by-population-density-in-desc
```
Country in Asia containing the most bordering countries of a different region.
```text
/api/v1/asia-most-different-region-bordering-country
```
