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
        List<ProblemAndSolution> allProblems = problemSolutionFile.readProblems();

        ProblemAndSolution bestMatch = null;
        int maxMatches = 0;

        // Iterate over all problems to find the best match based on keyword count
        for (ProblemAndSolution problem : allProblems) {
            int matchCount = 0;
            for (String keyword : keywords) {
                for (String problemKeyword : problem.getKeywords()) {
                    if (problemKeyword.toLowerCase().contains(keyword.toLowerCase())) {
                        matchCount++;
                    }
                }
            }
            // Update the best match if the current problem has more keyword matches
            if (matchCount > maxMatches) {
                bestMatch = problem;
                maxMatches = matchCount;
            }
        }

        if (bestMatch != null) {
            return bestMatch.getSolution();
        } else {
            return "No matching solution found. Please contact the support team on the unified number (9933).";
        }
    }

    private List<String> extractKeywords(String description) {
        String[] keywords = description.toLowerCase().split("\s+");
        return Arrays.asList(keywords);
    }
}