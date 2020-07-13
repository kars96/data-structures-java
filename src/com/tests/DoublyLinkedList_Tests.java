package com.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.linkedlist.doublylinkedlist.DoubleEndedNode;
import com.linkedlist.doublylinkedlist.DoublyLinkedList;

public class DoublyLinkedList_Tests {
	
	DoublyLinkedList<Integer> dl;
	
	@Before()
	public void setUp() {
		dl = new DoublyLinkedList<Integer>();
	}
	
	
	public String getdlString() {
		String s = "";
		DoubleEndedNode<Integer> head = dl.getHead();
		while(head != null) {
			s = s + "->" + head.getData().toString();
			head = head.getNext();
		}
		return s;
	}
	public void getDummyList() {
		this.dl.insertAtEnd(1);
		this.dl.insertAtEnd(2);
		this.dl.insertAtEnd(3);
		this.dl.insertAtEnd(4);
	}
	
	@Test
	public void insertAt() {
		dl.insertAtStart(1);
		
		assertEquals((Integer)1, dl.getHead().getData());
		
		dl.insertAtStart(2);
		
		assertEquals("->2->1", getdlString());
		
		dl.insertAtStart(3);
		assertEquals("->3->2->1", getdlString());

	}
	
	
	
}
