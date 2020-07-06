package com.trees;

public class BTNode<T> {
	private BTNode<T> left;
	private BTNode<T> right;
	private T data;
	
	
	public BTNode(BTNode<T> left, BTNode<T> right, T data) {
		super();
		this.left = left;
		this.right = right;
		this.data = data;
	}
	
	
	public BTNode(T data) {
		super();
		this.data = data;
	}


	public BTNode() {
		super();
	}


	public BTNode<T> getLeft() {
		return left;
	}
	public void setLeft(BTNode<T> left) {
		this.left = left;
	}
	public BTNode<T> getRight() {
		return right;
	}
	public void setRight(BTNode<T> right) {
		this.right = right;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "BTNode [data=" + data + "]";
	}
	
	
	
}
