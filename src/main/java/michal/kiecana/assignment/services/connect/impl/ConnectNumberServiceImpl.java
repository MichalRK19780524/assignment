package michal.kiecana.assignment.services.connect.impl;

import michal.kiecana.assignment.dto.SetOfNumbers;
import michal.kiecana.assignment.services.connect.ConnectNumberService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.DoubleBinaryOperator;

@Service
public class ConnectNumberServiceImpl implements ConnectNumberService {
    @Override
    public List<SetOfNumbers> connectNumbers(List<Double> firstList, List<Double> secondList, DoubleBinaryOperator connectOperator) {
        if(firstList.size() != secondList.size()){
            throw new IllegalArgumentException("The first list must be the same size as the second");
        } else {
            List<SetOfNumbers> result = new ArrayList<>(firstList.size());
            ListIterator<Double> iterator = secondList.listIterator();
            for(double firstNumber : firstList){
                double secondNumber = iterator.next();
                double connectedNumber = connectOperator.applyAsDouble(firstNumber, secondNumber);
                SetOfNumbers element = new SetOfNumbers(firstNumber, secondNumber,connectedNumber);
                result.add(element);
            }
            return result;
        }
    }
}
