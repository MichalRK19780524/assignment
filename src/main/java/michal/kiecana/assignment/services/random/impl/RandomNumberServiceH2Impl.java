package michal.kiecana.assignment.services.random.impl;

import michal.kiecana.assignment.domain.RandomNumber;
import michal.kiecana.assignment.repositories.RandomNumberRepository;
import michal.kiecana.assignment.services.random.RandomNumberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RandomNumberServiceH2Impl implements RandomNumberService {

    private final RandomNumberRepository randomNumberRepository;

    public RandomNumberServiceH2Impl(RandomNumberRepository randomNumberRepository) {
        this.randomNumberRepository = randomNumberRepository;
    }

    @Override
    public List<Double> getRandomNumber(int number) {
        Page<RandomNumber> page = randomNumberRepository.findAll(PageRequest.of(0,number));
        List<RandomNumber> randomNumberList = page.getContent();
        return randomNumberList.stream()
                .map(RandomNumber::getRandomDouble)
                .collect(Collectors.toList());
    }
}
