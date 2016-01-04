package com.sher.ds.graph;

public class Edge implements Comparable<Edge>{
	private int d;
	String soruce ,destination;
	
	public Edge(int d, String soruce, String destination) {
		super();
		this.d = d;
		this.soruce = soruce;
		this.destination = destination;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	public String getSoruce() {
		return soruce;
	}
	public void setSoruce(String soruce) {
		this.soruce = soruce;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public int compareTo(Edge other) {
		int diff = d - other.d;
		if (diff != 0)
			return diff;
		else
			return destination.compareTo(other.getDestination());
	}
}
