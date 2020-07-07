package com.tries;

public class TrieNode {
	private static final int ALPHABET_COUNT = 26;
	TrieNode[] children;
	private boolean endOfWord;
	
	public TrieNode() {
		children = new TrieNode[ALPHABET_COUNT];
		for(int i = 0; i < ALPHABET_COUNT; i++) {
			children[i] = null;
		}
		endOfWord =  false;
	}

	public TrieNode[] getChildren() {
		return children;
	}

	public void setChildren(TrieNode[] children) {
		this.children = children;
	}

	public boolean isEndOfWord() {
		return endOfWord;
	}

	public void setEndOfWord(boolean endOfWord) {
		this.endOfWord = endOfWord;
	}
	
	
}
