package edu.ntnu.calculator.back_end.repositories;

import edu.ntnu.calculator.back_end.models.Equation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationRepository extends JpaRepository<Equation, Integer> {
}
