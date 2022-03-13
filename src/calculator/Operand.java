package calculator;

public class Operand extends Token{
    private int value;


    public Operand(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void accept(CalculatorVisitor visitor){
        visitor.visit(this);
    }
}
