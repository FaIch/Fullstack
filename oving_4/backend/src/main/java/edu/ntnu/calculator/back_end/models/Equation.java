package edu.ntnu.calculator.back_end.models;

public class Equation{
    private final String equation;
    private double solution;

    public Equation(String equation){
        this.equation = equation;
    }

    public String getEquation() {
        return equation;
    }

    public void setSolution(double solution) {
        this.solution = solution;
    }

    public double getSolution() {
        return solution;
    }
}
