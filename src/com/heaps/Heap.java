package com.heaps;

import java.util.LinkedList;
import java.util.List;

import com.heaps.Heap.HeapType;

public class Heap<T extends Comparable<T>> {

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
	
	public void percolateDown(int i) {
		while(i < getCount()) {
			int leftChildIndex = getLeftChildIndex(i);
			int rightChildIndex = getRightChildIndex(i);
			int posToBeSwappedWith = i;
			T iVal = getArr().get(i);
			if(leftChildIndex != -1 && compare(getArr().get(leftChildIndex), iVal) ) {
				posToBeSwappedWith = leftChildIndex;
			} 
			
			if(rightChildIndex != -1 && compare(getArr().get(rightChildIndex), getArr().get(posToBeSwappedWith)) ) {
				posToBeSwappedWith = rightChildIndex;
			}
			
			if(posToBeSwappedWith != i) {
				T temp = getArr().get(posToBeSwappedWith);
				getArr().set(posToBeSwappedWith, iVal);
				getArr().set(i, temp);
				i = posToBeSwappedWith;
			} else {
				break;
			}
			
		}
		
	}


	private boolean compare(T t, T t2) {
		if(getType() == HeapType.MAX_HEAP) {
			return t.compareTo(t2) > 0;
		} else {
			return t.compareTo(t2) < 0;
		}
		
	}

	public void percolateUp(int i) {
		while(i != 0) {
			T iVal = getArr().get(i);
			int parentIndex = getParentPos(i);
			if(parentIndex != -1) {
				T parentVal = getArr().get(parentIndex);
				if(compare(iVal, parentVal)) {
					// swap child with parent 
					getArr().set(parentIndex, iVal);
					getArr().set(i, parentVal);
					i = parentIndex;
				} else {
					break;
				}
			} else {
				break;
			}
		}
		
	}
}
