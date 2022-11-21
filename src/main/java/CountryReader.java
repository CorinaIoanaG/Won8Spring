import org.springframework.stereotype.Repository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository

public class CountryReader {
    private List<Country> countries;

    static List<Country> readCountriesFromFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/file/countries2.txt"));
        String line;
        int id = 0;
        List<Country> countries = new ArrayList<>();
        String[] country;
        while ((line = bufferedReader.readLine()) != null) {
            country = splitLine(line);
            countries.add(new Country(++id, country[0], country[1], Integer.parseInt(country[2]), Integer.parseInt(country[3]),
                    country[4], country.length < 6 ? null : List.of(country[5].split("~"))));

        }
        return countries;
    }

    private static String[] splitLine(String line) {
        String[] result = line.split("\\|");
        return result;
    }
}
