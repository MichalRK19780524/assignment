package michal.kiecana.assignment.helpers;

import michal.kiecana.assignment.domain.RandomNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

    private static final double LEFT_LIMIT = 0.0;
    private static final double RIGHT_LIMIT = 1.0e4;

    private final Random random;

    public RandomNumberGenerator(Random random) {
        this.random = random;
    }

    public List<RandomNumber> generateRandomNumberList(int number){
        List<RandomNumber> result = new ArrayList<>(number);
        for (int i = 0; i < number; i++){
            result.add(generateRandomNumberBounded(LEFT_LIMIT, RIGHT_LIMIT));
        }
        return result;
    }

    private RandomNumber generateRandomNumberBounded(double leftLimit, double rightLimit) {
        double randomNumber = leftLimit + this.random.nextDouble() * (rightLimit - leftLimit);
        return new RandomNumber(randomNumber);
    }
}
