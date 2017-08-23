package com.metacube.trees;

public class MirrorSimilar {
	
	public static boolean areMirrorSimilarTrees(Node left, Node right){
		if(left == null && right == null){
			return true;
		}
		else if(left == null || right == null){
			return false;
		}
		return left.getData() == right.getData() 
				&& areMirrorSimilarTrees(left.getLeft(), right.getRight())
				&& areMirrorSimilarTrees(left.getRight(), right.getLeft());
			
	}
	public static void main(String[] args) {
		Node tree1 = new Node(1);
		Node tree2 = new Node(1);
		
		tree1.setLeft(new Node(2));
		tree1.setRight(new Node(3));
		tree1.getLeft().setLeft(new Node(4));
		
		tree2.setLeft(new Node(3));
		tree2.setRight(new Node(2));
		tree2.getRight().setRight(new Node(4));
		
		if(MirrorSimilar.areMirrorSimilarTrees(tree1, tree2)){
			System.out.println("Trees are mirror similar");
		}
		else{
			System.out.println("Not mirror similar");
		}
	}
}
