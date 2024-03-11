package Weekly_Assignment_Online_Voating_System;

import javax.security.auth.login.LoginException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        // Creating instances of the management classes
        Admin_Manager adminManage = new Admin_Manager();
        User_Manager userManager = new User_Manager();
        Candidate_Manage candidateManage = new Candidate_Manage();
        // File path for the result
        String resultFilePath = "result.csv";
        Scanner sc = new Scanner(System.in);
        int role;

        // Main loop to select the role
        while (true) {
            System.out.println("Enter your role:");
            System.out.println("0. Exit");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Candidate");
            role = sc.nextInt();

            // Switch case to select the role
            switch (role) {
                case 0:
                    System.out.println("Exiting...");
                    return;
                case 1:
                    // Admin role
                    adminRole(adminManage, sc);
                    break;
                case 2:
                    // User role
                    userRole(userManager, sc);
                    break;
                case 3:
                    // Candidate role
                    candidateRole(candidateManage, sc);
                    break;
                default:
                    System.out.println("Invalid role. Please try again.");
                    break;
            }
        }
    }

    // Method to handle Admin role operations
    private static void adminRole(Admin_Manager adminManager, Scanner sc) throws Exception {
        System.out.println("Admin Role:");
        System.out.println("1. Log in");
        System.out.println("2. Display admin");
        System.out.println("3. Add users");
        System.out.println("4. Display users");
        System.out.println("5. Add candidate");
        System.out.println("6. Display candidate info");
        System.out.println("7. Add voting candidate");
        System.out.println("8. Delete voting candidate");
        System.out.println("9. vote for candidate");
        System.out.println("10. calculate result");
        System.out.println("11. Exit admin role");

        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                adminManager.LogIn("admin.csv");
                break;
            case 2:
                adminManager.displayAdmin();
                break;
            case 3:
                adminManager.addUsers("users.csv");
                break;
            case 4:
                adminManager.displayUser();
                break;
            case 5:
                adminManager.addCandidate("candidate.csv");
                break;
            case 6:
                adminManager.display_Candidate_Info();
                break;
            case 7:
                adminManager.add_voting_Candidate("voting_candidates.csv");
                break;
            case 8:
                adminManager.delete_voting_Candidate();
                break;
            case 9:
                adminManager.voteForCandidate();
                adminManager.calculate_winner();
                break;
            case 10:
                adminManager.calculate_winner();
                break;
            case 11:
                System.out.println("Exiting Admin Role...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    // Method to handle User role operations
    private static void userRole(User_Manager userManager, Scanner sc) throws LoginException, IOException {
        System.out.println("User Role:");
        System.out.println("1. Log in");
        System.out.println("2. View profile");
        System.out.println("3. Change password");
        System.out.println("4. Exit user role");

        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                userManager.Login();
                break;
            case 2:
                System.out.println("enter the user id you want to view ");
                String userViewProfile = sc.nextLine();
                userManager.View_Profile(userViewProfile);
                break;
            case 3:
                System.out.println("enter the user id to change password  ");
                String userChangePassword = sc.nextLine();
                userManager.changePassword(userChangePassword);
                break;
            case 4:
                System.out.println("Exiting User Role...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    // Method to handle Candidate role operations
    private static void candidateRole(Candidate_Manage candidateManage, Scanner sc) throws LoginException, FileNotFoundException {
        System.out.println("Candidate Role:");
        System.out.println("1. Log in");
        System.out.println("2. View candidate");
        System.out.println("3. Edit candidate");
        System.out.println("4. Delete candidate");
        System.out.println("5. Exit candidate role");

        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                candidateManage.LoginCandidate();
                break;
            case 2:
                candidateManage.viewCandidate();
                break;
            case 3:
                System.out.println("enter candidate id you want to edit :");
                String editCandidateId = sc.nextLine();
                candidateManage.editCandidate(editCandidateId);
                break;
            case 4:
                System.out.println("enter candidate id you want to delete :");
                String deleteCandidateId = sc.nextLine();
                candidateManage.deleteCandidate(deleteCandidateId);
                break;
            case 5:
                System.out.println("Exiting Candidate Role...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
