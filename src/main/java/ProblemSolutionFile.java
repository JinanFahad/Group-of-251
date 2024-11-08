

import java.io.*;

import java.util.*;

public class ProblemSolutionFile {

    private String PathOfFile = "ProblemSolution.txt";

    public ProblemSolutionFile(String filePath) {
        this.PathOfFile = filePath;
    }

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
}