package calculator;

import dataStructures.LinkedStack;
import exceptions.MalformedExpressionException;

import java.util.EmptyStackException;

public class CalculatorVisitor implements Calculator, Visitor {
    private final LinkedStack<Operand> tokenStack;

    public CalculatorVisitor() {
        tokenStack = new LinkedStack<>();
    }

    private void pushOperand(Operand operand) {
        tokenStack.push(operand);
    }

    private void performOperation(Operator operator) throws MalformedExpressionException {


        Operand right;
        Operand left;
        try {
            right = tokenStack.pop();
            left = tokenStack.pop();
        } catch (EmptyStackException e) {
            throw new MalformedExpressionException(e.getMessage());
        }

        int result;
        switch (operator.getOperation()) {
            case ADD -> result = (left.getValue() + right.getValue());
            case SUBTRACT -> result = (left.getValue() - right.getValue());
            case MULTIPLY -> result = (left.getValue()) * right.getValue();
            default -> throw new MalformedExpressionException("Check your expression");
        }

        pushOperand(new Operand(result));

    }

    @Override
    public int getResult() throws MalformedExpressionException {

        try {
            Operand result = tokenStack.pop();
            if (!tokenStack.isEmpty()) {
                throw new MalformedExpressionException("Leftover operands!");
            }
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
