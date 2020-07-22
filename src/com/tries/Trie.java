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
	
	
	public void delete(String key) throws Exception {
		delete(this.head, key, 0);
	}
	
	
	public boolean isEmpty(TrieNode node) {
		return false;
	}
	
	private TrieNode delete(TrieNode node, String key, int level) throws Exception {
		if(node == null) {
			return null;
		}
		
		if(key.length() == level) {
			//completed iterating through key
			if(!node.isEndOfWord()) {
				// if key is absent
				throw new Exception("Key not found");
			}
			
			if(node.isEndOfWord()) {
				if(isEmpty(node)) {
					return null;
				} else {
					node.setEndOfWord(false);
					return node;
				}
			}
		}
		int charIndex = key.charAt(level) - 'a';
		node.children[charIndex] = delete(node.children[charIndex], key, level + 1);
		
		if(isEmpty(node)) {
			return null;
		}
		return node;
	}
}
