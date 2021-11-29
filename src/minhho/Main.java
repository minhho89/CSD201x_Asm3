package minhho;

import minhho.bst.Tree;
import minhho.controllers.MainController;
import minhho.models.Employee;
import minhho.utils.DataGenerator;

public class Main {

    public static void main(String[] args) {

//        MainController.run();
//        DataGenerator.generateRightHeavyTree();
        DataGenerator.generateLeftHeavyTree();

        Tree<Employee> myTree = DataGenerator.myTree;
        myTree.inOrder(myTree.getRoot());

        System.out.println(myTree.getBalance(myTree.getRoot()));
    }
}
