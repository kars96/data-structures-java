package com.linkedlist.doublylinkedlist;

import com.linkedlist.LinkedList;

public class DoublyLinkedList<T> extends LinkedList<T>{

	public DoublyLinkedList(DoubleEndedNode<T> head) {
		super(head);
	}
	
	public DoublyLinkedList() {
		super();
	}


	@Override
	public void insertAtStart(T data) {
		DoubleEndedNode<T> node = new DoubleEndedNode<T>(data);
		if(this.getHead() == null) {
			this.setHead(node);
		} else {			
			node.setNext(this.getHead());
			this.getHead().setPrev(node);
			this.setHead(node);
		}
	}
	
	@Override
	public void insertAtEnd(T data) {
		DoubleEndedNode<T> node = new DoubleEndedNode<T>(data);
		DoubleEndedNode<T> curr = this.getHead();
		if(curr == null) {
			this.setHead(node);
		} else {			
			while(curr.getNext() != null) {
				curr = curr.getNext();
			}
			curr.setNext(node);
			node.setPrev(curr);
		}
	}
	
	@Override
	public boolean insertAfter(T exData, T newData) {
		DoubleEndedNode<T> curr = this.getHead();
		while(curr != null && curr.getData() != exData) {
			curr = curr.getNext();
		}
		if(curr == null) {
			return false;
		} else {
			DoubleEndedNode<T> node = new DoubleEndedNode<T>(newData);
			node.setNext(curr.getNext());
			node.setPrev(curr);
			curr.setNext(node);
			if(node.getNext() != null) {
				node.getNext().setPrev(node);
			}
		}
		return true;
	}
	
	@Override
	public boolean insertBefore(T exData, T newData) {
		DoubleEndedNode<T> curr = this.getHead();
		while(curr != null && curr.getData() != exData) {
			curr = curr.getNext();
		}
		if(curr == null) {
			return false;
		} else {
			DoubleEndedNode<T> node = new DoubleEndedNode<T>(newData);
			node.setNext(curr);
			node.setPrev(curr.getPrev());
			curr.setPrev(node);
			if(node.getPrev() == null) {
				this.setHead(node);
			} else {
				node.getPrev().setNext(node);
			}
		}
		return true;
	}
	
	
	public DoubleEndedNode<T> getHead() {
		return (DoubleEndedNode<T>) super.getHead();
	}
	
	
}
