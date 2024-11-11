

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
            String[] parts = line.split("\\|", 3);
            if (parts.length == 3) {
                String description = parts[0];
                List<String> keywords = Arrays.asList(parts[1].split(","));
                String solution = parts[2];
                problemList.add(new ProblemAndSolution(description, keywords, solution));
            }
        }
        reader.close();
        return problemList;
    }
//-------------------------------------------------------------------------------------------------------   
    public void writeProblem(ProblemAndSolution problem) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(PathOfFile, true));
        writer.write(problem.getProblemDescription() + "|" + String.join(",", problem.getKeywords()) + "|" + problem.getSolution());
        writer.newLine();
        writer.close();
    }
//-------------------------------------------------------------------------------------------------------   
    public void updateProblem(ProblemAndSolution updatedProblem) throws IOException {
        List<ProblemAndSolution> problemList = readProblems();
        BufferedWriter writer = new BufferedWriter(new FileWriter(PathOfFile));
        for (ProblemAndSolution problem : problemList) {
            if (problem.getProblemDescription().equals(updatedProblem.getProblemDescription())) {
                writer.write(updatedProblem.getProblemDescription() + "|" + String.join(",", updatedProblem.getKeywords()) + "|" + updatedProblem.getSolution());
            } else {
                writer.write(problem.getProblemDescription() + "|" + String.join(",", problem.getKeywords()) + "|" + problem.getSolution());
            }
            writer.newLine();
        }
        writer.close();
    }
//-------------------------------------------------------------------------------------------------------   
public List<ProblemAndSolution> searchInFile(String keyword) throws IOException {
    List<ProblemAndSolution> problems = readProblems();
    List<ProblemAndSolution> matchingProblems = new ArrayList<>();
    for (ProblemAndSolution problem : problems) {
        if (problem.getKeywords().contains(keyword.toLowerCase())) {
            matchingProblems.add(problem);
        }
    }
    return matchingProblems;
 }    
}
  
