package com.sher.graph;

public class Vertex {
	String name;

	public Vertex(String name) {this.name  = name;}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "[" + name + "]";
	}
		
}
