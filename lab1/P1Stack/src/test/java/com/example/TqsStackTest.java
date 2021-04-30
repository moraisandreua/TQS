package com.example;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TqsStackTest {

    private TqsStack<Integer> stack;

    // é chamado antes de cada teste
    @BeforeEach
    void setUp() {
        stack = new TqsStack<>();
        System.out.println("Novo teste");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {

    }

    @DisplayName("Alínea a)")
    @Test
    void testEmptyOnConstruction() {
        assertTrue(stack.isEmpty());
    }

    @DisplayName("Alínea b)")
    @Test
    void testSizeZeroConstruction() {
        assertEquals(0, stack.size());
    }

    @DisplayName("Alínea c)")
    @Test
    void testPushNSize() {
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }

        assertTrue(!stack.isEmpty());
        assertEquals(100, stack.size());
    }

    @DisplayName("Alínea d)")
    @Test
    void testPushNPop() {
        stack.push(1774);
        Object v = stack.pop();
        assertEquals(1774, v);
    }


    @DisplayName("Alínea e)")
    @Test
    void testPushNPeek() {
        stack.push(1774);
        Object v = stack.peek();
        assertEquals(1774, v);
        assertEquals(1, stack.size());
    }

    @DisplayName("Alínea f)")
    @Test
    void testPopToEmpty() {
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }

        for (int i = 0; i < 100; i++) {
            Object v = stack.pop();
        }

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @DisplayName("Alínea g)")
    @Test
    void testPopNoElementException() {
        assertThrows(NoSuchElementException.class, () -> {
            stack.pop();
        });
    }

    @DisplayName("Alínea h)")
    @Test
    void testPeekNoElementException() {
        assertThrows(NoSuchElementException.class, () -> {
            stack.peek();
        });
    }

    @DisplayName("Alínea i)")
    @Test
    void testThrowIllegal() {
        stack = new TqsStack<Integer>(100);

        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }

        assertThrows(IllegalStateException.class, () -> {
            stack.push(1774);
        });
    }
}