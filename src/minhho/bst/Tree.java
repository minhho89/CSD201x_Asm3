package minhho.bst;

import minhho.models.Employee;

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

    public void levelOrderTraversal(Node<T> node, int level) {
        if (node == null) {
            return;
        }

        if (level == 0) {
            System.out.println(node.data);
        } else {
            levelOrderTraversal(node.leftChild, level - 1);
            levelOrderTraversal(node.rightChild, level - 1);
        }
    }

    // update the height of a give node
    private void updateHeight(Node<T> node) {
        node.height = calculateTreeHeight(node);
    }

    // calculate the height of a give node
    public int calculateTreeHeight(Node<T> node) {
        if (node == null) {
            return -1;
        } else {
            // height of left subtree
            int lsh = calculateTreeHeight(node.leftChild);
            // height of right subtree
            int rsh = calculateTreeHeight(node.rightChild);
            // height in each recursive call
            return Math.max(lsh, rsh) + 1;
        }
    }

    // balance factor to decide the left heavy or right heavy cases
    public int getBalance(Node<T> node) {
        if (node == null) return 0;
        return calculateTreeHeight(node.getLeftChild()) - calculateTreeHeight(node.getRightChild());
    }

    public void rightRotation(Node<T> node) {

        // This will become new root node
        Node<T> tempLeftChild = node.getLeftChild();
        Node<T> grandChild = tempLeftChild.getRightChild();

        // make rotation
        // root node becomes tempLeftChild
        tempLeftChild.setRightChild(node);
        node.setLeftChild(grandChild);

        // handle parents
        if (grandChild != null) {
            grandChild.setParentNode(node);
        }

        Node<T> tempParent = node.getParentNode();
        node.setParentNode(tempLeftChild);
        tempLeftChild.setParentNode(tempParent);

        // if the given node is left child of its parent
        if (tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getLeftChild() == node) {
            tempLeftChild.getParentNode().setLeftChild(tempLeftChild);
        }
        // if the given node is right child of its parent
        if (tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getRightChild() == node) {
            tempLeftChild.getParentNode().setRightChild(tempLeftChild);
        }
        // if given node has no parent
        if (node == root) root = tempLeftChild;

        // after rotations the height change
        updateHeight(node);
        updateHeight(tempLeftChild);
    }

    public void leftRotation(Node<T> node) {

        // This will become new root node
        Node<T> tempRightChild = node.getRightChild();
        Node<T> grandChild = tempRightChild.getLeftChild();

        // make rotation
        // root node becomes tempLeftChild
        tempRightChild.setLeftChild(node);
        node.setRightChild(grandChild);

        // handle parents
        if (grandChild != null) {
            grandChild.setParentNode(node);
        }

        Node<T> tempParent = node.getParentNode();
        node.setParentNode(tempRightChild);
        tempRightChild.setParentNode(tempParent);

        // if the given node is left child of its parent
        if (tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getLeftChild() == node) {
            tempRightChild.getParentNode().setLeftChild(tempRightChild);
        }
        // if the given node is right child of its parent
        if (tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getRightChild() == node) {
            tempRightChild.getParentNode().setRightChild(tempRightChild);
        }
        // if given node has no parent
        if (node == root) root = tempRightChild;

        // after rotations the height change
        updateHeight(node);
        updateHeight(tempRightChild);
    }
    
    
    public void bft() {
        int height = calculateTreeHeight(root);
        for (int i = 0; i < height; i++) {
            levelOrderTraversal(root, i);
        }
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
