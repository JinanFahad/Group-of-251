import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
       
        String filePath = "problems.txt";
        
        ProblemSolutionFile problemFile = new ProblemSolutionFile(filePath);
        KeywordBasedSearchSystem searchSystem = new KeywordBasedSearchSystem(problemFile);
        List<String> supportTeamMembers = new ArrayList<>();
        supportTeamMembers.add("Ahmad");
        supportTeamMembers.add("Bob");
        SupportTechnician supportTeam = new SupportTechnician(supportTeamMembers, problemFile);


        List<String> keywords = new ArrayList<>();
        keywords.add("network");
        keywords.add("connectivity");
        ProblemAndSolution newProblem = new ProblemAndSolution("Network connection issue", keywords, "Check the network cable and router settings.");
        supportTeam.addProblem(newProblem);

        
        Employee employee = new Employee("Sarah Saad", "1829001", searchSystem);
        System.out.println("\n--- Employee Searching for a Solution ---");
        employee.requestSolution("network connectivity issue");


        ProblemAndSolution updatedProblem = new ProblemAndSolution("Network connection issue", keywords, "Restart the router and check the network cable.");
        supportTeam.updateProblem(updatedProblem);


        System.out.println("\n--- Employee Searching for Updated Solution ---");
        employee.requestSolution("network connection issue");
        System.out.println("\n--- Deleting a Problem (not implemented) ---");
        supportTeam.deleteProblem("Network connection issue");

    }
    
}
