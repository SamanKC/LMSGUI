package librarymanagementsystem.controller;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class FileUtils {
    private String bookFile;
    private String outputFile;
    private String reportFile;

    public FileUtils(String bookFile) {
        String projectDir = System.getProperty("user.dir");
        this.bookFile =   projectDir + "/librarymanagementsystem/output/books.txt";
        this.reportFile = projectDir + "/librarymanagementsystem/output/report.txt";
        this.outputFile = projectDir + "/librarymanagementsystem/output/output.txt";

        // Debugging statement to check constructed paths
        System.out.println("Book file path: " + this.bookFile);
        System.out.println("Output file path: " + this.outputFile);
        System.out.println("Report file path: " + this.reportFile);
    }

    public void ensureFileAndDirectoryExists(String filePath, String fileName) throws IOException {
        File file = new File(filePath);
        File parentDir = file.getParentFile();

        // Ensure parent directory exists
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs(); // Create the parent directories if they do not exist
        }

        // Check if file exists
        if (!file.exists()) {
            showMessage(fileName + " not found.");
        } else {
            showMessage(fileName + " found successfully.");
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Notification", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Getters for file paths
    public String getBookFile() {
        return bookFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public String getReportFile() {
        return reportFile;
    }
}
