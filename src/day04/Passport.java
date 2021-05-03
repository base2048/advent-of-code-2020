package day04;

import java.util.*;

public class Passport {

    private final Map<String, String> valueByField;

    public Passport(Map<String, String> valueByField) {
        this.valueByField = valueByField;
    }

    public Map<String, String> getValueByField() {
        return valueByField;
    }
}
