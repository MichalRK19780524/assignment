package michal.kiecana.assignment.services.random.impl;

import michal.kiecana.assignment.domain.RandomNumber;
import michal.kiecana.assignment.helpers.RandomNumberGenerator;
import michal.kiecana.assignment.services.random.RandomNumberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RandomNumberServiceJavaImpl implements RandomNumberService {

    private final RandomNumberGenerator randomNumberGenerator;

    public RandomNumberServiceJavaImpl(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public List<Double> getRandomNumber(int number) {
        return randomNumberGenerator.generateRandomNumberList(number).stream()
                .map(RandomNumber::getRandomDouble)
                .collect(Collectors.toList());
    }
}
