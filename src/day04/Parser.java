package day04;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Parser {

    public static List<Passport> parse(String text) {
        return parsePassports(new StringReader(text));
    }

    public static List<Passport> parse(File file) throws FileNotFoundException {
        return parsePassports(new FileReader(file));
    }

    private static List<Passport> parsePassports(Reader source) {
        List<Passport> passports = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(source)) {
            String input;
            while ((input = reader.readLine()) != null) {

                StringBuilder passport = new StringBuilder(input.trim());
                while ((input = reader.readLine()) != null && !input.isEmpty())
                    passport.append(" ").append(input.trim());

                passports.add(new Passport(parseFields(passport.toString())));
            }
        } catch (IOException ignored) {
        }
        return passports;
    }

    private static Map<String, String> parseFields(String passport) {
        return Arrays.stream(passport.split(" "))
                .map(tokens -> tokens.split(":"))
                .collect(Collectors.toMap(t -> t[0], t -> t[1]));
    }
}
