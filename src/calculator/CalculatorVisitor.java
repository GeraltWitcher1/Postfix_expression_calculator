package calculator;

import dataStructures.LinkedStack;
import exceptions.MalformedExpressionException;

import java.util.EmptyStackException;

public class CalculatorVisitor implements Calculator, Visitor {
    private LinkedStack<Operand> tokenStack;

    public CalculatorVisitor() {
        tokenStack = new LinkedStack<>();
    }

    private void pushOperand(Operand operand) {
        tokenStack.push(operand);
    }

    private void performOperation(Operator operator) throws MalformedExpressionException {
        Operand left = tokenStack.pop();
        Operand right = tokenStack.pop();

        int result;
        switch (operator.getOperation()){
            case ADD -> result=(left.getValue()+right.getValue());
            case SUBTRACT -> result=(left.getValue()- right.getValue());
            case MULTIPLY -> result=(left.getValue())* right.getValue();
            default -> throw new MalformedExpressionException("Check your expression");
        }

        pushOperand(new Operand(result));

    }

    @Override
    public int getResult() throws MalformedExpressionException {
        try {
            Operand result = tokenStack.pop();
            return result.getValue();
        } catch (EmptyStackException e) {
            throw new MalformedExpressionException(e.getMessage());
        }
    }

    @Override
    public void visit(Operand operand) {
        pushOperand(operand);
    }

    @Override
    public void visit(Operator operator) {
        try {
            performOperation(operator);
        } catch (MalformedExpressionException ignored) {
        }
    }
}
