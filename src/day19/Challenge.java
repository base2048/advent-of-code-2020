package day19;

import java.util.*;
import java.util.regex.Pattern;

public class Challenge {

    private final Map<Integer, String> ruleByIndex;
    private final List<String> messages;

    public Challenge(Parser.Dataset data) {
        this.ruleByIndex = data.ruleByIndex;
        this.messages = data.messages;
    }

    public int solvePart1() {
        String rule0RGX = buildRegex(0);
        return (int) messages.parallelStream()
                .filter(message -> message.matches(rule0RGX))
                .count();
    }

    public int solvePart2() {
        /*
         * Replacing rules "8: 42" and "11: 42 31" with the following:
         * "8: 42 | 42 8"
         * "11: 42 31 | 42 11 31"
         * will end up in infinite loops.
         *
         * Rethink rule "8: 42 | 42 8" as: "8: 42+"
         * and rule "11: 42 31 | 42 11 31" as "11: 42{x} 31{x}
         * to build a regex with n-many loops needed to cover all messages:
         * => (42+ ((42{1} 31{1}) | (42{2} 31{2}) ... (42{n} 31{n})))
         */

        String rule31RGXEmbraced = "(" + buildRegex(31) + ")";
        String rule42RGXEmbraced = "(" + buildRegex(42) + ")";

        int loops = 0;
        int cache = -1;
        int matchCount = 0;

        while (matchCount > cache) {
            cache = matchCount;
            loops++;

            Formatter rule0RGXF = new Formatter();
            rule0RGXF.format("(%s+(", rule42RGXEmbraced);

            for (int i = 1; i <= loops; i++)
                rule0RGXF.format("(%s{%d}%s{%2$d})%s", rule42RGXEmbraced, i, rule31RGXEmbraced, i == loops ? "" : "|");

            rule0RGXF.format("))");
            String rule0RGX = rule0RGXF.toString();

            matchCount = (int) messages.parallelStream()
                    .filter(message -> message.matches(rule0RGX))
                    .count();
        }
        return matchCount;
    }

    private String buildRegex(int ruleNumber) {
        String regex = ruleByIndex.get(ruleNumber);
        Pattern numbersPAT = Pattern.compile("\\d+");

        while (numbersPAT.matcher(regex).find()) {
            StringBuilder sb = new StringBuilder();

            for (String part : regex.split(" "))
                if (numbersPAT.matcher(part).find())
                    sb.append("( ").append(ruleByIndex.get(Integer.parseInt(part))).append(" )");
                else sb.append(part);

            regex = sb.toString();
        }
        return regex.replaceAll(" ", "");
    }
}
