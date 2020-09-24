package michal.kiecana.assignment.services.connect.impl;

import michal.kiecana.assignment.services.connect.ConnectNumberService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

@Service
public class ConnectNumberServiceImpl implements ConnectNumberService {
    @Override
    public List<Double> connectNumbers(List<Double> firstList, List<Double> secondList, DoubleBinaryOperator connectOperator) {
        if(firstList.size() != secondList.size()){
            throw new IllegalArgumentException("The first list must be the same size as the second");
        } else {
            List<Double> result = new ArrayList<>(firstList.size());
            for(double number : firstList){
                result.add(connectOperator.applyAsDouble(number, secondList.iterator().next()));
            }
            return result;
        }
    }
}
