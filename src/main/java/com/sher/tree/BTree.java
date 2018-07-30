package com.sher.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTree {
	Node root;
	public BTree(Node root) {
		this.root = root;
	}



	void preOrder(Node r) {
		if(r == null) return;
		System.out.print(r.data + ",");
		preOrder(r.left); preOrder(r.right);
	}

	void inOrder(Node r) {
		//System.out.print("InOrder:");
		if(r == null) return;
		inOrder(r.left);
		System.out.print(r.data + ",");
		inOrder(r.right);
	}

	public static Node buildTree() {
		Node root = new Node(10);
		root.add(17).add(76).add(9).add(23).add(54).add(14).add(19).add(72).add(12).add(67);

		System.out.println("");
		System.out.println("");
		return root;
	}
	public static void main(String arg[]) {
		Node root = BTreePrinter.tree1();
		BTree tree=  new BTree(root);
		tree.BFS(root);
		System.out.println("");
		BTreePrinter.printNode(root);
		//System.out.println(tree.depth(root));
		//System.out.println("depthNoR:" + tree.depthNoR(root));
	}

	//BBQ : Use queue for Breadth first search
	void BFS(Node root) {
		Queue<Node> qe=new LinkedList<Node>();
		qe.add(root);
		while (!qe.isEmpty()) {
			Node q = (Node) qe.poll();
			if (q != null) {
				System.out.print(q.data + ",");
				qe.add(q.left);
				qe.add(q.right);
			}
		}
	}

	//Depth first search using PreOrder. Use a stack for the implementation.
	void DFS(Node root) {
		Stack<Node> s = new Stack<Node>();
		s.add(root);

		while(!s.isEmpty()) {
			Node n = s.pop();
			if (n != null) {
				System.out.print(n.data + ",");
				s.push(n.right);
				s.push(n.left);
			}
		}
	}
	//Delete note
	//Story : Best (BST) is to cut little right finger.  (e.g. for BST delete the smallest node from right)

	int depth(Node root) {
		if (root == null) return 0;
		return Math.max(depth(root.left), depth(root.right)) + 1 ;
	}

	//No recursion - Use BFS using queue to calculate the depth.
	//After each level insert a blank node to mark end of the level. 
	//The depth will be number of maker nodes.
	int depthNoR(Node root) {
		Node endOfLevelMarker = new Node(-100);

		Queue<Node> s = new LinkedList<Node>();
		
		s.add(root);
		s.add(endOfLevelMarker);

		int depth = 0;


		while (!s.isEmpty()) {
			Node k = s.poll();

			if (k != null) {
				if (k.data == -100) {
					depth++;
					if (!s.isEmpty()) { // It was the last node. Without this check we will keep putting and popping marker forever.
						s.add(endOfLevelMarker);
					}
				} else {
					if (k.left != null) {
						s.add(k.left);
					}
					if (k.right != null) {
						s.add(k.right);
					}
				}

			}
		}
		return depth;
	}
}
