package librarymanagementsystem.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import librarymanagementsystem.controller.FileUtils;
import librarymanagementsystem.model.Book;
import librarymanagementsystem.model.Library;

public abstract class FileManager {
    protected String bookFile;  // Path for the books file
    protected String outputFile; // Path for the output file
    protected String reportFile; // Path for the report file
    FileUtils util; // Instance of FileUtils for file handling

    public FileManager(String bookFile) {
        String projectDir = System.getProperty("user.dir");
        this.bookFile = "books.txt";
        this.reportFile = projectDir + "/librarymanagementsystem/output/report.txt";
        this.outputFile = projectDir + "/librarymanagementsystem/output/output.txt";
        this.util = new FileUtils(bookFile); // Initialize util with the correct path

        // Debugging statement to check file paths
        System.out.println("FileManager Book file path: " + this.bookFile);

        // Ensure output file exists on initialization
        try {
            util.ensureFileAndDirectoryExists(outputFile, "output");
            util.ensureFileAndDirectoryExists(reportFile, "report");
        } catch (IOException e) {
            showMessage("Error ensuring output/report file exists: " + e.getMessage());
        }
    }

    private void showMessage(String message) {
        // Print to console
        System.out.println(message);

        // Show message in GUI dialog
        JOptionPane.showMessageDialog(null, message, "Notification", JOptionPane.INFORMATION_MESSAGE);
    }

    public void logMessage(String message) {
        // Log the message
        showMessage(message);
        writeToFile(outputFile, message);
    }

    private void writeToFile(String filePath, String message) {
        // Writes a message to the specified file
        File file = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) { // Append to the output file
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            showMessage("Error writing to file: " + e.getMessage());
        }
    }

    public abstract void loadInitialData(Library library);

    public void saveLibraryData(List<Book> books) {
        // Save the library data to output.txt
        for (Book book : books) {
            StringBuilder bookDetails = new StringBuilder()
                    .append("Title: ").append(book.getTitle()).append("\n")
                    .append("Author: ").append(book.getAuthor()).append("\n")
                    .append("ISBN: ").append(book.getIsbn()).append("\n")
                    .append("Genre: ").append(book.getGenre()).append("\n")
                    .append("Year: ").append(book.getYear()).append("\n\n"); // Extra line for spacing
            
            writeToFile(outputFile, bookDetails.toString());
        }
        showMessage("Library data saved successfully to " + outputFile);
    }

    public void saveQueryResults(String instruction, List<Book> results) {
        StringBuilder reportContent = new StringBuilder();
        
        // Write a separator for clarity
        reportContent.append("---------------------------------\n")
                     .append("Query: ").append(instruction).append("\n")
                     .append("---------------------------------\n");

        // Write the results
        if (results.isEmpty()) {
            reportContent.append("No books found for this query.\n");
        } else {
            for (Book book : results) {
                reportContent.append(book.toString()).append("\n\n"); // Extra line for spacing
            }
        }
        reportContent.append("---------------------------------\n");

        writeToFile(reportFile, reportContent.toString());
        showMessage("Query results successfully appended to " + reportFile);
    }
}
