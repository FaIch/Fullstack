package edu.ntnu.calculator.back_end.controllers;

import edu.ntnu.calculator.back_end.models.Equation;
import edu.ntnu.calculator.back_end.services.EquationService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class EquationController {

    @Autowired
    EquationService solver;

    @PostMapping("/calculate")
    @ResponseBody
    public Equation postEquation(@RequestBody Equation equation){
        solver.solve(equation);
        return equation;
    }

}
