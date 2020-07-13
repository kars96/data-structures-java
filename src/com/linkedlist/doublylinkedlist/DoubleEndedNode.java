package com.linkedlist.doublylinkedlist;

import com.linkedlist.Node;

public class DoubleEndedNode<T> extends Node<T> {
	
	Node<T> prev;
	
	public DoubleEndedNode(T data) {
		super(data);
	}
	
	
	public Node<T> getPrev() {
		return prev;
	}
	
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	public DoubleEndedNode<T> getNext() {
		return (DoubleEndedNode<T>) super.getNext();
	}

}
