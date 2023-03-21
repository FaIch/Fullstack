package edu.ntnu.calculator.back_end.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Equation{

    @Id
    @GeneratedValue
    private int id;
    private String equation;
    private double solution;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_name")
    private User user;

    public Equation(int id, String equation, double solution, User user) {
        this.id = id;
        this.equation = equation;
        this.solution = solution;
        this.user = user;
    }

    public Equation(){}


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
