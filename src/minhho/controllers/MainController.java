package minhho.controllers;

import minhho.bst.Node;
import minhho.bst.Tree;
import minhho.graph.Graph;
import minhho.models.Employee;
import minhho.utils.GraphDataGenerator;
import minhho.utils.TreePrinter;

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.System.exit;
import static minhho.ui.MainMenuUI.printMenu;
import static minhho.utils.ValidityChecker.isDateValid;
import static minhho.utils.ValidityChecker.isNumeric;

public class MainController {
    static Tree<Employee> employeeTree = new Tree<>();

    static {
        employeeTree.insert(20, new Employee(20, "Nguyen Van A",
                LocalDate.of(1999, 10, 10), "Can Tho"));
        employeeTree.insert(15, new Employee(15, "Tran Thi B",
                LocalDate.of(1989, 3, 20), "HCMC"));
        employeeTree.insert(10, new Employee(10, "Le Ngoc C",
                LocalDate.of(2000, 10, 10), "Da Lat"));
        employeeTree.insert(5, new Employee(5, "Nguyen My",
                LocalDate.of(1999, 04, 22), "Hanoi"));
        employeeTree.insert(2, new Employee(2, "Nguyen My",
                LocalDate.of(1999, 04, 22), "Hanoi"));
        employeeTree.insert(8, new Employee(8, "Nguyen My",
                LocalDate.of(1999, 04, 22), "Hanoi"));
    }

    public static void run() {
        boolean isContinued = true;
        printMenu();
        while (isContinued) {
            performSelect();
            isContinued = isContinued();
        }
    }

