package day16;

public class Rule {

    private final String fieldName;
    private final int[] lowerValueRange;
    private final int[] higherValueRange;

    public Rule(String fieldName, int[] lowerValueRange, int[] higherValueRange) {
        this.fieldName = fieldName;
        this.lowerValueRange = lowerValueRange;
        this.higherValueRange = higherValueRange;
    }

    public String getFieldName() {
        return fieldName;
    }

    public int[] getLowerValueRange() {
        return lowerValueRange;
    }

    public int[] getHigherValueRange() {
        return higherValueRange;
    }

    public boolean isValueValid(int value) {
        return value >= getLowerValueRange()[0] && value <= getLowerValueRange()[1] ||
                value >= getHigherValueRange()[0] && value <= getHigherValueRange()[1];
    }
}
