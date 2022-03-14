package calculator;

import exceptions.MalformedExpressionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private Client client;

    @BeforeEach
    void setup() {
        client = new Client();
    }

    @Test
    void evaluateExpression() throws MalformedExpressionException {
        Token[] tokens = { new Operand(4), new Operand(7), new Operator(Operation.MULTIPLY), new Operand(20), new Operator(Operation.SUBTRACT) };
        ArrayList<Token> tokenList = new ArrayList<>(Arrays.asList(tokens));
        assertEquals(8, client.evaluateExpression(tokenList));
    }

    @Test
    void evaluateExpressionType2() throws MalformedExpressionException {
        Token[] tokens = { new Operand(4), new Operand(7), new Operator(Operation.MULTIPLY), new Operand(20), new Operator(Operation.ADD) };
        ArrayList<Token> tokenList = new ArrayList<>(Arrays.asList(tokens));
        assertEquals(48, client.evaluateExpression(tokenList));
    }


    @Test
    void evaluateExpressionExceptionExtraOperand() {
        Token[] tokens = { new Operand(4), new Operand(7), new Operator(Operation.MULTIPLY), new Operand(20) };
        ArrayList<Token> tokenList = new ArrayList<>(Arrays.asList(tokens));
        assertThrows(MalformedExpressionException.class, ()->client.evaluateExpression(tokenList));

    }

    @Test
    void evaluateExpressionExceptionExtraOperator() {
        Token[] tokens = { new Operand(4), new Operand(7), new Operator(Operation.MULTIPLY), new Operator(Operation.MULTIPLY) };
        ArrayList<Token> tokenList = new ArrayList<>(Arrays.asList(tokens));
        assertThrows(MalformedExpressionException.class, ()->client.evaluateExpression(tokenList));

    }

}