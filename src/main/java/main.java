import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class main {

    public static void main(String[] args) {

        String filePath = "problems.txt"; //file path of text file

        ProblemSolutionFile problemFile = new ProblemSolutionFile(filePath); //create file object 

        KeywordBasedSearch searchSystem = new KeywordBasedSearch(problemFile); //create search system object

        SupportTechnician technician = new SupportTechnician(problemFile); //create technician object

        Employee employee = new Employee(searchSystem); //create employee object
        Scanner scanner = new Scanner(System.in); //scanner object to obtain user input

        System.out.println("---------- WELCOME TO THE PROBLEM MANAGEMENT SYSTEM ----------");
        System.out.println("1. Employee");
        System.out.println("2. Support Technician");
        System.out.println("3. Exit");
        System.out.print("Please select your role:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        // choice no.1 leads to the employee menu
        if (choice == 1) {
            System.out.println("\n--- Employee Searching for a Solution ---");
            System.out.print("Enter the problem description: ");
            String problemDescription = scanner.nextLine();
            employee.requestSolution(problemDescription);
        } 
        //choice no.2 leads to the technician menu
        else if (choice == 2) {
            boolean continueRunning = true;
            while (continueRunning) {
                System.out.println("\n--- Support Technician Menu ---");
                System.out.println("1. Add a Problem");
                System.out.println("2. Update a Problem");
                System.out.println("3. Delete a Problem");
                System.out.println("4. Exit");
                System.out.print("Please select an option:");
                int technicianChoice = scanner.nextInt();
                scanner.nextLine();


switch (technicianChoice) {
                    case 1:
                        System.out.print("Enter problem description: ");
                        String newDescription = scanner.nextLine();
                        System.out.print("Enter keywords (comma-separated): ");
                        String keywordsInput = scanner.nextLine();
                        List<String> keywords = Arrays.asList(keywordsInput.split(","));
                        System.out.print("Enter solution: ");
                        String solution = scanner.nextLine();
                        ProblemAndSolution newProblem = new ProblemAndSolution(newDescription, keywords, solution);
                        technician.addProblem(newProblem);
                        break;
                    case 2:
                        System.out.print("Enter the problem description to update: ");
                        String updateDescription = scanner.nextLine();
                        System.out.print("Enter new keywords (comma-separated): ");
                        String updateKeywordsInput = scanner.nextLine();
                        List<String> updateKeywords = Arrays.asList(updateKeywordsInput.split(","));
                        System.out.print("Enter new solution: ");
                        String updateSolution = scanner.nextLine();
                        ProblemAndSolution updatedProblem = new ProblemAndSolution(updateDescription, updateKeywords, updateSolution);
                        technician.updateProblem(updatedProblem);
                        break;
                    case 3:
                        System.out.print("Enter the problem description to delete: ");
                        String deleteDescription = scanner.nextLine();
                        technician.deleteProblem(deleteDescription);
                        break;
                    case 4:
                        continueRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } 
        //user chooses to exit menu
        else if (choice == 3) {
            System.out.println("Exiting the system. Goodbye!");
            return;
        } 
        //user inputs a number other than (1,2,3)
        else {
            System.out.println("Invalid input selected.");
        }
        scanner.close();
    }
}
