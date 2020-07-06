package com.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
	private BTNode<T> head;
	
	public BinaryTree(BTNode<T> head) {
		this.head = head;
	}

	public BTNode<T> getHead() {
		return head;
	}

	public void setHead(BTNode<T> head) {
		this.head = head;
	}

	public void inOrderTraversal() {
		inOrderTraversal(head);
		System.out.println();
	}
	
	public void inOrderTraversal(BTNode<T> node) {
		if(node != null) {
			inOrderTraversal(node.getLeft());
			System.out.print(node.getData().toString() + " -> ");
			inOrderTraversal(node.getRight());
		}
	}
	
	public void preOrderTraversal() {
		preOrderTraversal(head);
		System.out.println();
	}
	
	public void preOrderTraversal(BTNode<T> node) {
		if(node != null) {
			System.out.print(node.getData().toString() + " -> ");
			preOrderTraversal(node.getLeft());
			preOrderTraversal(node.getRight());
		}
	}
	
	public void postOrderTraversal() {
		postOrderTraversal(head);
		System.out.println();
	}
	
	public void postOrderTraversal(BTNode<T> node) {
		if(node != null) {
			postOrderTraversal(node.getLeft());
			postOrderTraversal(node.getRight());
			System.out.print(node.getData().toString() + " -> ");
		}
	}
	
	public void inOrderTraversalIterative() {
		Deque<BTNode<T>> stack = new ArrayDeque<>();
		BTNode<T> currentNode = this.head;
		
		while(currentNode != null || stack.isEmpty() != true) {
			while(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeft();
			}
			currentNode = stack.pop();
			
			System.out.print(currentNode.getData().toString() + " -> ");
			
			currentNode = currentNode.getRight();
			
		}	
	}
	
	public void levelOrderTraversal() {
		Queue<BTNode<T>> queue = new LinkedList<>();
		
		queue.offer(head);
		
		while(queue.isEmpty() != true) {
			BTNode<T> node = queue.poll();
			
			System.out.print(node.getData().toString() + " -> ");
			
			if(node.getLeft() != null) {				
				queue.offer(node.getLeft());
			}
			if(node.getRight() != null) {				
				queue.offer(node.getRight());
			}
			
		}
	}
	
	public int getHeight() {
		if(head == null) {
			return 0;
		}
		return height(head);
	}
	
	public int height(BTNode<T> node) {
		if(node == null) {
			return 0;
		}
		
		return Math.max(height(node.getLeft()) + 1, height(node.getRight()) + 1);
	}
	
	
	public BTNode<T> deepestNode() {
		Queue<BTNode<T>> queue = new LinkedList<>();
		queue.offer(this.head);
		BTNode<T>  temp = null;
		while(queue.isEmpty() != true) {
			temp = queue.poll();
			
			if(temp.getLeft() != null) {
				queue.offer(temp.getLeft());
			}
			
			if(temp.getRight() != null) {
				queue.offer(temp.getRight());
			}
		}
		
		return temp;
	}
	
	public int size() {
		return size(head) + 1;
	}
	
	public int size(BTNode<T> node) {
		if(node == null) {
			return 0;
		}
		
		if(node.getLeft() != null && node.getRight() != null) {
			return 2 + size(node.getLeft()) + size(node.getRight());
		} else if(node.getLeft() != null || node.getRight() != null){
			return 1 + size(node.getLeft()) + size(node.getRight());
		}
		return 0;
		
	}
	
	public void insert(BTNode<T> node) {
		
		if(head == null) {
			this.head = node;
			return;
		}
		
		Queue<BTNode<T>> queue = new LinkedList<>();
		queue.offer(this.head);
		BTNode<T>  temp = null;
		while(queue.isEmpty() != true) {
			temp = queue.poll();
			
			if(temp.getLeft() != null) {
				queue.offer(temp.getLeft());
			} else {
				temp.setLeft(node);
				return;
			}
			
			if(temp.getRight() != null) {
				queue.offer(temp.getRight());
			} else {
				temp.setRight(node);
				return;
			}
		}
	}
	
	public void insert(T data) {
		insert(new BTNode<T>(data));
	}
	 
}
