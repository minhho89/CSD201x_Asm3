package minhho.controllers;

import minhho.bst.Tree;
import minhho.models.Employee;

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.System.exit;
import static minhho.ui.MainMenuUI.printMenu;
import static minhho.utils.ValidityChecker.isDateValid;
import static minhho.utils.ValidityChecker.isNumeric;

public class MainController {
    static Tree<Employee> employeeTree = new Tree<>();

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

        System.out.print("Please select your option (0-9): ");
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
                        System.out.println("Select 3");
                        return;
                    case 4:
                        System.out.println("Select 4");
                        return;
                    case 5:
                        System.out.println("Select 5");
                        return;
                    case 6:
                        System.out.println("Select 6");
                        return;
                    case 7:
                        System.out.println("Select 7");
                        return;
                    case 8:
                        System.out.println("Select 8");
                        return;
                    case 9:
                        System.out.println("Select 9");
                        return;
                    case 0:
                        System.out.println("Select 0");
                        exit(0);
                }
            } else {
                System.out.print("Invalid input. Please try again (0 - 9): ");
                input = sc.nextLine();
            }
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
                input.equals("8") || input.equals("9")))
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
