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
        myTree.insert(20, new Employee(20));
    }

    public static void generateLeftHeavyTree() {
        myTree.insert(12, new Employee(12));
        myTree.insert(8, new Employee(8));
        myTree.insert(18, new Employee(18));
        myTree.insert(17, new Employee(17));
        myTree.insert(5, new Employee(5));
        myTree.insert(11, new Employee(11));
        myTree.insert(4, new Employee(4));
    }

    public static void generateLeftHeavyTree2() {
        myTree.insert(42, new Employee(42));
        myTree.insert(35, new Employee(35));
        myTree.insert(31, new Employee(31));
        myTree.insert(19, new Employee(19));
        myTree.insert(14, new Employee(14));
        myTree.insert(27, new Employee(27));
        myTree.insert(10, new Employee(10));
    }

    public static void generateLeftHeavyTree3() {
        myTree.insert(20, new Employee(20));
        myTree.insert(15, new Employee(15));
        myTree.insert(10, new Employee(10));
        myTree.insert(5, new Employee(5));
        myTree.insert(2, new Employee(2));
        myTree.insert(8, new Employee(8));
    }
}
