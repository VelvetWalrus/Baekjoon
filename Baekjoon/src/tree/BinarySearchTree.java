package tree;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

//subTrees also have recursive features, so this class is designed using recursive call.
public class BinarySearchTree<T extends Comparable<T>> implements ITree<T>{

	private Node root;
	private int size;
	
	public BinarySearchTree() {
		this.root = null;
		this.size = 0;
	}
	
	public T min() {
		return this.minNode(this.root);
	}
	
	private T minNode(Node node) {
		T minData = node.data;
		while(node.left != null) {
			minData = node.left.data;
			node = node.left;
		}
		return minData;
	}
	
	
	public T max() {
		return this.maxNode(this.root);
	}
	
	private T maxNode(Node node) {
		T maxData = node.data;
		while(node.right!=null) {
			maxData = node.right.data;
			node = node.right;
		}
		return maxData;
	}
	
	
	
	@Override
	public void insert(T val) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T val) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(T val) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<T> preOrder(){
		return this.preorderTree(root, new ArrayList<>());
	}
	
	private List<T> preorderTree(Node node, List<T> visited){
		if(node == null) return visited;
		
		visited.add(node.data);
		preorderTree(node.left, visited);
		preorderTree(node.right, visited);
		
		return visited;
	}

	public List<T> inOrder(){
		return inorderTree(root, new ArrayList<>());
	}
	
	private List<T> inorderTree(Node node, List<T> visited){
		if(node == null) return visited;

		inorderTree(node.left, visited);
		visited.add(node.data);
		inorderTree(node.right, visited);
		
		return visited;
		
	}
	public List<T> postOrder(){
		return this.postorderTree(root, new ArrayList<>());
	}
	
	private List<T> postorderTree(Node node, List<T> visited){
		if (node == null) return visited;
		
		postorderTree(node.left, visited);
		postorderTree(node.right, visited);
		visited.add(node.data);

		return visited;
	}
	
	
	private class Node {
		T data;
		Node left;
		Node right;
		
		Node(T data) {this.data=data;}
		
		Node(T data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
	}
}
