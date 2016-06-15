package com.sher.ds.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/*
 * You should know, in decreasing order of importance:
	BFS
	DFS
	Topological Sort & Shortest-path in a DAG
	Dijkstra's algorithm
	Bellman-Ford
	A-star (A*)
	Floyd-Warshall (debatable, but it's 5 lines of code, so no reason not to know it)
 */
/**
 * Also do Programming Interview Question: Friend Circle Problem - Graph Theory
 *  Search youTube
 * @author snirkhe
 *
 */

public class Graph {

	Map<String, Vertex> verticesMap = new HashMap<String, Vertex>();
	//TreeSet to maintain a natural order. TreeSet is based on a tree{O(LogN)}
	Map<String, TreeSet<Edge>> adjListMap = new HashMap<String, TreeSet<Edge>>();
	int nv, ne;
	boolean directional = false;
	
	public Map<String, Vertex> getVerticesMap() {
		return verticesMap;
	}
	
	public Map<String, TreeSet<Edge>> getAdjListMap() {
		return adjListMap;
	}
	
	
	public Vertex getVertex(String name) {
		return verticesMap.get(name);
	}
	
	public boolean hasVertex(String name) {
		return verticesMap.containsKey(name);
	}
	
	public Vertex addVertex(String name) {
		Vertex v;
		v = verticesMap.get(name);
		if (v == null) {
			v = new Vertex(name);
			verticesMap.put(name, v);
			adjListMap.put(name, new TreeSet<Edge>());
			nv += 1;
		}
		return v;
	}
	
	public void addEdge(String from, String to) {
		addEdge(from, to, 1);
	}
	
	public void addEdge(String from, String to, int distance) {
		if (!verticesMap.containsKey(from) || !verticesMap.containsKey(to)) {
			System.out.println("Did not add " + from + " to " + to);
			return;
		}
		
		Vertex x = verticesMap.get(from);
		Vertex y = verticesMap.get(to);
		Edge e = new Edge(distance, from, to);
		TreeSet<Edge> s = adjListMap.get(from);
		if (s.add(e)) {
			ne++;
		}
		if (directional == false) {
			Edge e1 = new Edge(distance, to, from);
			s = adjListMap.get(to);
			s.add(e1);
		}
	}
	
	public Iterable<Edge> adjacentTo(String name) {
		if (!hasVertex(name))
			return new TreeSet<Edge>();
		return adjListMap.get(name);
	}
	
	public int numOfEdges() { return ne;}
	
	public String toString() {
		StringBuilder bld =  new StringBuilder();
		// print out graph again by iterating over vertices and edges
		for (Vertex v : this.verticesMap.values()) {
			bld.append(v.getName() + ": \n");
			for (Edge w : this.adjacentTo(v.name)) {
				bld.append(w.getDestination() + " ");
			}
			bld.append("\n");
		}
		return bld.toString();
	}
	
	public static void main(String[] args) {
		Graph G = new Graph();
		//Graph from https://www.youtube.com/watch?v=zLZhSSXAwxI
		G.addVertex("H");
		
		G.addVertex("A");
		G.addVertex("B");
		G.addVertex("C");
		G.addVertex("D");
		G.addVertex("E");
		G.addVertex("F");
		G.addVertex("G");
	
		G.addEdge("G", "A");
		G.addEdge("G", "E");
		G.addEdge("E", "G");
		G.addEdge("E", "B");
		G.addEdge("B", "E");
		G.addEdge("B", "F");
		G.addEdge("B", "A");
		G.addEdge("F", "B");
		G.addEdge("F", "D");
		G.addEdge("F", "C");
		G.addEdge("C", "H");
		G.addEdge("H", "C");
		G.addEdge("D", "F");
		G.addEdge("D", "A");
		
		G.addEdge("A", "B");
		G.addEdge("A", "D");
		G.addEdge("A", "G");
		
		// print out graph
		System.out.println("Num of edges:" + G.numOfEdges());
		System.out.println(G);
		System.out.println("=============================");
		DFS d = new DFS();
		d.dfs(G);
	}
}
