import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        String filePath = "problems.txt";
        ProblemSolutionFile problemFile = new ProblemSolutionFile(filePath);
        KeywordBasedSearchSystem searchSystem = new KeywordBasedSearchSystem(problemFile);
        List<String> supportTeamMembers = new ArrayList<>();
        supportTeamMembers.add("Ahmad");
        supportTeamMembers.add("Bob");
        SupportTechnician supportTeam = new SupportTechnician(supportTeamMembers, problemFile);
        Employee employee = new Employee("Sarah Saad", "1829001", searchSystem);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Problem Management System");
        System.out.println("Please select your role:");
        System.out.println("1. Employee");
        System.out.println("2. Support Technician");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice == 1) {
            System.out.println("\n--- Employee Searching for a Solution ---");
            System.out.print("Enter the problem description: ");
            String problemDescription = scanner.nextLine();
            employee.requestSolution(problemDescription);
        } else if (choice == 2) {
            boolean continueRunning = true;
            while (continueRunning) {
                System.out.println("\n--- Support Technician Menu ---");
                System.out.println("1. Add a Problem");
                System.out.println("2. Update a Problem");
                System.out.println("3. Delete a Problem");
                System.out.println("4. Exit");
                int technicianChoice = scanner.nextInt();
                scanner.nextLine(); 

                //switch implementation left
                
            }
        } else {
            System.out.println("Invalid input selected.");
        }

        scanner.close();
    }
}
