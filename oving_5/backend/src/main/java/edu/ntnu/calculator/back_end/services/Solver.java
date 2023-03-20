package edu.ntnu.calculator.back_end.services;

import edu.ntnu.calculator.back_end.models.Equation;
import org.springframework.stereotype.Service;

@Service
public class Solver {

    public void solve(Equation equation){
        String equationString = equation.getEquation();
        String[] split = equationString.split("(?<=\\d)(?=[+\\-x÷])|(?<=[+\\-x÷])(?=\\d)");
        double result = Double.parseDouble(split[0]);
        for (int i = 1; i < split.length; i+=2) {
            switch (split[i]) {
                case "+": {
                    result += Double.parseDouble(split[i + 1]);
                    break;
                }
                case "-": {
                    result -= Double.parseDouble(split[i + 1]);
                    break;
                }
                case "x": {
                    result *= Double.parseDouble(split[i + 1]);
                    break;
                }
                case "÷": {
                    result /= Double.parseDouble(split[i + 1]);
                    break;
                }
            }
        }
        equation.setSolution(result);
    }
}

