package nl.alimjan.countriessorter.country;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Country {
    private Name name;
    private List<String> tld;
    private String cca2;
    private String ccn3;
    private String cca3;
    private String cioc;
    private boolean independent;
    private String status;
    private boolean unMember;
    private Map<String, Currency> currencies;
    private Idd idd;
    private List<String> capital;
    private List<String> altSpellings;
    private String region;
    private String subregion;
    private Map<String, String> languages;
    private Map<String, Translation> translations;
    private List<Double> latlng;
    private boolean landlocked;
    private List<String> borders;
    private double area;
    private Demonyms demonyms;
    private String flag;
    private Maps maps;
    private int population;
    private Gini gini;
    private String fifa;
    private Car car;
    private List<String> timezones;
    private List<String> continents;
    private Flags flags;
    private CoatOfArms coatOfArms;
    private String startOfWeek;
    private CapitalInfo capitalInfo;
    private PostalCode postalCode;
}

@Data
class Name {
    private String common;
    private String official;
    private Map<String, NativeName> nativeName;
}

@Data
class NativeName {
    private String official;
    private String common;
}

@Data
class Currency {
    private String name;
    private String symbol;
}

@Data
class Idd {
    private String root;
    private List<String> suffixes;
}

@Data
class Translation {
    private String official;
    private String common;
}

@Data
class Demonyms {
    private Map<String, String> eng;
    private Map<String, String> fra;
}

@Data
class Maps {
    private String googleMaps;
    private String openStreetMaps;
}

@Data
class Gini {
    private double _2003;
}

@Data
class Car {
    private List<String> signs;
    private String side;
}

@Data
class Flags {
    private String png;
    private String svg;
    private String alt;
}

@Data
class CoatOfArms {
    private String png;
    private String svg;
}

@Data
class CapitalInfo {
    private List<Double> latlng;
}

@Data
class PostalCode {
    private String format;
    private String regex;
}
