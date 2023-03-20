package edu.ntnu.calculator.back_end.repositories;

import edu.ntnu.calculator.back_end.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
