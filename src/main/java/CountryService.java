import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service

public class CountryService {

    private static List<Country> countries;

    static {
        try {
            countries = FirstSpringApplication.countryReader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CountryService() throws IOException {
        this.countries = CountryReader.readCountriesFromFile();
    }

    public static List<Country> listAllCountries() {
        return countries.stream()
                .toList();
    }

    public static List<String> listAllCountryNames() {
        return countries.stream()
                .map(Country::getName)
                .toList();
    }

    private static List<Country> getCountry(String country) {
        List<Country> result = countries.stream()
                .filter(country1 -> country.equals(country1.getName()))
                .toList();
        return result;
    }

    public static String getCapitalOfACountry(String country) {
        return getCountry(country).get(0).getCapital();
    }

    public static long getPopulationOfACountry(String country) {
        return getCountry(country).get(0).getPopulation();
    }

    public static List<Country> getCountriesInContinent(String continent) {
        return countries.stream()
                .filter(country -> continent.equals(country.getContinent()))
                .toList();
    }

    public static List<String> getCountryNeighbours(String country) {
        return getCountry(country).get(0).getNeighbours();
    }

    public static List<Country> getCountriesInContinentPopulationLargerThen(String continent, long population) {
        return countries.stream()
                .filter(country -> country.getContinent().equals(continent) && country.getPopulation() > population)
                .toList();
    }

    public static List<Country> getCountriesWithXButNoY(String x, String y) {
        return countries.stream()
                .filter(country -> (country.getNeighbours() != null) && country.getNeighbours().contains(x)
                        && !country.getNeighbours().contains(y))
                .toList();
    }

}
