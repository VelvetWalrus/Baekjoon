package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BJ_9934 {

	public static void main(String[] args) {
		//input
		Scanner scanner = new Scanner(System.in);
		
		// node num of tree
		int K = (int) Math.pow(2, scanner.nextInt()) - 1;
		
		// nodes visited through inorder search
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < K; i ++) {
			l.add(scanner.nextInt());
		}
		
		Node root = BJ_9934.buildTree(l,  0,  l.size()-1);
		printTree(root);
		
	}
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) { this.data = data; }
	}

	static Node buildTree(List<Integer> inorder, int start, int end) {
		// make an end condition
		// ; cuz recursive method tends to be in an infinite loop if it doesn't exist
		if (start > end) {
			return null;
		}
		
		int i = (start + end) / 2 ; 
		Node node = new Node(inorder.get(i));	//root node
		
		if(start == end) {
			return node;
		}
		
		node.left = buildTree(inorder, start, i-1);
		node.right = buildTree(inorder, i+1, end);
		return null;
	}
	
	static void printTree(Node root) {
		StringBuilder result = new StringBuilder();
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			int n = queue.size();
			for(int i=0; i<n; i++) {
				Node node = queue.poll();
				result.append(node.data + " ");
				if (node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
			result.append("\n");
		}
		
		System.out.println(result.toString());
	}
	
}
