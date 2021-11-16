package Utils;

import Models.OpenPosition;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileWriter {

    public static void addJobsToTextFile(List<OpenPosition> jobs) {
        try (java.io.FileWriter fw = new java.io.FileWriter("src/test/resources/jobs.txt", false); //Writes the Job title and location for each job opening in the jobs.txt file.
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            jobs.forEach(job -> out.println(job.getTitle() + ", " + job.getLocation()));

        } catch (IOException e) {
            Logger.error(e.getMessage());
        }
    }

    private FileWriter() {
        throw new IllegalStateException("Utility class");
    }
}
