package ru.expressionservice;

public class main {
    public static void main(String[] args) {
        var r = -470-532;
        System.out.println(randomNumber());
    }

    public static String randomNumber() {
        var min = -1000.0;
        var max = 1000.0;
        var random = ((Math.random() * (max - min)) + min);
        return String.format("%.3f", random);
    }
}
