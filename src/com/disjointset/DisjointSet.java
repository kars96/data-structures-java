package com.disjointset;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
	private List<Integer> group;

	public DisjointSet() {
		this.group = new ArrayList<Integer>();
	}
	
	public DisjointSet(int verticesCount) {
		this.group = new ArrayList<Integer>();
		for(int i = 0; i < verticesCount; i++) {
			this.group.add(-1);
		}
		// TODO Auto-generated constructor stub
	}

	public List<Integer> getGroup() {
		return group;
	}

	
	public Integer findParent(Integer i) {
		// get the subset in which i belongs
		if(group.get(i) == -1) {
			return i;
		}
		
		return findParent(group.get(i));
		
	}
	
	public void union(int x, int y) {
		group.set(x, y); // group[x] = y
	}
	
}
