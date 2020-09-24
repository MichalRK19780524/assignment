package michal.kiecana.assignment.services.connect;

import java.util.List;
import java.util.function.DoubleBinaryOperator;


public interface ConnectNumberService {
    List<Double> connectNumbers(List<Double> firstList, List<Double> secondList, DoubleBinaryOperator connectOperator);
}
