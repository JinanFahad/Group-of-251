import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class KeywordBasedSearchSystem {
    private ProblemSolutionFile problemSolutionFile;

    public KeywordBasedSearchSystem(ProblemSolutionFile problemSolutionFile) {
        this.problemSolutionFile = problemSolutionFile;
    }
    
    public String searchProblem(String description) throws IOException {
        List<String> keywords = extractKeywords(description);
        for (String keyword : keywords) {
            List<ProblemAndSolution> matchingProblems = problemSolutionFile.searchInFile(keyword);
            if (!matchingProblems.isEmpty()) {
                return matchingProblems.get(0).getSolution();
            }
        }
        return "No matching solution found.Please contact the support team on the unified number (9933).";
    }
    
    private List<String> extractKeywords(String description) {
       
        String[] keywords;
        keywords = description.toLowerCase().split("\\s+");
        return Arrays.asList(keywords); 
    }


   
}
