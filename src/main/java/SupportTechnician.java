
import java.io.IOException;
import java.util.List;

public class SupportTechnician {

    private ProblemSolutionFile problemSolutionFile;

    public SupportTechnician(ProblemSolutionFile problemSolutionFile) {
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

    public void updateProblem(ProblemAndSolution problem) {
        try {
            problemSolutionFile.updateProblem(problem);
            System.out.println("Problem updated successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while updating the problem.");
        }
    }

    public void deleteProblem(String problemDescription) {
        try {
            problemSolutionFile.deleteProblem(problemDescription);
            System.out.println("Problem deleted successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while deleting the problem: " + e.getMessage());
        }
    }
}
