package edu.ntnu.calculator.back_end.models;

import lombok.Data;

@Data
public class UserRequest {

    private String username;
    private String password;

    public UserRequest(String username, String password){
        this.username = username;
        this.password = password;
    }
}
