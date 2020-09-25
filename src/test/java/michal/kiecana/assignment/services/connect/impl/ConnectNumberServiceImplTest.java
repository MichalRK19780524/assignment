package michal.kiecana.assignment.services.connect.impl;

import michal.kiecana.assignment.dto.SetOfNumbers;
import michal.kiecana.assignment.services.connect.ConnectNumberService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConnectNumberServiceImplTest {

    @Test
    void shoudMultiplyListOfNumbers() {
        double n11 = 111.1;
        double n12 = 22.22;
        double n13 = 3.333;

        double n21 = 444.4;
        double n22 = 55.55;
        double n23 = 6.666;

        List<Double> l1 = Arrays.asList(n11,n12,n13);
        List<Double> l2 = Arrays.asList(n21,n22,n23);
        ConnectNumberService connectNumberService = new ConnectNumberServiceImpl();
        List<SetOfNumbers> result = connectNumberService.connectNumbers(l1, l2, (x, y) -> x * y );

        assertEquals(result.get(0).getConnected(), n11 * n21, 1.0e-7);
        assertEquals(result.get(1).getConnected(), n12 * n22, 1.0e-7);
        assertEquals(result.get(2).getConnected(), n13 * n23, 1.0e-7);
    }
}