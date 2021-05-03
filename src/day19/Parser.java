package day19;

import java.io.*;
import java.util.*;

public class Parser {

    public static Dataset parse(String text) {
        return parseData(new StringReader(text));
    }

    public static Dataset parse(File file) throws FileNotFoundException {
        return parseData(new FileReader(file));
    }

    public static Dataset parseData(Reader source) {
        Map<Integer, String> rules = new HashMap<>();
        List<String> messages = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(source)) {
            String[] tokens;
            while ((tokens = reader.readLine().split(": ")).length > 1)
                rules.put(Integer.parseInt(tokens[0]), tokens[1].replaceAll("\"", ""));

            String message;
            while ((message = reader.readLine()) != null)
                messages.add(message);

        } catch (IOException ignored) {
        }
        return new Dataset(rules, messages);
    }

    protected static class Dataset {
        protected final Map<Integer, String> ruleByIndex;
        protected final List<String> messages;

        private Dataset(Map<Integer, String> ruleByIndex, List<String> messages) {
            this.ruleByIndex = ruleByIndex;
            this.messages = messages;
        }
    }
}
