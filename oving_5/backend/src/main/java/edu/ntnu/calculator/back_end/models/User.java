package edu.ntnu.calculator.back_end.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    private String username;
    private byte[] password;
    private byte[] salt;
}
