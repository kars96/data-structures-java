package com.tries.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.tries.Trie;
import com.tries.TrieNode;

public class TrieTest {
	
	Trie t;
	
	@Before
	public void setUp() {
		t = new Trie();
		
	}
	
	@Test
	public void insertIntoTrie() {
		t.insert("kar");
		t.insert("kart");
		TrieNode kchild = t.getHead().getChildren()['k' - 'a'];
		assertNotNull(kchild);
		TrieNode achild = kchild.getChildren()['a' - 'a'];
		assertNotNull(achild);
		TrieNode rchild = achild.getChildren()['r' - 'a'];
		assertNotNull(rchild);
		
		assertTrue(rchild.isEndOfWord());
		
		TrieNode tchild = rchild.getChildren()['t' - 'a'];
		assertTrue(tchild.isEndOfWord());
	}
	
	@Test 
	public void searchTrie() {
		t.insert("there");
		t.insert("the");
		t.insert("answer");
		t.insert("any");
		t.insert("i");
		
		Arrays.asList("there", "the", "answer", "any", "i").forEach(
				(str) -> assertTrue(t.search(str)));
		
		Arrays.asList("th", "ans", "").forEach(
				(str) -> assertFalse(t.search(str)));
	}
	
	@Test
	public void deleteTrieKey() throws Exception {
		t.insert("there");
		t.insert("the");
		t.insert("answer");
		t.insert("any");
		t.insert("i");
		
		t.delete("the");
		
		assertFalse(t.search("the"));
		

		t.delete("there");

		assertFalse(t.search("there"));
		
		try {
			t.delete("an");
			assertTrue(false);
		} catch(Exception e) {
			assertEquals("Key not found", e.getMessage());
		}
	}
}
