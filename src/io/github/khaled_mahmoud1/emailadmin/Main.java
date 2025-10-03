package io.github.khaled_mahmoud1.emailadmin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first name");
        String firstName = in.nextLine();

        System.out.println("Enter last name");
        String lastName = in.nextLine();

        Department department = Department.NONE;
        while (true) {
            System.out.println("Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None");
            System.out.print("Enter department code: ");
            int depChoice = in.nextInt();

            if (depChoice == 1) {
                department = Department.SALES;
                break;
            } else if (depChoice == 2) {
                department = Department.DEVELOPMENT;
                break;
            } else if (depChoice == 3) {
                department = Department.ACCOUNTING;
                break;
            } else if (depChoice == 0) {
                break;
            } else {
                System.out.println("Invalid choice, please try again!\n");
            }
        }


        // Email obj
        Email email = new Email(firstName, lastName, department);

        // Menu
        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1 - Show Info");
            System.out.println("2 - Change Password");
            System.out.println("3 - Set Alternate Email");
            System.out.println("4 - Set Mailbox Capacity");
            System.out.println("0 - Exit");
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1 -> System.out.println(email.showInfo());
                case 2 -> {
                    System.out.print("Enter new password: ");
                    String newPass = in.nextLine();
                    email.changePassword(newPass);
                    System.out.println("Password updated.");
                }
                case 3 -> {
                    System.out.print("Enter alternate email: ");
                    String altEmail = in.nextLine();
                    email.setAlternateEmail(altEmail);
                    System.out.println("Alternate email set.");
                }
                case 4 -> {
                    System.out.print("Enter new mailbox capacity: ");
                    int capacity = in.nextInt();
                    email.setMailboxCapacity(capacity);
                    System.out.println("Mailbox capacity updated.");
                }
                case 0 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }

        in.close();
    }

}

