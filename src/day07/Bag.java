package day07;

import java.util.Map;

public class Bag {

    private final String color;
    private final Map<String, Integer> content; // <BagColor, Amount>

    public Bag(String color, Map<String, Integer> content) {
        this.color = color;
        this.content = content;
    }

    public String getColor() {
        return color;
    }

    public Map<String, Integer> getContent() {
        return content;
    }
}
