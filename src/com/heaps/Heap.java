package com.heaps;

import java.util.LinkedList;
import java.util.List;

public abstract class Heap<T extends Comparable<T>> {

	/*
	 * Heap is a complete binary tree.
	 * Min heap: parent <= children
	 * Max heap: parent >= children
	 * 
	 * parentPos(i) = floor((i - 1)/2)
	 * 
	 * children(p) = 2p + 1 and 2(p + 1)
	 */

	enum HeapType {
		MIN_HEAP, MAX_HEAP
	}

	private List<T> arr;

	private HeapType type;

	public List<T> getArr() {
		return arr;
	}

	public void setArr(List<T> arr) {
		this.arr = arr;
	}


	public int getCount() {
		return arr.size();
	}

	public HeapType getType() {
		return type;
	}

	public Heap() {
		this.arr = new LinkedList<T>();
		this.type = HeapType.MAX_HEAP;
	}

	
	public Heap(HeapType type) {
		this();
		this.type = type;
	}

	public int getParentPos(int i) {
		if( i <= 0 || i >= this.getCount()) {
			return -1;
		}
		return (int)((i - 1) / 2);
	}
	
	public int getLeftChildIndex(int p) {
		int childPos = (2 * p) + 1;
		return childPos < 0 || childPos >= this.getCount() ? -1 : childPos;
	}
	
	public int getRightChildIndex(int p) {
		int childPos = 2 * (p + 1);
		return childPos < 0 || childPos >= this.getCount() ? -1 : childPos;
	}
	
	public T getLeftChild(int p) {
		int index = getLeftChildIndex(p);
		if(index > -1) {
			return arr.get(index);
		} else {
			return null;
		}
	}
	
	
	public T getRightChild(int p) {
		int index = getRightChildIndex(p);
		if(index > -1) {
			return arr.get(index);
		} else {
			return null;
		}
	}
	
	public T getRootValue() {
		if(this.getCount() == 0) {
			return null;
		}
		return this.arr.get(0);
	}
	
	public T delete() {
		T data = null;
		if(getCount() == 1) {
			data = getRootValue();
			arr.clear();
		} else if(getCount() > 1) {
			data = getRootValue();
			T lastEle = arr.get(getCount() - 1);
			arr.remove(getCount() - 1);
			arr.set(0, lastEle);
			
			percolateDown(0);
		}
		
		return data;
	}
	
	public void add(T data) {
		arr.add(getCount(), data);
		
		percolateUp(getCount() - 1);
	}
	
	public abstract void percolateDown(int i);
	
	public abstract void percolateUp(int i);
	
}
