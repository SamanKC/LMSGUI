package librarymanagementsystem.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import librarymanagementsystem.model.Book;
import librarymanagementsystem.model.Library;

public class DefaultFileManager extends FileManager {
    private static final String TITLE_PREFIX = "Title ";
    private static final String AUTHOR_PREFIX = "Author ";
    private static final String ISBN_PREFIX= "ISBN";
    private static final String GENRE_PREFIX = "Genre ";
    private static final String YEAR_PREFIX = "Year ";

    public DefaultFileManager(String bookFile) {
        super(bookFile);
    }

    @Override
    public void loadInitialData(Library library) {
        File file = new File(bookFile);

        try {
            // Ensure the file and directory exist before reading the data
            util.ensureFileAndDirectoryExists(bookFile, "books");
        } catch (IOException e) {
            showMessage("Error checking book file: " + e.getMessage());
            return; // Exit if we can't create or find the file
        }

        // Now load the initial data from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String title = null, author = null, genre = null;
            Long isbn=null;
            int year = 0;

            showMessage("Reading books...");

            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Remove unnecessary whitespace
                
                // If an empty line is encountered, we finalize and add the book
                if (line.isEmpty()) {
                    if (title != null) {
                        // Ensure title is not null before creating a book
                        Book book = new Book(title, author, isbn, genre, year);
                        library.addOrUpdateBook(book);
                        String bookDetails = "Loaded Book:\n" + book.toString() + "\n";
                        showMessage(bookDetails);
                        // Reset book details for the next entry
                        title = author  = genre = null;
                        isbn = null;
                        year = 0;
                    }
                    continue; // Skip processing of empty lines
                }

                // Process the line: split it into different book attributes
                String[] parts = line.split(";");
                for (String part : parts) {
                    part = part.trim(); // Ensure we have trimmed spaces
                    
                    if (part.startsWith(TITLE_PREFIX)) {
                        title = part.substring(TITLE_PREFIX.length()).trim();
                    } else if (part.startsWith(AUTHOR_PREFIX)) {
                        author = part.substring(AUTHOR_PREFIX.length()).trim();
                    } else if (part.startsWith(ISBN_PREFIX)) {
                        try {
                            isbn = Long.valueOf(part.substring(ISBN_PREFIX.length()).trim());
                        } catch (NumberFormatException e) {
                            showMessage("Error parsing isbn for title '" + isbn + "': " + e.getMessage());
                        }
                    } else if (part.startsWith(GENRE_PREFIX)) {
                        genre = part.substring(GENRE_PREFIX.length()).trim();
                    } else if (part.startsWith(YEAR_PREFIX)) {
                        try {
                            year = Integer.parseInt(part.substring(YEAR_PREFIX.length()).trim());
                        } catch (NumberFormatException e) {
                            showMessage("Error parsing year for title '" + title + "': " + e.getMessage());
                        }
                    }
                }
            }

            // After the loop: ensure the last book in the file is processed
            if (title != null) {
                Book book = new Book(title, author, isbn, genre, year);
                library.addOrUpdateBook(book);
                String lastBookDetails = "Loaded Book:\n" + book.toString() + "\n";
                showMessage(lastBookDetails);
            }

        } catch (IOException e) {
            showMessage("Error reading from book file: " + e.getMessage());
        }
    }

    // Helper method to show messages in both GUI and console
    private void showMessage(String message) {
        // Print to console
        System.out.println(message);
        // Show message in GUI dialog
        javax.swing.JOptionPane.showMessageDialog(null, message, "Notification", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
}
