package librarymanagementsystem.utils;

import javax.swing.JOptionPane;

public class Utils {

    // Method to handle exceptions and show error messages in GUI
    public static void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Method to handle generic exceptions
    public static void handleException(Exception ex) {
        String errorMessage = "An error occurred: " + ex.getMessage();
        showErrorMessage(errorMessage);
        ex.printStackTrace(); // Optional: Print stack trace for debugging
    }

    // Method to handle specific file-related exceptions
    public static void handleFileNotFound(String fileName) {
        String errorMessage = "File not found: " + fileName;
        showErrorMessage(errorMessage);
    }

    // Method to handle input validation errors
    public static void handleInvalidInput(String input) {
        String errorMessage = "Invalid input: " + input;
        showErrorMessage(errorMessage);
    }

    // Method to handle successful operations
    public static void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
