package com.hash;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
		ArrayList<String>[] buckets;
		
		public HashTable() {
			
			buckets = (ArrayList<String>[])new ArrayList[5];
			
			for(int i = 0; i < 5; i++) {
				buckets[i] = new ArrayList<String>();
			}
		}
		
		public int hashCode(String s) {
			int result = 0;
			for(int i =0; i< s.length(); i++) {
				result += (int)s.charAt(i);
			}
			System.out.println(s + ": "+ result + ": " + result%5);
			return result % 5;
		}
		
		public void insert(String s) {
			int hash = hashCode(s);
			List<String> bucket = buckets[hash];
			for(int i =0; i< bucket.size(); i++) {
				if(bucket.get(i) == s) {
					return;
				}
			}
			bucket.add(s);
		}
		
		public boolean contains(String s) {
			int hash = hashCode(s);
			List<String> bucket = buckets[hash];
			for(int i = 0; i < bucket.size(); i++) {
				if(bucket.get(i) == s) {
					return true;
				}
			}
			return false;
		}
		
		@Override
		public String toString() {
			String res = "";
			for(int i = 0; i < 5; i++) {
				res += "[ " + i + "]" + "\n\t";
				for(int j =0; j < buckets[i].size(); j++) {
					res += "-> " + buckets[i].get(j);
				}
			}
			return res;
		}
		
		
	}