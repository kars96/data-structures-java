package com.trees;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

	public BinarySearchTree() {
		super(null);
	}
	
	@Override
	public void insert(BTNode<T> node) {
		if(getHead() == null) {
			setHead(node);
			return;
		} else {
			BTNode<T> curr = getHead();
			while(true) {				
				if(node.getLeft().getData().compareTo(curr.getData()) > 0) {
					if(curr.getRight() == null) {
						curr.setRight(node);
						break;
					}
					curr = curr.getRight();
				} else {
					if(curr.getLeft() == null) {
						curr.setLeft(node);
						break;
					}
					curr = curr.getLeft();	
				}
			}
		}
	}

}
