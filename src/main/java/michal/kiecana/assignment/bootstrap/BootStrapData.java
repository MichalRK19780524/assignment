package michal.kiecana.assignment.bootstrap;

import michal.kiecana.assignment.repositories.RandomNumberRepository;
import michal.kiecana.assignment.helpers.RandomNumberGenerator;
import michal.kiecana.assignment.services.connect.ConnectNumberService;
import michal.kiecana.assignment.services.connect.impl.ConnectNumberServiceImpl;
import michal.kiecana.assignment.services.random.impl.RandomNumberServiceH2Impl;
import michal.kiecana.assignment.services.random.impl.RandomNumberServiceJavaImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class BootStrapData implements CommandLineRunner {

    private static final int AMOUNT = 10_000;

    private final RandomNumberRepository randomNumberRepository;
    private final RandomNumberGenerator randomNumberGenerator;
    private final RandomNumberServiceH2Impl randomNumberServiceH2;
    private final RandomNumberServiceJavaImpl randomNumberServiceJava;
    private final ConnectNumberService connectNumberService;

    public BootStrapData(RandomNumberRepository randomNumberRepository, RandomNumberGenerator randomNumberGenerator, RandomNumberServiceH2Impl randomNumberServiceH2, RandomNumberServiceJavaImpl randomNumberServiceJava, ConnectNumberServiceImpl connectNumberService) {
        this.randomNumberRepository = randomNumberRepository;
        this.randomNumberGenerator = randomNumberGenerator;
        this.randomNumberServiceH2 = randomNumberServiceH2;
        this.randomNumberServiceJava = randomNumberServiceJava;
        this.connectNumberService = connectNumberService;
    }

    @Override
    public void run(String... args)  {
        randomNumberRepository.saveAll(randomNumberGenerator.generateRandomNumberList(AMOUNT));
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj ile liczb ma być pobrane z bazy danych i połączone (dodane) z liczbami wygenerowanymi przez generator liczb losowych. Ilość łączonych liczb nie może przekraczać 10 000");
        int number = input.nextInt();
        if(number > 10_000){
            System.out.println("Podałeś liczbę która przekracz dozwoloną wartość 10 000");
        }

        List<Double> randomBbNumbers = randomNumberServiceH2.getRandomNumber(number);
        List<Double> randomJavaNumbers = randomNumberServiceJava.getRandomNumber(number);
        List<Double> connectedNumbers = connectNumberService.connectNumbers(randomBbNumbers, randomJavaNumbers, Double::sum);
        System.out.println("|Liczba pobrana z bazy danych: | Liczba wygenerowana w programie:  | Suma liczb: |");
        for(int i = 0; i < number; i++){
            System.out.printf("|%30f|%35f|%13f|%n", randomBbNumbers.get(i), randomJavaNumbers.get(i), connectedNumbers.get(i));
        }
    }


}
