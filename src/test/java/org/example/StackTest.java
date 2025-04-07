package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack stack ;
    @BeforeEach
    void setup(){
        stack = new Stack();
    }

    @Test
    void newStackShouldBeEmpty() {

        assertTrue(stack.isEmpty());
    }

    @Test
    void pushShouldAddElementToStack() {

        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    void popShouldRemoveAndReturnTopElement() {

        stack.push(5);
        stack.push(15);
        assertEquals(15, stack.pop());
        assertEquals(1, stack.size());
    }

    @Test
    void popShouldThrowExceptionWhenStackIsEmpty() {

        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    void peekShouldReturnTopElementWithoutRemovingIt() {
        Stack stack = new Stack();
        stack.push(20);
        assertEquals(20, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void peekShouldThrowExceptionWhenStackIsEmpty() {
        Stack stack = new Stack();
        assertThrows(IllegalStateException.class, stack::peek);
    }

    @Test
    void pushShouldExpandCapacityWhenFull() {
        Stack stack = new Stack();
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        assertEquals(15, stack.size());
        assertEquals(14, stack.peek());
    }
}