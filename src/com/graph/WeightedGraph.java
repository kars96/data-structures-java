package com.graph;

import java.util.ArrayList;

public class WeightedGraph {
	ArrayList<ArrayList<Edge>> adj;
	int weight;
	int eCount;
	
	public WeightedGraph(int vertexCount) {
		this.adj = new ArrayList<ArrayList<Edge>>();
		this.weight = 0;
		for (int i = 0; i < vertexCount; i++) {
			adj.add(new ArrayList<Edge>());
		}
	}
	
	public void addEdge(int u, int v, int weight) throws Exception {
		if (u < vCount() && v < vCount() && !adj.get(u).contains(v)) {
			adj.get(u).add(new Edge(u, v, weight));
			adj.get(v).add(new Edge(v, u, weight));
			eCount++;
		} else {
			throw new Exception("Vertex not available or edge exists");
		}
	}

	public void removeEge(int u, int v) throws Exception {
		if (u < vCount() && v < vCount()) {
			boolean success = adj.get(u).remove(new Edge(u, v, 0));
			success |= adj.get(v).remove(new Edge(v, u, 0));
			if (!success) {
				throw new Exception("No edge present");
			}
			eCount--;
		} else {
			throw new Exception("Vertex not available");
		}
	}
	public ArrayList<Edge> getVertexEdges(int u) throws Exception {
		if (u < vCount()) {
			return adj.get(u);
		} else {
			throw new Exception("Vertex not available");
		}
	}
	
	public ArrayList<ArrayList<Edge>> getAdj() {
		return adj;
	}

	public void setAdj(ArrayList<ArrayList<Edge>> adj) {
		this.adj = adj;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int geteCount() {
		return eCount;
	}

	public void seteCount(int eCount) {
		this.eCount = eCount;
	}

	public int vCount() {
		return adj.size();
	}
	
}
