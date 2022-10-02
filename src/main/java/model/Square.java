package model;

import java.util.Objects;

public class Square {
    private String key;
    private int color;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Square(String key) {
        this.key = key;
    }

    public Square(String key, int color) {
        this.key = key;
        this.color = color;
    }
    public static String concatKey(int row, int column){
        return row+"_"+column;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;

        Square square = (Square) o;

        return Objects.equals(key, square.key);
    }

    @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }
}
