package com.heaps;

public class HeapDriver {

	public static void main(String[] args) {
		Heap<Integer> h = new MaxHeap<>();
		h.add(1);
		h.add(3);
		h.add(5);
		h.add(4);
		h.add(8);
		h.add(0);
		System.out.println(h.getArr());
		while(h.getCount() != 0) {
			System.out.println(h.delete());
		}
	}

}
