package day04;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Challenge {

    private final List<Passport> passports;
    private final List<String> requiredFields;
    private final Map<String, Predicate<String>> validatorByField;

    public Challenge(List<Passport> passports) {
        this.passports = passports;
        this.requiredFields = List.of("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");
        this.validatorByField = buildValidators();
    }

    public int solvePart1() {
        return (int) passports.stream().filter(this::validatePassportOnKeys).count();
    }

    public int solvePart2() {
        return (int) passports.stream()
                .filter(this::validatePassportOnKeys)
                .filter(this::validatePassportOnValues)
                .count();
    }

    private boolean validatePassportOnKeys(Passport passport) {
        return requiredFields.stream().allMatch(field -> passport.getValueByField().containsKey(field));
    }

    private boolean validatePassportOnValues(Passport passport) {
        return requiredFields.stream().allMatch(field -> validatorByField.get(field).test(passport.getValueByField().get(field)));
    }

    private Map<String, Predicate<String>> buildValidators() {
        Map<String, Predicate<String>> validators = new HashMap<>();

        validators.put("byr", val -> validateFieldByMinMax(val, 1920, 2002));
        validators.put("iyr", val -> validateFieldByMinMax(val, 2010, 2020));
        validators.put("eyr", val -> validateFieldByMinMax(val, 2020, 2030));
        validators.put("hgt", val -> val.endsWith("cm")
                ? validateFieldByMinMax(val.replace("cm", ""), 150, 193)
                : validateFieldByMinMax(val.replace("in", ""), 59, 76));
        validators.put("hcl", val -> validateFieldByRegex(val, Pattern.compile("#[\\da-f]{6}")));
        validators.put("ecl", val -> validateFieldByRegex(val, Pattern.compile("(amb|blu|brn|gry|grn|hzl|oth)")));
        validators.put("pid", val -> validateFieldByRegex(val, Pattern.compile("[\\d]{9}")));

        return validators;
    }

    private boolean validateFieldByMinMax(String field, int min, int max) {
        int fieldValue = Integer.parseInt(field);
        return fieldValue >= min && fieldValue <= max;
    }

    private boolean validateFieldByRegex(String field, Pattern pattern) {
        return pattern.matcher(field).matches();
    }
}
