package com.calculator;

import com.calculator.beans.RequestBean;
import com.calculator.service.CalculationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class to test @{@link CalculationService}
 */
@SpringBootTest
public class CalculationServiceTest {
    @Autowired
    CalculationService calculationService;
    @Test
    void testAddition() {
        RequestBean requestBean = new RequestBean();
        requestBean.setOperandOne(2d);
        requestBean.setOperandTwo(2d);
        assertEquals(calculationService.getAdditionResult(requestBean).getResult(), 4.0);
    }

    @Test
    void testMultiplication() {
        RequestBean requestBean = new RequestBean();
        requestBean.setOperandOne(3d);
        requestBean.setOperandTwo(2d);
        assertEquals(calculationService.getMultiplicationResult(requestBean).getResult(), 6.0);
    }
}
