package net.salesianos.excercises.exercise4;

import java.io.Serializable;

public class Mesa implements Serializable {

    private String color;
    private int numeroPatas;

    public Mesa(String color, int numeroPatas) {
        this.color = color;
        this.numeroPatas = numeroPatas;
    }

    @Override
    public String toString() {
        return "Mesa [Color: " + color + ", Número de patas: " + numeroPatas + "]";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumeroPatas() {
        return numeroPatas;
    }

    public void setNumeroPatas(int numeroPatas) {
        this.numeroPatas = numeroPatas;
    }

}
