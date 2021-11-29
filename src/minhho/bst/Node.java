package minhho.bst;

public class Node<T> {

    int id;
    T data;
    Node<T> leftChild;
    Node<T> rightChild;
    Node<T> parentNode;
    int height;

    public Node() {

    }

    public Node(T data, Node<T> parentNode) {
        this.data = data;
        this.parentNode = parentNode;
    }


    public void displayNode() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node<T> parentNode) {
        this.parentNode = parentNode;
    }
}
