package michal.kiecana.assignment.bootstrap;

import michal.kiecana.assignment.helpers.RandomNumberGenerator;
import michal.kiecana.assignment.repositories.RandomNumberRepository;
import org.springframework.boot.CommandLineRunner;

public class BootStrapData implements CommandLineRunner {

    private static final int AMOUNT = 10_000;

    private final RandomNumberRepository randomNumberRepository;
    private final RandomNumberGenerator randomNumberGenerator;

    public BootStrapData(RandomNumberRepository randomNumberRepository, RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberRepository = randomNumberRepository;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public void run(String... args)  {
        randomNumberRepository.saveAll(randomNumberGenerator.generateRandomNumberList(AMOUNT));
    }


}
