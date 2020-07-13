package com.hash;

import java.util.ArrayList;
import java.util.List;

public class CustomHash {

	public static class HashTable {
		ArrayList<String>[] buckets;
		int capacity;
		int size;

		double loadFactor = 0.75;

		public HashTable() {
			// Separate chaining

			capacity = 5;
			size = 0;
			buckets = (ArrayList<String>[]) new ArrayList[capacity];

			for (int i = 0; i < 5; i++) {
				buckets[i] = new ArrayList<String>();
			}
		}

		public int hashCode(String s) {
			final int HASH_TECH = 1;
			int result = 0;
			switch (-1) {
			case 1:
				for (int i = 0; i < s.length(); i++) {
					result += (int) s.charAt(i);
				}
				System.out.println(s + ": " + result + ": " + result % capacity);
				result = result % capacity;
				break;
				
			
			default:
				result = s.hashCode() % capacity;
			}
			return result;
		}

		public void insert(String s) {

			if (isThresholdReached()) {
				rehash();
			}
			int hash = hashCode(s);
			List<String> bucket = buckets[hash];
			for (int i = 0; i < bucket.size(); i++) {
				if (bucket.get(i) == s) {
					return;
				}
			}
			bucket.add(s);
			++size;
		}

		public boolean contains(String s) {
			int hash = hashCode(s);
			List<String> bucket = buckets[hash];
			for (int i = 0; i < bucket.size(); i++) {
				if (bucket.get(i) == s) {
					return true;
				}
			}
			return false;
		}

		public boolean isThresholdReached() {
			return Float.compare(size / (float) (capacity), (float) loadFactor) >= 0;
		}

		public void rehash() {
			ArrayList<String>[] oldBuckets = buckets;
			capacity = (int) Math.floor(capacity * 1.5);
			buckets = new ArrayList[capacity];

			for (int i = 0; i < capacity; i++) {
				buckets[i] = new ArrayList<String>();
			}

			size = 0;

			for (int i = 0; i < oldBuckets.length; i++) {
				if (oldBuckets[i] != null) {
					for (int j = 0; j < oldBuckets[i].size(); j++) {
						String item = oldBuckets[i].get(j);
						insert(item);
					}
				}
			}
		}

		@Override
		public String toString() {
			String res = "";
			res += "capacity: " + capacity + ", size: " + size + "\n";
			for (int i = 0; i < capacity; i++) {
				res += "[ " + i + "]" + "\n\t";
				for (int j = 0; j < buckets[i].size(); j++) {
					res += "-> " + buckets[i].get(j);
				}
				res += "\n";
			}
			return res;
		}

	}

	public static void main(String[] args) {
		HashTable h = new HashTable();

		for (Integer i = 10000; i < 11000; i += 5) {
			h.insert(i.toString());
		}

		System.out.println(h);

	}
}
