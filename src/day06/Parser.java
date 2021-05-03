package day06;

import java.io.*;
import java.util.*;

public class Parser {

    public static List<Group> parse(String text) {
        return parseGroups(new StringReader(text));
    }

    public static List<Group> parse(File file) throws IOException {
        return parseGroups(new FileReader(file));
    }

    public static List<Group> parseGroups(Reader source) {
        List<Group> groups = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(source)) {
            String input;
            while ((input = reader.readLine()) != null) {

                List<String> declarations = new ArrayList<>();
                declarations.add(input);

                while ((input = reader.readLine()) != null && !input.isEmpty())
                    declarations.add(input);

                groups.add(new Group(declarations));
            }
        } catch (IOException ignored) {
        }
        return groups;
    }
}
