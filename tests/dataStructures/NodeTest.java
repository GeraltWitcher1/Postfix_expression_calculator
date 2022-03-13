package dataStructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    private Node<String> testNode;

    @BeforeEach
    void setup(){
        testNode = new Node<>("Hello");
    }

    @Test
    void setData() {
        testNode.setData("Test");
        assertEquals("Test",testNode.getData());
    }

    @Test
    void getData() {
        assertEquals("Hello",testNode.getData());
    }

    @Test
    void getNext() {
        assertNull(testNode.getNext());
    }

    @Test
    void setNext() {
        Node<String> node2 = new Node<>("Second node!");
        testNode.setNext(node2);
        assertEquals(testNode.getNext(),node2);
    }

}