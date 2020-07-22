package com.graph.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.graph.Graph;

public class GraphTest {
	
	Graph g;
	
	@Test
	public void shouldCreate() {
		g = new Graph(4);
		assertEquals(4, g.vCount());
	}
	
	@Test
	public void addEdge() {
		g = new Graph(3);
		try {
			g.addEdge(1, 2);
			g.addEdge(0, 1);
			assertEquals(g.getVertexEdges(1),  Arrays.asList(2, 0));
			assertEquals(g.getVertexEdges(0), Arrays.asList(1));
			assertEquals(g.getVertexEdges(2), Arrays.asList(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void removeEdge() {
		g = new Graph(3);
		
		try {
			g.addEdge(1, 2);
			g.addEdge(0, 1);
			g.removeEge(1, 0);
			assertEquals(g.getVertexEdges(0).size(), 0);
			assertEquals(g.getVertexEdges(1), Arrays.asList(2));
			g.removeEge(2, 1);
			assertEquals(g.getVertexEdges(2).size(), 0);
			assertEquals(g.getVertexEdges(1).size(), 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void addVertex() {
		g = new Graph(5);
		int index = g.addVertex();
		assertEquals(5, index);
		assertEquals(6, g.vCount());
	}
	
	@Test
	public void dfs() {
		g = new Graph(4);
		ArrayList<Integer> res = new ArrayList<Integer>();
		try {
			g.addEdge(1, 0);
			g.addEdge(2, 1);
			g.addEdge(2, 0);
			g.addEdge(3, 1);
			g.dfs(0, (u)->res.add((Integer) u));
			assertEquals(Arrays.asList(0,1,2,3 ), res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
