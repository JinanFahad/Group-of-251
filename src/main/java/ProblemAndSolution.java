
import java.util.List;

public class ProblemAndSolution {

    private String problemDescription;
    private List<String> keywords;
    private String solution;

    public ProblemAndSolution(String problemDescription, List<String> keywords, String solution) {
        this.problemDescription = problemDescription;
        this.keywords = keywords;
        this.solution = solution;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public String getSolution() {
        return solution;
    }
}


