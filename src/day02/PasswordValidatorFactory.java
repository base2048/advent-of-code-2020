package day02;

import java.util.regex.*;

public class PasswordValidatorFactory {

    public static PasswordValidator create(int solvingPart) {
        if (solvingPart == 1) return new ValidatorPart1();
        if (solvingPart == 2) return new ValidatorPart2();
        throw new IllegalArgumentException();
    }

    abstract static class Validator implements PasswordValidator {
        protected int number1;
        protected int number2;
        protected char letter;
        protected String password;

        private final Pattern ruleSetPAT = Pattern.compile("^(\\d+)-(\\d+) (.): (\\w+)$");

        private void parseRuleSet(String ruleSet) {
            Matcher matcher = ruleSetPAT.matcher(ruleSet);
            matcher.find();
            number1 = Integer.parseInt(matcher.group(1));
            number2 = Integer.parseInt(matcher.group(2));
            letter = matcher.group(3).charAt(0);
            password = matcher.group(4);
        }
    }

    public interface PasswordValidator {
        boolean validate(String ruleSet);
    }

    private static class ValidatorPart1 extends Validator {
        @Override
        public boolean validate(String ruleSet) {
            super.parseRuleSet(ruleSet);
            int ctr = (int) password.chars().filter(chr -> chr == letter).count();
            return ctr >= number1 && ctr <= number2;
        }
    }

    private static class ValidatorPart2 extends Validator {
        @Override
        public boolean validate(String ruleSet) {
            super.parseRuleSet(ruleSet);
            return password.charAt(number1 - 1) == letter ^ password.charAt(number2 - 1) == letter;
        }
    }
}
