package edu.ntnu.calculator.back_end.controllers;

import edu.ntnu.calculator.back_end.models.*;
import edu.ntnu.calculator.back_end.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/user")
    public User addUser(@RequestBody UserRequest request){
        return userService.addUser(request.getUsername(), request.getPassword());
    }

    @PostMapping("/login")
    public boolean login(@RequestBody UserRequest request){
        return userService.login(request.getUsername(), request.getPassword());
    }

    @PostMapping("/{username}/equation")
    public void addEquation(@PathVariable String username, @RequestBody Equation equation){
        userService.addEquation(username, equation);
    }

    @GetMapping("/{username}/equations")
    public List<Equation> getEquations(@PathVariable String username){
        return userService.getEquations(username);
    }
}
