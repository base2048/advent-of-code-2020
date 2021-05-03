package day18;

import java.util.*;
import java.util.regex.*;

public class Challenge {

    private final List<String> expressions;
    private boolean SUM_OVER_MULTIPLY = false;

    private final Pattern numbersOnlyPAT = Pattern.compile("^\\d*$");
    private final Pattern innermostParentheticalPAT = Pattern.compile("\\([\\d*+ ]*\\)");
    private final Pattern operationsTermPAT = Pattern.compile("\\d+ [+*] \\d+");
    private final Pattern sumTermPAT = Pattern.compile("\\d+ [+] \\d+");
    private final Pattern multiplyTermPAT = Pattern.compile("\\d+ [*] \\d+");

    private final Operation sum = (a, b) -> Long.toString(Long.parseLong(a) + Long.parseLong(b));
    private final Operation multiply = (a, b) -> Long.toString(Long.parseLong(a) * Long.parseLong(b));

    public Challenge(List<String> expressions) {
        this.expressions = expressions;
    }

    public long solvePart1() {
        SUM_OVER_MULTIPLY = false;
        return expressions.stream().mapToLong(this::calculateExpression).sum();
    }

    public long solvePart2() {
        SUM_OVER_MULTIPLY = true;
        return expressions.stream().mapToLong(this::calculateExpression).sum();
    }

    private Long calculateExpression(String expression) {
        if (numbersOnlyPAT.matcher(expression).matches()) return Long.parseLong(expression);
        if (!expression.contains("(")) return Long.parseLong(calculateInnermost(expression));

        Matcher matcher = innermostParentheticalPAT.matcher(expression);
        matcher.find();
        return calculateExpression(matcher.replaceFirst(calculateInnermost(trimBrackets(matcher.group()))));
    }

    private String calculateInnermost(String expression) {
        if (numbersOnlyPAT.matcher(expression).matches()) return expression;

        Matcher matcher = null;
        Operation operation = sum;

        if (SUM_OVER_MULTIPLY) {
            matcher = sumTermPAT.matcher(expression);
            if (!matcher.find()) {
                (matcher = multiplyTermPAT.matcher(expression)).find();
                operation = multiply;
            }
        }

        if (!SUM_OVER_MULTIPLY) {
            (matcher = operationsTermPAT.matcher(expression)).find();
            operation = matcher.group().contains("+") ? sum : multiply;
        }

        String result = calculateTerm(matcher.group(), operation);
        return calculateInnermost(matcher.replaceFirst(result));
    }

    private String calculateTerm(String term, Operation operation) {
        String[] operands = term.split(" [+*] ");
        return operation.execute(operands[0], operands[1]);
    }

    private static String trimBrackets(String expression) {
        return expression.substring(1, expression.length() - 1);
    }

    @FunctionalInterface
    public interface Operation {
        String execute(String a, String b);
    }
}
