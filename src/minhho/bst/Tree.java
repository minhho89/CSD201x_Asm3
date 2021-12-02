package minhho.bst;

import minhho.models.Employee;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree<T> {
    private Node<T> root;

    public Tree() {

    }

    public Tree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public Node<T> find (int key) {

        Node<T> current = root;                 // assumes non-empty tree

        while(current.id != key) {
            if (key < current.getId())          // go left
                current = current.leftChild;
            else
                current = current.rightChild;   // go right
            if (current == null)
                return null;                    // not found
        }
        return current;                         // found
    }

    public boolean isDuplicate(int key) {

        if (root == null) {
            return false;
        }

        Node<T> foundNode = find(key);
        if (foundNode != null) return true;
        return false;
    }


    public void insert(int id, T data) {

        Node<T> newNode = new Node<>();                 // make new node
        newNode.id = id;
        newNode.data = data;                            // insert data

        if (root == null) {                             // in case of empty BST, then new node is root
            root = newNode;
        } else {
            Node<T> current = root;                     // start at root
            Node<T> parent;
            while (true) {
                parent = current;
                if (id < current.id) {                  // go left
                    current = current.leftChild;
                    if (current == null) {              // at the leaf
                        parent.leftChild = newNode;     // insert new node
                        return;
                    }
                } else {
                    current = current.rightChild;       // go right
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrder(Node<T> localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.println(localRoot.data);
            inOrder(localRoot.rightChild);

        }
    }

    public void postOrder(Node<T> localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.println(localRoot.data);

        }
    }

    public void preOrder(Node<T> localRoot) {
        if (localRoot != null) {
            System.out.println(localRoot.data);
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);

        }
    }

    public Node buildBalanceBST(List<Node> nodes, int start, int end) {

        // base case
        if (start > end) {
            return null;
        }

        int mid = (start + end) /2;

        Node root = nodes.get(mid);

        root.setLeftChild(buildBalanceBST(nodes, start, mid - 1));
        root.setRightChild(buildBalanceBST(nodes, mid + 1, end));

        return root;
    }

    public Node constructBalanceBST(Node root) {
        List<Node> nodes = new ArrayList<>();
        pushTreeNodes(root, nodes);

        return buildBalanceBST(nodes, 0, nodes.size() - 1);
    }

    private void pushTreeNodes(Node root, List<Node> nodes) {
        if (root == null) {
            return;
        }

        pushTreeNodes(root.getLeftChild(), nodes);
        nodes.add(root);
        pushTreeNodes(root.getRightChild(), nodes);
    }


    private void levelOrderTraversal(Node<T> root) {
        Queue<Node> q = new LinkedList<Node>();
        if (root == null) return;
        q.add(root);
        while(!q.isEmpty()) {
            Node n = (Node) q.remove();
            System.out.println(n.getData());
            if (n.getLeftChild() != null) q.add(n.getLeftChild());
            if (n.getRightChild() != null) q.add(n.getRightChild());
        }
    }

    public void bft() {
        levelOrderTraversal(root);
    }

    public boolean delete(int key) {
        Node<T> current = root;
        Node<T> parent = root;
        boolean isLeftChild = true;

        while(current.id != key) {  // search for node
            parent = current;
            if (key < current.id) {         // go left?
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;        // or go right?
                current = current.getRightChild();
            }

            if (current == null) {          // end of the line,
                return false;               // not found
            }

        }

        // found node
        // if no children, just delete
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) root = null;
            else if (isLeftChild) parent.leftChild = null;   // disconnect from parent
            else parent.rightChild = null;                   // disconnect from parent
        }

        // if no right child, replace with left subtree
        else if (current.rightChild == null) {
            if (current == root) root = current.leftChild;
            else if (isLeftChild) parent.leftChild = current.leftChild;
            else parent.rightChild = current.leftChild;
        }

        // if no left child, replace with right subtree
        else if (current.leftChild == null) {
            if (current == root) root = current.rightChild;
            else if (isLeftChild) parent.leftChild = current.rightChild;
            else parent.rightChild = current.rightChild;
        }

        // two children, replace with inorder successor
        else {
            // get successor of node to delete
            Node<T> successor = getSuccessor(current);

            // connect parent of current to successor instead
            if (current == root) root = successor;
            else if (isLeftChild) parent.leftChild = successor;
            else parent.rightChild = successor;

            // Connect successor to current's left child
            successor.leftChild = current.leftChild;
        }
        return true;
    }



    private Node<T> getSuccessor(Node<T> delNode) {
        Node<T> successorParent = delNode;
        Node<T> succcessor = delNode;
        Node<T> current = delNode.rightChild;   // go to right child

        while (current != null) {               // go to end
            successorParent = succcessor;       // left children
            succcessor = current;
            current = current.leftChild;        // go to left child
        }

        if (succcessor != delNode.rightChild) {     // if not successor,
            successorParent.leftChild = succcessor.rightChild;  // right child,
            succcessor.rightChild = delNode.rightChild;         // make connections
        }
        return succcessor;
    }
}
