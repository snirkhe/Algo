package com.sher.ds.graph;

import java.util.PriorityQueue;

public class TreeVerticalPrint {

	static class NodePriority implements Comparable<NodePriority>{
		private final Node node;
		private final int x;
		private final int y;
		public NodePriority(Node n, int x,int y) {
			this.node = n;
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(NodePriority o) {
			if(this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}
		public Node getNode(){
			return node;
		}
	}

	static PriorityQueue<NodePriority> pq4Nodes = new PriorityQueue<>();

	public  static void processNodesByColumns(Node node, int x,int y) {
		if(node == null) return;
		pq4Nodes.add(new NodePriority(node, x,y));
		processNodesByColumns(node.left,x-1, y+1);
		processNodesByColumns(node.right,x+1, y+1);

	}
	class Node {
		public Node(Node left, Node right, int value) {
			this.left = left;
			this.right = right;
			this.value = value;
		}
		Node left; Node right; int value;
	}
	public static void main(String[] args) {
		new TreeVerticalPrint().test();
	}
	
	public void test() {
		
		Node n9  = new Node(null,null,9);
		Node n7  = new Node(null,null,7);
		Node n1  = new Node(null,null,1);
		Node n8  = new Node(null,null,8);

		Node n2  = new Node(null,n7,2);
		Node n5  = new Node(n9,n2,5);
		Node n3  = new Node(n5,n1,3);

		Node n0  = new Node(n8,null,0);
		Node n4  = new Node(null,n0,4);

		Node n6  = new Node(n3,n4,6);
		processNodesByColumns(n6, 0,0);
		while(!pq4Nodes.isEmpty()) {
			NodePriority head  = pq4Nodes.poll();
			System.out.print(head.getNode().value + ",");
		}
	}
}
