package com.graph;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

public class Graph {
	// Adjacency list
	
	
	ArrayList<ArrayList<Integer>> adj;
	int eCount;
	
	public Graph(int vertexCount) {
		adj = new ArrayList();
		for(int i =0; i< vertexCount; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int u, int v) throws Exception {
		if(u < vCount() && v < vCount() && !adj.get(u).contains(v)) {
			adj.get(u).add(v);
			adj.get(v).add(u);
			eCount++;
		} else {
			throw new Exception("Vertex not available or edge exists");
		}
	}
	
	public void removeEge(int u, int v) throws Exception {
		if(u < vCount() && v < vCount()) {
			boolean success = adj.get(u).remove((Integer)v);
			success |= adj.get(v).remove((Integer)u);
			if(!success) {
				throw new Exception("No edge present");
			}
			eCount--;
		} else {
			throw new Exception("Vertex not available");
		}
	}
	
	public int degree(int u) throws Exception {
		if(u < vCount()) {
			return adj.get(u).size();
		} else {
			throw new Exception("Vertex no available");
		}
	}
	
	public int addVertex() {
		adj.add(new ArrayList<Integer>());
		return adj.size() - 1; // return index of new vertex
	}
	
	public void removeVertex(int u) {
		if(u < vCount()) {
			for(Integer v: adj.get(u)) {
				adj.get(v).remove((Integer)u);
			}
			adj.get(u).clear();
		}
	}
	
	public ArrayList<Integer> getVertexEdges(int u) throws Exception {
		if(u < vCount()) {
			return adj.get(u);
		} else {
			throw new Exception("Vertex not available");
		}
	}
	public int vCount() {
		return adj.size();
	}
	

	public void dfs(int u, Consumer<Integer> f) {
		boolean[] visited = new boolean[vCount()]; // default initailized to false
		dfsRecursive(u , visited, f);
	}

	private void dfsRecursive(int u, boolean[] visited, Consumer<Integer> f) {
		visited[u] = true;
		f.accept(u);
		for(Integer v: adj.get(u)) {
			if(!visited[v]) {
				dfsRecursive(v, visited, f);	
			}
		}
	}
	
}
