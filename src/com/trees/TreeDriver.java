package com.trees;

public class TreeDriver {

	public static void main(String[] args) {
		
		BTNode<String> head = new BTNode<>("k");
		head.setLeft(new BTNode<String>("l"));
		head.setRight(new BTNode<String>("j"));
		head.getLeft().setLeft(new BTNode<String>("z"));
		head.getLeft().getLeft().setRight(new BTNode<String>("a"));
		BinaryTree<String> binaryTree = new BinaryTree<String>(head);
		binaryTree.inOrderTraversal();
		
		try {
			BinaryTree<String> bt2 = (BinaryTree<String>)binaryTree.clone();
			System.out.println(bt2.equals(binaryTree));
			bt2.getHead().getLeft().setData("M");
			System.out.println(bt2.equals(binaryTree));

			bt2.inOrderTraversal();
			System.out.println();
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		binaryTree.inOrderTraversalIterative();
		System.out.println();
		binaryTree.preOrderTraversal();
		binaryTree.postOrderTraversal();
		
		System.out.println(binaryTree.getHeight());
		System.out.println(binaryTree.deepestNode().toString());
		
		System.out.println(binaryTree.size());
		
		
	}

}
