package com.graph;

public class Edge {
	private int src;
	private int dest;
	private int weight;
	
	public Edge(int src, int dest, int weight) {
		super();
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
	
	public int getSrc() {
		return src;
	}
	public void setSrc(int src) {
		this.src = src;
	}
	public int getDest() {
		return dest;
	}
	public void setDest(int dest) {
		this.dest = dest;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%d -> %d : %d", src, dest, weight);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dest;
		result = prime * result + src;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (dest != other.dest)
			return false;
		if (src != other.src)
			return false;
		return true;
	}
	
	
	
}	
