package com.heaps;

import com.heaps.Heap.HeapType;

public class HeapDriver {

	public static void main(String[] args) {
		Heap<Integer> h = new Heap<>(HeapType.MAX_HEAP);
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
		
		h = new Heap<>(HeapType.MIN_HEAP);
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
