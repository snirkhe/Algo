package com.shekhar.ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTree {

	Node root;

	public BTree(Node root) {
		this.root = root;

	}


	static class Node {
		public int v;
		public Node left, right;
		Node (int v) {
			this.v = v;
		}

		public void addLeft(Node l) {
			this.left = l;
		}

		public void addRight(Node r) {
			this.right =  r;
		}

		public Node add(int v) {
			Node n = new Node(v);
			return add(n);
		}

		public Node add(Node c) {
			if (c == null) return this;
			if (v >= c.v) {
				if (left == null) {
					left = c;
				} else {
					left.add(c);
				}
			} else {
				if (right == null) {
					right = c;
				} else {
					right.add(c);
				}
			}
			return this;
		}
	}

	void preOrder(Node r) {
		if(r == null) return;
		System.out.print(r.v + ",");
		preOrder(r.left); preOrder(r.right);
	}

	void inOrder(Node r) {
		if(r == null) return;
		inOrder(r.left);
		System.out.print(r.v + ",");
		inOrder(r.right);
	}

	public static void main(String arg[]) {
		Node root = new Node(50);
		BTree tree=  new BTree(root);
		root.add(17).add(76).add(9).add(23).add(54).add(14).add(19).add(72).add(12).add(67);
		tree.preOrder(root);
		System.out.println("");
		tree.DFS(root);
		System.out.println("");
		System.out.println(tree.depth(root));
		System.out.println(tree.depthNoR(root));
	}

	//BBQ : Use queue for Breadth first search
	void BFS(Node root) {
		Queue<Node> qe=new LinkedList<Node>();
		qe.add(root);
		while (!qe.isEmpty()) {
			Node q = (Node) qe.poll();
			if (q != null) {
				System.out.print(q.v + ",");
				qe.add(q.left);
				qe.add(q.right);
			}
		}
	}

	//Depth first search using PreOrder. Use a stack for the implementation.
	void DFS(Node root) {
		Stack<Node> s = new Stack<>();
		s.add(root);

		while(!s.isEmpty()) {
			Node n = s.pop();
			if (n != null) {
				System.out.print(n.v + ",");
				s.push(n.right);
				s.push(n.left);
			}
		}
	}

	int depth(Node root) {
		if (root == null) return 0;
		return Math.max(depth(root.left), depth(root.right)) + 1 ;
	}
	
    //No recursion - Use BFS using queue to calculate the depth.
    //After each level insert a blank node to mark end of the level. 
	//The depth will be number of maker nodes.
	int depthNoR(Node root) {
		Node dummy = new Node(-100);
		
		Queue<Node> s = new LinkedList<>();
		
		s.add(root);
		s.add(dummy);
		
		int depth = 0;
		boolean blank = true; // Only insert blank node if the current level is not blank.
		
		while (!s.isEmpty()) {
			Node k = s.poll();
		
			if (k != null) {
				if (k.v == -100) {
					depth++;
					if (!blank) {
						s.add(dummy);
						blank = true;
					 }
				} else {
					if (k.left != null) {
						s.add(k.left);
						blank = false;
					}
					if (k.right != null) {
						s.add(k.right);
						blank = false;
					}
				}
				
			}
		}
		return depth;
	}
	
}
