package com.example;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class TqsStack<T> {
    private LinkedList ll;
    private Integer limit;

    public TqsStack() {
        this.ll = new LinkedList<>();
        limit = -1;
    }

    public TqsStack(Integer limit) {
        this.ll = new LinkedList<>();
        this.limit = limit;
    }

    public boolean isEmpty() {
        return this.ll.isEmpty();
    }

    public void push(T element) {
        if (limit != -1 && ll.size() < limit) {
            this.ll.push(element);
        } else if (limit != -1 && ll.size() >= limit) {
            throw new IllegalStateException();
        } else {
            this.ll.push(element);
        }
    }

    public Object pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return ll.pop();
        }
    }

    public Object peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return ll.peek();
        }
    }

    public int size() {
        return this.ll.size();
    }
}