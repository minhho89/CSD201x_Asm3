package minhho.utils;

import minhho.bst.Node;
import minhho.bst.Tree;

import java.io.PrintStream;

/**
 * Print the BST in diagram
 * Source: https://www.baeldung.com/java-print-binary-tree-diagram
 */
public class TreePrinter{

    public static String traversePreOrder(Node root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getId());

        String pointerRight = "└──";
        String pointerLeft = (root.getRightChild() != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.getLeftChild(), root.getRightChild() != null);
        traverseNodes(sb, "", pointerRight, root.getRightChild(), false);

        return sb.toString();
    }

    public static void traverseNodes(StringBuilder sb, String padding, String pointer, Node node,
                                     boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getId());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.getRightChild() != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeftChild(), node.getRightChild() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getRightChild(), false);
        }
    }

}
