package michal.kiecana.assignment.config;

import michal.kiecana.assignment.bootstrap.BootStrapData;
import michal.kiecana.assignment.helpers.RandomNumberGenerator;
import michal.kiecana.assignment.repositories.RandomNumberRepository;
import michal.kiecana.assignment.services.random.RandomNumberService;
import michal.kiecana.assignment.services.random.impl.RandomNumberServiceDbImpl;
import michal.kiecana.assignment.services.random.impl.RandomNumberServiceJavaImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class Config {

    @Bean("randomNumberServiceFirst")
    public RandomNumberService  randomNumberServiceFirst(RandomNumberRepository randomNumberRepository){
        return new RandomNumberServiceDbImpl(randomNumberRepository);
    }

    @Bean("randomNumberServiceSecond")
    public RandomNumberService  randomNumberServiceSecond(RandomNumberGenerator randomNumberGenerator){
        return new RandomNumberServiceJavaImpl(randomNumberGenerator);
    }

    @Bean
    public RandomNumberGenerator  randomNumberGenerator(Random random){
        return new RandomNumberGenerator(random);
    }


    @Bean
    public Random  random(){
        return new Random();
    }

    @Bean
    public BootStrapData bootStrapData(RandomNumberRepository randomNumberRepository, RandomNumberGenerator randomNumberGenerator){
        return new BootStrapData(randomNumberRepository, randomNumberGenerator);
    }
}
