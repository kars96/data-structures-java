package com.stacks;

public class Stack {
	
	private int[] arr;
	private int top;
	Stack(int length) {
		arr = new int[length];
		top = -1;
	}
	
	public boolean isFull() {
		return top == arr.length - 1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void push(int value) throws Exception {
		if(isFull()) {
			throw new Exception("Stack is full");
		}
		arr[++top] = value;
	}
	
	public int peek() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack is empty");
		}
		return arr[top];
	}
	
	public int size() {
		return top + 1;
	}
	
	public int[] elements() {
		return arr;
	}
	
	public int pop() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack is empty");
		}
		int value = arr[top];
		top--;
		return value;
	}
	
}

