package michal.kiecana.assignment.services.connect;

import michal.kiecana.assignment.dto.SetOfNumbers;

import java.util.List;
import java.util.function.DoubleBinaryOperator;


public interface ConnectNumberService {
    List<SetOfNumbers> connectNumbers(List<Double> firstList, List<Double> secondList, DoubleBinaryOperator connectOperator);
}
