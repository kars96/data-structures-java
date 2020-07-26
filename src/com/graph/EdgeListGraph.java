package com.graph;

import java.util.ArrayList;
import java.util.List;

public class EdgeListGraph {
	
	private int verticesCount;
	private List<Edge> edges;
	private int weight;
	
	public EdgeListGraph(int verticesCount) {
		super();
		this.edges = new ArrayList<Edge>();
		this.verticesCount = verticesCount;
		this.weight = 0;
	}
	public int getVerticesCount() {
		return verticesCount;
	}
	public void setVerticesCount(int verticesCount) {
		this.verticesCount = verticesCount;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
	public void addEdge(Edge e) {
		edges.add(e);
		this.weight += e.getWeight();
	}
}
