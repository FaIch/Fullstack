package edu.ntnu.calculator.back_end.services;

import edu.ntnu.calculator.back_end.models.Equation;
import edu.ntnu.calculator.back_end.models.User;
import edu.ntnu.calculator.back_end.repositories.CalculationRepository;
import edu.ntnu.calculator.back_end.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CalculationRepository calculationRepository;

    public User addUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        user.setSalt(salt);
        byte[] hashedPassword = hashPassword(password, salt);
        user.setPassword(hashedPassword);
        if (user.getUsername() == null || user.getSalt() == null || user.getPassword() == null)
            return null;
        return userRepository.save(user);
    }

    private byte[] hashPassword(String password, byte[] salt) {
        int iterationCount = 65536;
        int keyLength = 128;
        KeySpec spec = new PBEKeySpec(
                password.toCharArray(),
                salt,
                iterationCount,
                keyLength
        );
        SecretKeyFactory factory;

        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return factory.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            return null;
        }
    }


    public boolean login(String username, String password){
        Optional<User> optionalUser = userRepository.findById(username);
        if (optionalUser.isEmpty()) return false;
        User user = optionalUser.get();
        byte[] hashedPassword = hashPassword(password, user.getSalt());
        if(hashedPassword == null) return false;
        return Arrays.equals(hashedPassword, user.getPassword());
    }

    public void addEquation(String username, Equation equation){
        Optional<User> optionalUser = userRepository.findById(username);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            equation.setUser(user);
            calculationRepository.save(equation);
        }
    }

    public List<Equation> getEquations(String username){
        Optional<User> optionalUser = userRepository.findById(username);
        if (optionalUser.isEmpty()) return null;
        User user = optionalUser.get();
        List<Equation> equations = calculationRepository.findAll();
        return equations.stream().filter(e -> e.getUser().equals(user)).collect(Collectors.toList());
    }
}
