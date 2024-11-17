
import java.io.IOException;


public class Employee {
    private String name;
    private String employeeId;
    private KeywordBasedSearchSystem searchSystem;

    public Employee(String name, String employeeId, KeywordBasedSearchSystem searchSystem) {
        this.name = name;
        this.employeeId = employeeId;
        this.searchSystem = searchSystem;
    }
    
   
    public void requestSolution(String problemDescription) {
        try {
            String solution = searchSystem.searchProblem(problemDescription);
            System.out.println("Solution: " + solution);
        } catch (IOException e) {
            System.out.println("An error occurred while searching for a solution.");
        }
    } 
    
    
    
    
}
