package com.heaps;

public class MaxHeap<T extends Comparable<T>> extends Heap<T> {
	
	public MaxHeap() {
		super(HeapType.MAX_HEAP);
	}
	
	@Override
	public void percolateDown(int i) {
		while(i < getCount()) {
			int leftChildIndex = getLeftChildIndex(i);
			int rightChildIndex = getRightChildIndex(i);
			int max = i;
			T iVal = getArr().get(i);
			if(leftChildIndex != -1 && getArr().get(leftChildIndex).compareTo(iVal) > 0 ) {
				max = leftChildIndex;
			} 
			
			if(rightChildIndex != -1 && getArr().get(rightChildIndex).compareTo(getArr().get(max)) > 0 ) {
				max = rightChildIndex;
			}
			
			if(max != i) {
				T temp = getArr().get(max);
				getArr().set(max, iVal);
				getArr().set(i, temp);
				i = max;
			} else {
				break;
			}
			
		}
		
	}

	private T getMax(T leftChildVal, T rightChildVal) {
		if(leftChildVal.compareTo(rightChildVal) >= 1) {
			return leftChildVal;
		} else {
			return rightChildVal;
		}
	}

	@Override
	public void percolateUp(int i) {
		while(i != 0) {
			T iVal = getArr().get(i);
			int parentIndex = getParentPos(i);
			if(parentIndex != -1) {
				T parentVal = getArr().get(parentIndex);
				if(iVal.compareTo(parentVal) > 0) {
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
