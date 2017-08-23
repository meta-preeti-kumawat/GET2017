package com.metacube.trees;

public class BinaryTree {
    private Node root = null;
    private String inorderData = "";
    private String preorderData = "";
    private String postorderData = "";
    
    public Node getRoot() {
        return root;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public void addNode(int element){
        root = add(root, element);
    }

    private Node add(Node node, int element) {
        if(node == null){
            node = new Node(element);
        }
        else{
            if(node.getData() < element){
                node.setRight(add(node.getRight(), element));
            }
            else{
                node.setLeft(add(node.getLeft(), element));
            }
        }
        return node;
    }
    
    public String inOrder() {
        inOrder(root);
        return inorderData;
    }

    private void inOrder(Node node) {
        if(node != null){
            inOrder(node.getLeft());
            inorderData += Integer.toString(node.getData()) + " ";
            inOrder(node.getRight());
        }
    }
    public String preOrder() {
        preOrder(root);
        return preorderData;
    }

    private void preOrder(Node node) {
        if(node != null){
            preorderData  += Integer.toString(node.getData()) + " ";
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
    public String postOrder() {
        postOrder(root);
        return postorderData;
    }

    private void postOrder(Node node) {
        if(node != null){
            postOrder(node.getLeft());
            postOrder(node.getRight());
            postorderData  += Integer.toString(node.getData()) + " ";
        }
    }
}
