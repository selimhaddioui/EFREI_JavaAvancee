package fr.efrei.mavenapps;

public class Main {
    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        double val1 = 2, val2 = 3, sum, product;
        sum = calculation.sum(val1, val2);
        product = calculation.mult(val1, val2);
        System.out.println("Hello world!");
        System.out.println(val1 + " + " + val2 + " = " + sum);
        System.out.println(val1 + " * " + val2 + " = " + product);
    }
}