package dataStructures;

import exceptions.EmptyListException;

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {

    private final LinkedList<T> list;

    public LinkedStack(){
        this.list = new LinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(T element) {
        list.addToFront(element);
    }

    @Override
    public T pop() throws EmptyStackException {
        try {
            return list.removeFirst();
        } catch (EmptyListException e) {
            throw new EmptyStackException();
        }
    }
}
