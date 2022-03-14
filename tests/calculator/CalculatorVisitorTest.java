package calculator;

import exceptions.MalformedExpressionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorVisitorTest {

    CalculatorVisitor calculatorVisitor;
    @BeforeEach
    void setup(){
        calculatorVisitor = new CalculatorVisitor();
    }

    @Test
    void getResultExceptionEmpty() {
        assertThrows(MalformedExpressionException.class, calculatorVisitor::getResult);
    }

    @Test
    void getResultExceptionBadInput() {
        Operand operand = new Operand(1);
        Operator operator = new Operator(Operation.MULTIPLY);
        operand.accept(calculatorVisitor);
        operator.accept(calculatorVisitor);

        assertThrows(MalformedExpressionException.class,calculatorVisitor::getResult);
    }

    @Test
    void getResult() throws MalformedExpressionException {
        Operand operand = new Operand(1);
        operand.accept(calculatorVisitor);

        assertEquals(1,calculatorVisitor.getResult());
    }

}