    /**
     * Stops program to exit by confirming with user if they want to continue using it or not?
     * @return true if continued, false if not
     */
    public static boolean isContinued() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Do you want to continue using this program? (Y/N): ");
        String input = sc.nextLine();
        while (true) {
            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.print("Invalid input. Please try again (Y/N): ");
                input = sc.nextLine();
            }
        }

    }

    /**
     * Maps user's input with program's feature
     */
    public static void performSelect() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Please select your option (0-11): ");
        String input = sc.nextLine();

        while (true) {
            if (isMainMenuSelectValid(input)) {
                int choice = Integer.valueOf(input);
                switch (choice) {
                    case 1:
                        insertToBST();
                        return;
                    case 2:
                        inorderTraversal();
                        return;
                    case 3:
                        bftTraversal();
                        return;
                    case 4:
                        searchById();
                        return;
                    case 5:
                        deleteById();
                        return;
                    case 6:
                        balanceTree();
                        return;
                    case 7:
                        dftCityGraph();
                        return;
                    case 8:
                        shortestPathFromAToF();
                        return;
                    case 9:
                        postOrderTraversal();
                        return;
                    case 10:
                        preOrderTraversal();
                        return;
                    case 11:
                        bftCityGraph();
                        return;
                    case 0:
                        System.out.println("Select 0");
                        exit(0);
                }
            } else {
                System.out.print("Invalid input. Please try again (0 - 11): ");
                input = sc.nextLine();
            }
        }
    }

    private static void bftCityGraph() {
        Graph cityGraph = GraphDataGenerator.generate();

        System.out.println("BFT for city graph...");

        cityGraph.bft(GraphDataGenerator.a);
    }

    private static void postOrderTraversal() {
        if (employeeTree.getRoot() == null) {
            System.out.println("BST is empty.");
        } else {
            employeeTree.postOrder(employeeTree.getRoot());
            System.out.println(TreePrinter.traversePreOrder(employeeTree.getRoot()));
        }
    }

    public static void preOrderTraversal() {
        if (employeeTree.getRoot() == null) {
            System.out.println("BST is empty.");
        } else {
            employeeTree.preOrder(employeeTree.getRoot());
            System.out.println(TreePrinter.traversePreOrder(employeeTree.getRoot()));
        }
    }

    private static void shortestPathFromAToF() {
        System.out.println("Computing shortest path from A to F using Dijkstra: ");
        GraphDataGenerator.printAtoF();

    }

    private static void dftCityGraph() {
        Graph cityGraph = GraphDataGenerator.generate();

        System.out.println("DFT for city graph...");

        cityGraph.dfs();
    }

    private static void balanceTree() {
        System.out.println("Before balancing");
        System.out.println(TreePrinter.traversePreOrder(employeeTree.getRoot()));

        System.out.println("");
        System.out.println("Balancing started...");
        employeeTree.setRoot(employeeTree.constructBalanceBST(employeeTree.getRoot()));

        System.out.println("After balancing");
        System.out.println(TreePrinter.traversePreOrder(employeeTree.getRoot()));
    }

    /**
     * Performs Delete node by ID
     */
    private static void deleteById() {

        Scanner sc = new Scanner(System.in);
        String idStr;
        int id;

        System.out.println("Inset id to delete: ");
        idStr = sc.nextLine();

        while(true) {
            if (isNumeric(idStr)) {
                id = Integer.valueOf(idStr);
                break;
            } else {
                System.out.print("Invalid input. Try again.");
                idStr = sc.nextLine();
            }
        }

        if (employeeTree.delete(id)) {
            System.out.println("Employee " + id + " has been deleted.");
        } else {
            System.out.println("Not found.");
        }

    }

    /**
     * Performs BFT traversal
     */
    private static void bftTraversal() {
        System.out.println("Performing broad-width first traversal...");
        employeeTree.bft();
        System.out.println(TreePrinter.traversePreOrder(employeeTree.getRoot()));

    }

    /**
     * Performs searchById using BST
     */
    private static void searchById() {
        Scanner sc = new Scanner(System.in);
        String idStr;
        int id;

        System.out.print("Insert id to search: ");
        idStr = sc.nextLine();

        while(true) {
            if (isNumeric(idStr)) {
                id = Integer.valueOf(idStr);
                break;
            } else {
                System.out.print("Invalid input. Try again.");
                idStr = sc.nextLine();
            }
        }

        Node<Employee> node = employeeTree.find(id);
        if (node == null) {
            System.out.println("Not found");
        } else {
            System.out.println(node.getData());
        }

    }

    /**
     * Performs in-order traversal for BST
     */
    private static void inorderTraversal() {
        if (employeeTree.getRoot() == null) {
            System.out.println("BST is empty.");
        } else {
            employeeTree.inOrder(employeeTree.getRoot());
            System.out.println(TreePrinter.traversePreOrder(employeeTree.getRoot()));
        }
    }

    /**
     * Check validity for integer value input from users
     * @param sc    Scanner
     * @param input input value
     * @param type  checking type (ID isNumeric, YEAR > 1900, 0< MONTH < 13, 0 < DAY < 32)
     * @return true if valid, false if invalid
     */
    private static int checkIntInputValidity(Scanner sc, String input, CheckType type) {
        int result;
        while (true) {
            if (isNumeric(input)) {
                result = Integer.valueOf(input);
                switch (type) {
                    case ID:
                        if (employeeTree.isDuplicate(result)) {
                            System.out.println("ID duplicated. Please try again");
                            System.out.print("Employee id: ");
                            input = sc.nextLine();
                            break;
                        }
                        return result;
                    case YEAR:
                        if (result < 1900) {
                            System.out.print("Invalid value. Year must be greater than 1900. Please try again: ");
                            input = sc.nextLine();
                            break;
                        }
                        return result;
                    case MONTH:
                        if (result < 1 || result > 12) {
                            System.out.print("Invalid value. Try again: ");
                            input = sc.nextLine();
                            break;
                        }
                        return result;
                    case DAY:
                        if (result < 1 || result > 31) {
                            System.out.println("Invalid value. Try again: ");
                            input = sc.nextLine();
                            break;
                        }
                        return result;
                }
            } else {
                System.out.print("Invalid input. Please try again: ");
                input = sc.nextLine();
            }
        }
    }

    /**
     * Perform insert new node to BST with validity checking features
     */
    private static void insertToBST() {

        Scanner sc = new Scanner(System.in);
        Employee e = new Employee();
        LocalDate dob;
        System.out.println("Please insert new Employee information: ");

        System.out.print("Employee id: ");
        String idStr = sc.nextLine();
        int id = checkIntInputValidity(sc, idStr, CheckType.ID);

        System.out.print("Employee name: ");
        String name = sc.nextLine();

        while (true) {
            System.out.println("Employee's Birthdate");
            System.out.print("Year: ");
            String yStr = sc.nextLine();
            int year = checkIntInputValidity(sc, yStr, CheckType.YEAR);

            System.out.print("Month: ");
            String mStr = sc.nextLine();
            int month = checkIntInputValidity(sc, mStr, CheckType.MONTH);

            System.out.print("Day: ");
            String dStr = sc.nextLine();
            int day = checkIntInputValidity(sc, dStr, CheckType.DAY);

            if (isDateValid(year, month, day)) {
                dob = LocalDate.of(year, month, day);
                break;
            } else {
                System.out.println("Invalid date input. Try again: ");
            }
        }

        System.out.print("Employee's Place of Birth: ");
        String pob = sc.nextLine();

        // Adding to Object
        e.setId(id);
        e.setName(name);
        e.setDob(dob);
        e.setPob(pob);

        employeeTree.insert(id, e);

        System.out.println("New employee has been inserted to the BST.");
    }

    /**
     * Checks validity of selection in MainMenu
     * @param input user's input
     * @return true if valid, false if invalid
     */
    private static boolean isMainMenuSelectValid(String input) {
        if (isNumeric(input) && (input.equals("0") ||
                input.equals("1") || input.equals("2") || input.equals("3") ||
                input.equals("4") || input.equals("5") || input.equals("6") || input.equals("7") ||
                input.equals("8") || input.equals("9") || input.equals("10") || input.equals("11")))
            return true;
        return false;
    }

    private enum CheckType {
        ID,
        YEAR,
        MONTH,
        DAY
    }

}
