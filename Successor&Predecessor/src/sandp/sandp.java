package sandp;

public class sandp {
	public static void main(String args[]){
		BST b2=new BST();
		b2.insert(15);
		b2.insert(6);
		b2.insert(18);
		b2.insert(3);
		b2.insert(2);
		b2.insert(4);
		b2.insert(7);
		b2.insert(18);
		b2.insert(17);
		b2.insert(16);
		b2.insert(20);
		//b2.minimum();
		b2.successor();
		b2.predecessor();
	}
}

class BST{
	private class Node{
		Node left;
		Node right;
		Node parent;
		int data;
		Node(int newdata){
			left=null;
			right=null;
			parent=null;
			data=newdata;
			}
		}
	private Node root;
	public void BinaryTree(){
		root=null;
	}
	/*
	 * Inorder Successor
	 * 
	 * The inorder Successor of a tree is defined as:
	 * Given a node in a BST, the next highest key in the tree
	 * would be the inorder successor of that node.
	 * 
	 * In the tree t, if t has a right sub child, then 
	 * find the smallest element in the right sub tree.
	 * 
	 * Else if we do not have a right sub tree, move up
	 * towards the ancestor till the ancestor node is found
	 * and that becomes the left child. 
	 */
	public void successor(){
		successor(root.left.left.left);
	}
	Node temp=root;
	Node p;
	public Node successor(Node node){
		if(node.right!=null){
			System.out.println("Successor of the tree is:");
			minimum(node.right);
		}
		else{
			p=node.parent;
			while(p!=null && p.right==node){
				node=p;
				p=p.parent;
			}
			System.out.println("Successor is :"+p.data);
		}
		return p;
	}
	public void minimum(){
		minimum(root);
	}
	public int minimum(Node node){
		while(node.left!=null){
			node=node.left;
		}
		System.out.println(node.data);
		return node.data;
	}
	/*
	 * *****************************************
	 * */
	
	/*
	 * *****************************************
	 * Predecessor of a node
	 * *****************************************
	 */
	public void predecessor(){
		predecessor(root.right.left.left);
	}
	Node t1=root;
	Node p1;
	public void predecessor(Node node){
		if(node.left!=null){
			System.out.println("Predecessor is:");
			maximum(node.left);
		}
		else{
			p1=node.parent;
			while(p1!=null && p1.left==node){
				node=p1;
				p1=p1.parent;
			}
			System.out.println("Predecessor is:"+p1.data);
		}
	}
	public void maximum(){
		maximum(root);
	}
	public int maximum(Node node){
		if(node.right!=null){
			node=node.right;
		}
		System.out.println(node.data);
		return node.data;
	}
	public void insert(int data){
		Node temp=root;
		Node newnode=new Node(data);
		newnode.left=null;
		newnode.right=null;
		newnode.parent=null;
		newnode.data=data;
		root=insert(root, newnode);
	}
	public Node insert(Node temp, Node newnode){
		int data;
		if(temp==null){
			temp=newnode;
		}
		else{
			if(temp.data<=newnode.data){
				insert(temp.right, newnode);
				if(temp.right==null){
					temp.right=newnode;
					newnode.parent=temp;
				}
			}
			else{
				insert(temp.left, newnode);
				if(temp.left==null){
					temp.left=newnode;
					newnode.parent=temp;
				}
			}
		}
		return temp;
	}
}