package michal.kiecana.assignment.helpers;

import michal.kiecana.assignment.domain.RandomNumber;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RandomNumberGenerator {

    private static final double LEFT_LIMIT = 0.0;
    private static final double RIGHT_LIMIT = 1.0e4;

    public List<RandomNumber> generateRandomNumberList(int number){
        List<RandomNumber> result = new ArrayList<>(number);
        for (int i = 0; i < number; i++){
            result.add(generateRandomNumberBounded(LEFT_LIMIT, RIGHT_LIMIT));
        }
        return result;
    }

    private RandomNumber generateRandomNumberBounded(double leftLimit, double rightLimit) {
        double random = leftLimit + new Random().nextDouble() * (rightLimit - leftLimit);
        return new RandomNumber(random);
    }
}
