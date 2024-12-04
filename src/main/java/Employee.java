import java.io.IOException;

public class Employee {

    private KeywordBasedSearchSystem searchSystem;
    
    
    public Employee(KeywordBasedSearchSystem searchSystem) {
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
