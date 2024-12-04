
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ProblemSolutionFileTest {

    
    private ProblemSolutionFile problemSolutionFile;
    private static final String TEST_FILE_PATH = "testProblemSolution.txt";

    
    @BeforeEach
    void setUp() throws IOException {
        problemSolutionFile = new ProblemSolutionFile(TEST_FILE_PATH);
    }

    
    @AfterEach
    void tearDown() {
        File testFile = new File(TEST_FILE_PATH);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    
    /**
     * Test writing a problem to the file and then reading it back.
     * Ensures that the written problem matches what is read.
     */
    @Test
    void testWriteProblem() throws IOException {
        ProblemAndSolution problem = new ProblemAndSolution("Test Problem", List.of("keyword1", "keyword2"), "Test Solution");
        problemSolutionFile.writeProblem(problem);
        List<ProblemAndSolution> problems = problemSolutionFile.readProblems();
        assertEquals(1, problems.size());
        assertEquals("Test Problem", problems.get(0).getProblemDescription());
    }

    
    /**
     * Test reading multiple problems from the file.
     * Ensures that all written problems are read correctly.
     */
    @Test
    void testReadProblems() throws IOException {
        ProblemAndSolution problem1 = new ProblemAndSolution("Problem 1", List.of("keyword1"), "Solution 1");
        ProblemAndSolution problem2 = new ProblemAndSolution("Problem 2", List.of("keyword2"), "Solution 2");
        problemSolutionFile.writeProblem(problem1);
        problemSolutionFile.writeProblem(problem2);
        List<ProblemAndSolution> problems = problemSolutionFile.readProblems();
        assertEquals(2, problems.size());
    }

    
    /**
     * Test updating an existing problem in the file.
     * Ensures that the problem's solution is updated correctly.
     */
    @Test
    void testUpdateProblem() throws IOException {
        ProblemAndSolution problem = new ProblemAndSolution("Test Problem", List.of("keyword1"), "Old Solution");
        problemSolutionFile.writeProblem(problem);
        ProblemAndSolution updatedProblem = new ProblemAndSolution("Test Problem", List.of("keyword1"), "Updated Solution");
        problemSolutionFile.updateProblem(updatedProblem);
        List<ProblemAndSolution> problems = problemSolutionFile.readProblems();
        // Update test failed: Ensure that the problem's solution is correctly updated
        assertEquals("Updated Solution", problems.get(0).getSolution(), "The problem solution was not updated correctly");
    }

    
    /**
     * Test searching for a problem by keyword in the file.
     * Ensures that the correct problem is returned when searching by keyword.
     */
    @Test
    void testSearchInFile() throws IOException {
        ProblemAndSolution problem = new ProblemAndSolution("Searchable Problem", List.of("searchKeyword"), "Solution");
        problemSolutionFile.writeProblem(problem);
        List<ProblemAndSolution> results = problemSolutionFile.searchInFile("searchKeyword");
        assertEquals(1, results.size());
        assertEquals("Searchable Problem", results.get(0).getProblemDescription());
    }

    
    /**
     * Test deleting a problem from the file.
     * Ensures that the problem is removed and no longer exists in the file.
     */
    @Test
    void testDeleteProblem() throws IOException {
        ProblemAndSolution problem = new ProblemAndSolution("Delete Problem", List.of("keyword1"), "Solution");
        problemSolutionFile.writeProblem(problem);
        problemSolutionFile.deleteProblem("Delete Problem");
        List<ProblemAndSolution> problems = problemSolutionFile.readProblems();
        assertEquals(0, problems.size());
    }
    
    
    /**
     * Test deleting a non-existent problem from the file.
     * Ensures that no problems are deleted if the problem description does not exist.
     */
    @Test
    void testDeleteNonExistentProblem() throws IOException {
        ProblemAndSolution problem = new ProblemAndSolution("Existing Problem", List.of("keyword"), "Solution");
        problemSolutionFile.writeProblem(problem);
        problemSolutionFile.deleteProblem("Non-Existent Problem");
        List<ProblemAndSolution> problems = problemSolutionFile.readProblems();
        assertEquals(1, problems.size());
    }

    
    /**
     * Test searching for a keyword that does not exist.
     * Ensures that no problems are returned for a non-existent keyword.
     */
    @Test
    void testSearchForNonExistentKeyword() throws IOException {
        ProblemAndSolution problem = new ProblemAndSolution("Test Problem", List.of("keyword1"), "Solution");
        problemSolutionFile.writeProblem(problem);
        List<ProblemAndSolution> results = problemSolutionFile.searchInFile("nonExistentKeyword");
        assertEquals(0, results.size());
    }

    
    /**
     * Test writing and deleting all problems from the file.
     * Ensures that the file is empty after deleting all written problems.
     */
    @Test
    void testWriteAndDeleteAllProblems() throws IOException {
        ProblemAndSolution problem1 = new ProblemAndSolution("Problem 1", List.of("keyword1"), "Solution 1");
        ProblemAndSolution problem2 = new ProblemAndSolution("Problem 2", List.of("keyword2"), "Solution 2");
        problemSolutionFile.writeProblem(problem1);
        problemSolutionFile.writeProblem(problem2);
        problemSolutionFile.deleteProblem("Problem 1");
        problemSolutionFile.deleteProblem("Problem 2");
        List<ProblemAndSolution> problems = problemSolutionFile.readProblems();
        assertEquals(0, problems.size());
    }
    
    
}


