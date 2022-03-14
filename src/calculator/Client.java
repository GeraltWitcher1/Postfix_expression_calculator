package calculator;

import exceptions.MalformedExpressionException;

import java.util.ArrayList;

public class Client {


    private final CalculatorVisitor calculatorVisitor;

    public Client() {
        this.calculatorVisitor = new CalculatorVisitor();
    }

    public int evaluateExpression(ArrayList<Token> tokenList) throws MalformedExpressionException {
        for (Token token : tokenList) {
            token.accept(calculatorVisitor);
        }
        return calculatorVisitor.getResult();
    }

}
