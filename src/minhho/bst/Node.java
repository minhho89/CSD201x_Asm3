package minhho.bst;

public class Node<T> {

    int id;
    T data;
    Node<T> leftChild;
    Node<T> rightChild;


    public Node() {

    }

    public int getId() {
        return id;
    }

    public T getData() {
        return data;
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

}
