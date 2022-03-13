package dataStructures;

import exceptions.EmptyListException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    LinkedList<String> testList;

    @BeforeEach
    void setup(){
        testList = new LinkedList<>();
    }

    @Test
    void isEmpty() {
        assertTrue(testList.isEmpty());
    }

    @Test
    void isNotEmpty() {
        testList.addToFront("SomeData");
        assertFalse(testList.isEmpty());
    }

    @Test
    void sizeZero() {
        assertEquals(0,testList.size());
    }
    @Test
    void sizeOne(){
        testList.addToFront("SomeData");
        assertEquals(1,testList.size());
    }

    @Test
    void addToFront() {
        //covered in tests above
    }

    @Test
    void removeFirst() throws EmptyListException {
        testList.addToFront("SomeData");
        assertEquals("SomeData",testList.removeFirst());
    }

    @Test
    void removeFirstException() {
        assertThrows(EmptyListException.class, ()-> testList.removeFirst());
    }
}