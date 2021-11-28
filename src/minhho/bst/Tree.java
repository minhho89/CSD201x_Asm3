package minhho.bst;

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

    public int calculateTreeHeight(Node<T> root) {
        if (root == null) {
            return 0;
        } else {
            // height of left subtree
            int lsh = calculateTreeHeight(root.leftChild);
            // height of right subtree
            int rsh = calculateTreeHeight(root.rightChild);
            // height in each recursive call
            return Math.max(lsh, rsh) + 1;
        }
    }

    public void bft() {
        int height = calculateTreeHeight(root);
        for (int i = 0; i < height; i++) {
            levelOrderTraversal(root, i);
        }
    }
}
