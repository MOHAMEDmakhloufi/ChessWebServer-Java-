package model;

public class Piece {
    private int color;
    private String key="";
    private int power;

    public Piece() {
    }

    public Piece(int color, String key, int power) {
        this.color = color;
        this.key = key;
        this.power = power;

    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return key;
    }
}
