import java.io.IOException;
import java.util.List;

public class SupportTechnician {
     private List<String> teamMembers;
    private ProblemSolutionFile problemSolutionFile;

    public SupportTechnician(List<String> teamMembers, ProblemSolutionFile problemSolutionFile) {
        this.teamMembers = teamMembers;
        this.problemSolutionFile = problemSolutionFile;
    }
 public void addProblem(ProblemAndSolution problem) {
        try {
            problemSolutionFile.writeProblem(problem);
            System.out.println("Problem added successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the problem.");
        }
    }

}
