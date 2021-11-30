package minhho;

import minhho.bst.Tree;
import minhho.controllers.MainController;
import minhho.models.Employee;
import minhho.utils.DataGenerator;
import minhho.utils.TreePrinter;

public class Main {

    public static void main(String[] args) {

//        MainController.run();
        DataGenerator.generateLeftHeavyTree3();
//        DataGenerator.generateRightHeavyTree();

        Tree<Employee> myTree = DataGenerator.myTree;
        myTree.preOrder(myTree.getRoot());
        System.out.println(TreePrinter.traversePreOrder(myTree.getRoot()));


        System.out.println();

        myTree.setRoot(myTree.constructBalanceBST(myTree.getRoot()));

        myTree.preOrder(myTree.getRoot());
        System.out.println(TreePrinter.traversePreOrder(myTree.getRoot()));

    }
}
