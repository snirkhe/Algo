package com.sher.graph;

import java.util.HashMap;
import java.util.Stack;

// O(E+V)
// DFS post order is used for topological sort
public class DFS {
	HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
	
	public void dfs(Graph G) {
		for(String n:G.getVerticesMap().keySet()) {
			visited.put(n, false);
		}
		dfs(G.getVertex("A"), G);	
	}
	private void dfs(Vertex v, Graph G) {
		Stack<Vertex> s = new Stack<>();
		s.push(v);
		while (!s.isEmpty()) { //O(V)
			Vertex n = s.pop();
			
			//As we are skipping visited, It is not O(E*V), but O(E+V)
			//in other words, we are visiting any edge and any vertex once only.
			if(visited.get(n.name) == true) continue; 
			System.out.print(n);
			visited.put(n.name, true); 
			for (Edge k: G.getAdjListMap().get(n.name)) {//O(E)
				s.push(G.getVertex(k.destination));
			}
		}
	}
	
	public static void main(String[] args) {
		problem2();
	}
	
	//Graph from https://www.youtube.com/watch?v=zLZhSSXAwxI
	public static void problem1() {
		Graph G = new Graph();
		
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
	
	//https://www.youtube.com/watch?v=iaBEKo5sM7w
	public static void problem2() {
		Graph G = new Graph();
		
		G.addVertex("A");
		G.addVertex("B");
		G.addVertex("C");
		G.addVertex("D");
		G.addVertex("E");
		G.addVertex("F");
		G.addVertex("G");
		G.addVertex("H");
		G.addVertex("S");
		
		G.addEdge("A", "B");
		G.addEdge("A", "S");
		G.addEdge("S", "G");
		G.addEdge("S", "C");
		G.addEdge("G", "F");
		G.addEdge("G", "H");
		G.addEdge("F", "C");
		G.addEdge("C", "D");
		G.addEdge("C", "E");
		G.addEdge("H", "E");
		
		// print out graph
		System.out.println("Num of edges:" + G.numOfEdges());
		System.out.println(G);
		System.out.println("=============================");
		DFS d = new DFS();
		d.dfs(G);
	}
}
