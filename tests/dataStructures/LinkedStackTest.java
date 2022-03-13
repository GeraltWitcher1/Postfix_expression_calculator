package dataStructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

    LinkedStack<String> testStack;

    @BeforeEach
    void setup(){
        testStack = new LinkedStack<>();
    }

    @Test
    void isEmpty() {
        assertTrue(testStack.isEmpty());
    }

    @Test
    void isNotEmpty() {
        testStack.push("data");
        assertFalse(testStack.isEmpty());
    }

    @Test
    void push() {
        testStack.push("data");
        testStack.push("moredata");
        assertEquals("moredata",testStack.pop());
    }

    @Test
    void pop() {
        // covered in tests above
    }

    @Test
    void popException(){
        assertThrows(EmptyStackException.class, ()->testStack.pop());
    }
}