package minhho.utils;

import minhho.bst.Tree;
import minhho.models.Employee;

import java.time.LocalDate;

public class DataGenerator {

    public static Tree<Employee> myTree = new Tree<>();

    public static void generateBST() {
        myTree.insert(10, new Employee(10, "Nguyen Van A",
                LocalDate.of(1999, 10, 10), "Can Tho"));
        myTree.insert(4, new Employee(4, "Tran Thi B",
                LocalDate.of(1989, 3, 20), "HCMC"));
        myTree.insert(20, new Employee(20, "Le Ngoc C",
                LocalDate.of(2000, 10, 10), "Da Lat"));
        myTree.insert(2, new Employee(2, "Nguyen My",
                LocalDate.of(1999, 04, 22), "Hanoi"));
    }

    public static void inOrder() {
        myTree.inOrder(myTree.getRoot());
    }

    public static void generateRightHeavyTree() {
        myTree.insert(5, new Employee(5));
        myTree.insert(10, new Employee(10));
        myTree.insert(15, new Employee(15));
    }

    public static void generateLeftHeavyTree() {
        myTree.insert(15, new Employee(15));
        myTree.insert(10, new Employee(10));
        myTree.insert(5, new Employee(5));
    }

}
