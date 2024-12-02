import java.io.*;
import java.util.*;

public class ProblemSolutionFile {

    private String PathOfFile = "ProblemSolution.txt";

    public ProblemSolutionFile(String filePath) {
        this.PathOfFile = filePath;
    }
   //-------------------------------------------------------------------------------------------------------      
    public List<ProblemAndSolution> readProblems() throws IOException {
        List<ProblemAndSolution> problemList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(PathOfFile));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Problem:")) {
                String description = line.substring(8).trim();
                String keywordsLine = reader.readLine();
                String solutionLine = reader.readLine();
                if (keywordsLine != null && solutionLine != null && keywordsLine.startsWith("Keywords:") && solutionLine.startsWith("Solution:")) {
                    List<String> keywords = Arrays.asList(keywordsLine.substring(9).trim().split(","));
                    String solution = solutionLine.substring(9).trim();
                    problemList.add(new ProblemAndSolution(description, keywords, solution));
                }
            }
        }
        reader.close();
        return problemList;
    }
  //-------------------------------------------------------------------------------------------------------   
    public void writeProblem(ProblemAndSolution problem) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(PathOfFile, true));
        writer.write("Problem: " + problem.getProblemDescription());
        writer.newLine();
        writer.write("Keywords: " + String.join(",", problem.getKeywords()));
        writer.newLine();
        writer.write("Solution: " + problem.getSolution());
        writer.newLine();
        writer.newLine();
        writer.close();
    }
  //-------------------------------------------------------------------------------------------------------   
    public void updateProblem(ProblemAndSolution updatedProblem) throws IOException {
        List<ProblemAndSolution> problemList = readProblems();
        BufferedWriter writer = new BufferedWriter(new FileWriter(PathOfFile));
        for (ProblemAndSolution problem : problemList) {
            if (problem.getProblemDescription().equals(updatedProblem.getProblemDescription())) {
                writer.write("Problem: " + updatedProblem.getProblemDescription());
                writer.newLine();
                writer.write("Keywords: " + String.join(",", updatedProblem.getKeywords()));
                writer.newLine();
                writer.write("Solution: " + updatedProblem.getSolution());
            } else {
                writer.write("Problem: " + problem.getProblemDescription());
                writer.newLine();
                writer.write("Keywords: " + String.join(",", problem.getKeywords()));
                writer.newLine();
                writer.write("Solution: " + problem.getSolution());
            }
            writer.newLine();
            writer.newLine();
        }
        writer.close();
    }
//-------------------------------------------------------------------------------------------------------   
    public List<ProblemAndSolution> searchInFile(String keyword) throws IOException {
        List<ProblemAndSolution> problems = readProblems();
        List<ProblemAndSolution> matchingProblems = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (ProblemAndSolution problem : problems) {
            List<String> problemKeywords = problem.getKeywords();
            boolean isMatch = false;

// Iterate through the keywords of each problem and check for matches
            for (String problemKeyword : problemKeywords) {
                if (problemKeyword.equalsIgnoreCase(lowerKeyword)) {
                    isMatch = true;
                    break;  // Exit the loop once a match is found for the current problem
                }
            }

            // Add the problem only if there's a matching keyword
            if (isMatch) {
                matchingProblems.add(problem);
            }
        }
        return matchingProblems;
    }
    //-------------------------------------------------------------------------------------------------------   
    public void deleteProblem(String problemDescription) throws IOException {
        List<ProblemAndSolution> problemList = readProblems();
        BufferedWriter writer = new BufferedWriter(new FileWriter(PathOfFile));
        for (ProblemAndSolution problem : problemList) {
            // Write back all problems except the one with the matching description
            if (!problem.getProblemDescription().equalsIgnoreCase(problemDescription)) {
                writer.write("Problem: " + problem.getProblemDescription());
                writer.newLine();
                writer.write("Keywords: " + String.join(",", problem.getKeywords()));
                writer.newLine();
                writer.write("Solution: " + problem.getSolution());
                writer.newLine();
                writer.newLine();
            }
        }
        writer.close();
    }
}
