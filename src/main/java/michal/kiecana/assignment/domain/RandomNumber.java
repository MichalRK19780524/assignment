package michal.kiecana.assignment.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RandomNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double randomDouble;

    public RandomNumber() {
    }

    public RandomNumber(double randomDouble) {
        this.randomDouble = randomDouble;
    }

    public double getRandomDouble() {
        return randomDouble;
    }
}
