package day20;

public class SeaMonster {

    private final String head = "..................#.";
    private final String body = "#....##....##....###";
    private final String tail = ".#..#..#..#..#..#...";

    private final int length;
    private String headRGX, bodyRGX, tailRGX;

    public SeaMonster() {
        this.length = body.length();
        this.buildRegex();
    }

    private void buildRegex() {
        headRGX = head.replaceAll("#", "1");
        bodyRGX = body.replaceAll("#", "1");
        tailRGX = tail.replaceAll("#", "1");
    }

    public int countPieces() {
        return (head + body + tail).replaceAll("\\.", "").length();
    }

    public String getHeadRGX() {
        return headRGX;
    }

    public String getBodyRGX() {
        return bodyRGX;
    }

    public String getTailRGX() {
        return tailRGX;
    }

    public int getLength() {
        return length;
    }
}
