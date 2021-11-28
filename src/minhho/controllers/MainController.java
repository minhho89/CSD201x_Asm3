package minhho.controllers;

import minhho.bst.Node;
import minhho.bst.Tree;
import minhho.models.Employee;

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.System.exit;
import static minhho.ui.MainMenuUI.printMenu;
import static minhho.utils.ValidityChecker.isNumeric;

public class MainController {

    static Tree<Employee> employeeTree = new Tree<>();

    public static void run() {
        boolean isContinue = true;
        printMenu();
        while(isContinue) {
            performSelect();
            isContinue = isContinue();
        }
    }

    public static boolean isContinue() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Do you want to continue using this program? (Y/N): ");
        String input = sc.nextLine();
        while(true) {
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

    public static void performSelect() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Please select your option (0-9): ");
        String input = sc.nextLine();

        while (true) {
            if (isSelectValid(input)) {
                int choice = Integer.valueOf(input);
                switch (choice) {
                    case 1:
                        insertToBST();
                        return;
                    case 2:
                        System.out.println("Select 2");
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

    //TODO: add validity
    private static void insertToBST() {

        Scanner sc = new Scanner(System.in);
        Employee e = new Employee();

        System.out.println("Please insert new Employee information: ");

        System.out.print("Employee id: ");
        String idStr = sc.nextLine();
        int id = Integer.valueOf(idStr);

        System.out.print("Employee name: ");
        String name = sc.nextLine();

        System.out.println("Employee's Birthdate");
        System.out.print("Year: ");
        String yStr = sc.nextLine();

        System.out.print("Month: ");
        String mStr = sc.nextLine();

        System.out.print("Day: ");
        String dStr = sc.nextLine();

        System.out.print("Employee's Place of Birth: ");
        String pob = sc.nextLine();

        LocalDate dob = LocalDate.of(Integer.valueOf(yStr), Integer.valueOf(mStr), Integer.valueOf(dStr));

        // Adding to Object
        e.setId(id);
        e.setName(name);
        e.setDob(dob);
        e.setPob(pob);

        employeeTree.insert(id, e);

        System.out.println("New employee has been inserted to the BST.");
    }

    private static boolean isSelectValid(String input) {
        if (isNumeric(input) && (input.equals("0") ||
                input.equals("1") || input.equals("2") || input.equals("3") ||
                input.equals("4") || input.equals("5") || input.equals("6") || input.equals("7") ||
                input.equals("8") || input.equals("9")))
            return true;
        return false;
    }

}
