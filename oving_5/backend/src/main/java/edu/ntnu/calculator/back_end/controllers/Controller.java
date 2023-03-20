package edu.ntnu.calculator.back_end.controllers;

import edu.ntnu.calculator.back_end.models.Equation;
import edu.ntnu.calculator.back_end.services.Solver;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class Controller {

    @Autowired
    Solver solver;
    private final Logger logger = LoggerFactory.getLogger(Controller.class);

    @PostMapping("/calculate")
    @ResponseBody
    public Equation postEquation(@RequestBody Equation equation){
        logger.info("Data received: " + equation.getEquation());
        solver.solve(equation);
        logger.info("Result: " + equation.getSolution());
        return equation;
    }

}
