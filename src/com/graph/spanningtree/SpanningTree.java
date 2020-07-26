package com.graph.spanningtree;

import java.util.Collections;
import java.util.List;

import com.disjointset.DisjointSet;
import com.graph.Edge;
import com.graph.EdgeListGraph;
import com.graph.WeightedGraph;

public class SpanningTree {

	public static EdgeListGraph getSpanningTreeUsingKruskal(EdgeListGraph g) {
		EdgeListGraph spanningTree = new EdgeListGraph(g.getVerticesCount());

		// Sort the graph edges

		Collections.sort(g.getEdges(), (e1, e2) -> {
			return e1.getWeight() - e2.getWeight();
		});

		DisjointSet groups = new DisjointSet(g.getVerticesCount());

		for (Edge e : g.getEdges()) {
			Integer parentSrc = groups.findParent(e.getSrc());
			Integer parentDest = groups.findParent(e.getDest());

			if (parentSrc == parentDest) {
				// cycle exists

			} else {
				spanningTree.addEdge(e);

				groups.union(e.getSrc(), e.getDest());
				if (spanningTree.getEdges().size() == g.getVerticesCount() - 1) {
					break;
				}
			}
		}

		return spanningTree;
	}

	public static WeightedGraph getSpanningTreeUsingPrim(WeightedGraph g) throws Exception {
		WeightedGraph sp = new WeightedGraph(g.vCount());
		boolean visited[] = new boolean[g.vCount()];
		int visitedCount = 0;
		int[] parent = new int[g.vCount()];

		int[] keyValues = new int[g.vCount()];

		final int ENTRY_POINT = 0;

		for (int i = 0; i < g.vCount(); i++) {
			if (i == ENTRY_POINT) {
				keyValues[i] = 0;
			} else {
				keyValues[i] = Integer.MAX_VALUE;
			}
		}

		while (visitedCount < g.vCount()) {
			int u = getUnvisitedVertex(visited, keyValues);

			visited[u] = true;

			for (Edge e : g.getVertexEdges(u)) {
				int v = e.getDest();
				if (visited[v] == false && e.getWeight() < keyValues[v]) {
					parent[v] = u;
					keyValues[v] = e.getWeight();
				}
			}
		}

		for (int i = 0; i < parent.length; i++) {
			if (keyValues[i] != -1)
				sp.addEdge(i, parent[i], keyValues[i]);
		}

		return sp;
	}

	private static int getUnvisitedVertex(boolean[] visited, int[] keyValues) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == false && keyValues[i] < min) {
				min = keyValues[i];
				min_index = i;
			}
		}

		return min_index;
	}
}
