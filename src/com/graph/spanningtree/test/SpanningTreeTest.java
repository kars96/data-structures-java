package com.graph.spanningtree.test;

import org.junit.Test;

import com.graph.Edge;
import com.graph.EdgeListGraph;
import com.graph.spanningtree.SpanningTree;

public class SpanningTreeTest {

	@Test
	public void spanningTreeTest() {
		EdgeListGraph g = new EdgeListGraph(5);
		g.addEdge(new Edge(0, 4, 8));
		g.addEdge(new Edge(4, 3, 4));
		g.addEdge(new Edge(3, 2, 2));
		g.addEdge(new Edge(2, 1, 1));
		g.addEdge(new Edge(1, 0, 3));
		g.addEdge(new Edge(0, 3, 7));
		g.addEdge(new Edge(1, 3, 3));
		
		EdgeListGraph sp = SpanningTree.getSpanningTreeUsingKruskal(g);
		
	}
}
