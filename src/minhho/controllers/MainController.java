package minhho.controllers;

import java.util.Scanner;

import static java.lang.System.exit;
import static minhho.ui.MainMenuUI.printMenu;
import static minhho.utils.ValidityChecker.isNumeric;

public class MainController {

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
                        System.out.println("Select 1");
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

    private static boolean isSelectValid(String input) {
        if (isNumeric(input) && (input.equals("0") ||
                input.equals("1") || input.equals("2") || input.equals("3") ||
                input.equals("4") || input.equals("5") || input.equals("6") || input.equals("7") ||
                input.equals("8") || input.equals("9")))
            return true;
        return false;
    }

}
