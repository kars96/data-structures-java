package com.tries;

public class Trie {
	private TrieNode head;
	
	public Trie() {
		head = new TrieNode();
	}
	
	
	
	public TrieNode getHead() {
		return head;
	}



	public void setHead(TrieNode head) {
		this.head = head;
	}



	public void insert(String key) {
		TrieNode curr = head;
		for(int level = 0; level < key.length(); level++) {
			int charToIndex = key.charAt(level) - 'a';
			if(curr.children[charToIndex] == null) {
				curr.children[charToIndex] = new TrieNode();
			}
			curr = curr.children[charToIndex];
		}
		
		curr.setEndOfWord(true);
	}
	
	public boolean search(String key) {
		TrieNode curr = head;
		for(int level = 0; level < key.length(); level++) {
			int charToIndex = key.charAt(level) - 'a';
			if(curr.getChildren()[charToIndex] == null) {
				return false;
			}
			curr = curr.getChildren()[charToIndex];
			
		}
		return (curr != null) && curr.isEndOfWord();
	}
}
