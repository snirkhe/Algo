package com.sher.ds.graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * http://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html
 * Graph from https://en.wikipedia.org/wiki/Dijkstra's_algorithm
 * Worst case : O(E + VLogV) if use MinHeap.
 *
 * The time complexicty depends on the implementrtation. It could be from O(E+V^2) to O(ELogV)
 * 1 to 5 is 20 , and right answer is 1,3,6,5
 * 
 */
public class Dijkstra {
	int INF = Integer.MAX_VALUE;
	HashMap<String, Integer> distance;
	HashMap<String, String> pre;
	Graph G;
	Set<Vertex> unsettled, settled;
	
	public Graph problem2() {
		G = new Graph();
		
		G.addVertex("1");
		G.addVertex("2");
		G.addVertex("3");
		G.addVertex("4");
		G.addVertex("5");
		G.addVertex("6");
		
		G.addEdge("1", "6", 14);
		G.addEdge("1", "2", 7);
		G.addEdge("1", "3", 9);
		G.addEdge("2", "3", 10);
		G.addEdge("3", "6", 2);
		G.addEdge("5", "6", 9);
		G.addEdge("4", "5", 6);
		G.addEdge("3", "4", 11);
		G.addEdge("2", "4", 15);
		
		// print out graph
		System.out.println("Num of edges:" + G.numOfEdges());
		//System.out.println(G);
		System.out.println("=============================");
		return G;
	}
	
	public static void main(String[] args) {
		Dijkstra d = new Dijkstra();
		d.problem2();
		d.dijkstra("1", "5");
	}
	
	private void dijkstra(String source, String destination) {
		settled = new HashSet<>();
		unsettled = new HashSet<>();
		distance = new HashMap<>(); //Distance from source to node
		pre = new HashMap<>();
		unsettled.add(G.getVertex(source));
		distance.put(source, 0);
	
		while (unsettled.isEmpty() == false) {
			Vertex m = getWithMinimumDistance(unsettled);
			unsettled.remove(m);
			settled.add(m);
			evaluateNeighbourAndSetDistance(m);
		}
		System.out.println("Distance from " + source + " to " + destination + " is " + distance.get(destination));
		System.out.print("Path is = ");
		getPath(destination);
		System.out.println("\n");
	}

	private void evaluateNeighbourAndSetDistance(Vertex m) {
		int mDistance = getDistance(m);
		for (Edge e:G.getAdjListMap().get(m.name)) {
			Vertex n = G.getVertex(e.destination);
			if (settled.contains(n)) continue;
			
			if (getDistance(n) > mDistance + e.getD()) {
				distance.put(n.name, getDistance(m) + e.getD());
				unsettled.add(n);
				//System.out.println("=>>>>" + n.name + ">>>" + m.name);
				pre.put(n.name, m.name); 
			}
		}
	}
	
	public LinkedList<String> getPath(String target) {
		LinkedList<String> path = new LinkedList<String>();
		String step = target;
		// check if a path exists
		if (pre.get(step) == null) {
			return null;
		}
		path.add(step);
		while (pre.get(step) != null) {
			step = pre.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		for (String s:path) {
			System.out.print(s + "=>");
		}
		return path;
	}

	private Vertex getWithMinimumDistance(Set<Vertex> unsettled) {
		Vertex minimum = null;
		for (Vertex v:unsettled) {
			if (minimum == null) minimum = v; 
			else {
				if (getDistance(minimum) > getDistance(v)) {
					minimum = v;
				}
			}
		}
		return minimum;
	}
		
	private int getDistance(Vertex  v) {
		Integer g = distance.get(v.name);
		if(g != null) {return g.intValue();}
		return INF;
	}
}
