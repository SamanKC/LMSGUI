/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package librarymanagementsystem.handler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import librarymanagementsystem.model.Book;
import librarymanagementsystem.model.Library;

/**
 *
 * @author saman
 */
public class AddHandler extends javax.swing.JFrame {
      private Library library;  // Reference to the library object

    /**
     * Creates new form AddHandler
     */
    public AddHandler(Library library) {
        this.library = library;  // Initialize the library
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addButton = new javax.swing.JButton();
        authorField = new javax.swing.JTextField();
        titleField = new javax.swing.JTextField();
        isbnField = new javax.swing.JTextField();
        yearField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        author = new javax.swing.JLabel();
        isbn = new javax.swing.JLabel();
        genre = new javax.swing.JLabel();
        year = new javax.swing.JLabel();
        genreField = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Book");

        addButton.setBackground(new java.awt.Color(153, 0, 153));
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add/Update Book");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\saman\\Downloads\\icons8-add-32.png")); // NOI18N
        jLabel1.setText("Add Books");

        title.setText("Title:");

        author.setText("Author:");

        isbn.setText("ISBN:");

        genre.setText("Genre:");

        year.setText("Year:");

        genreField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fiction", "Romance", "Fantasy", "Novel" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(147, 147, 147))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(isbnField, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(genreField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(isbn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(148, 148, 148)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(genre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(authorField, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title)
                    .addComponent(author))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authorField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genre)
                    .addComponent(isbn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(isbnField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(genreField)
                        .addGap(4, 4, 4)))
                .addComponent(year)
                .addGap(4, 4, 4)
                .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
       String title = titleField.getText().trim();
String author = authorField.getText().trim();
String isbnString = isbnField.getText().trim();
String genre = genreField.getSelectedItem() != null ? genreField.getSelectedItem().toString() : "";
int year;

// Validate input
if (title.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Title field is required!", "Input Error", JOptionPane.WARNING_MESSAGE);
    titleField.requestFocus(); // Set focus to the title field
    return;
}

if (author.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Author field is required!", "Input Error", JOptionPane.WARNING_MESSAGE);
    authorField.requestFocus(); // Set focus to the author field
    return;
}

if (isbnString.isEmpty()) {
    JOptionPane.showMessageDialog(this, "ISBN field is required!", "Input Error", JOptionPane.WARNING_MESSAGE);
    isbnField.requestFocus(); // Set focus to the ISBN field
    return;
}

// Validate ISBN and parse it
Long isbn;
try {
    isbn = Long.valueOf(isbnString); // Try to parse the ISBN
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Invalid ISBN format! Please enter a valid ISBN.", "ISBN Error", JOptionPane.ERROR_MESSAGE);
    isbnField.requestFocus(); // Set focus to the ISBN field
    return;
}

if (genre.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Genre must be selected!", "Input Error", JOptionPane.WARNING_MESSAGE);
    genreField.requestFocus(); // Set focus to the genre combo box
    return;
}

try {
    year = Integer.parseInt(yearField.getText().trim());
    if (year <= 0) {
        JOptionPane.showMessageDialog(this, "Year must be a positive number!", "Year Error", JOptionPane.ERROR_MESSAGE);
        yearField.requestFocus(); // Set focus to the year field
        return;
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Please enter a valid year!", "Year Error", JOptionPane.ERROR_MESSAGE);
    yearField.requestFocus(); // Set focus to the year field
    return;
}

// Validate ISBN
if (!isValidIsbn(isbn)) {
    JOptionPane.showMessageDialog(this, "Invalid ISBN format! Please enter a valid ISBN.", "ISBN Error", JOptionPane.ERROR_MESSAGE);
    isbnField.requestFocus(); // Set focus to the ISBN field
    return;
}

// Save book to output.txt
saveBookToFile(new Book(title, author, isbn, genre, year));


    }//GEN-LAST:event_addButtonActionPerformed

    private boolean isValidIsbn(Long isbn) {
    // Validate ISBN (you can expand this based on the requirements, e.g., length, characters, etc.)
    try {
        return isbn.toString().length() == 13; 
    } catch (NumberFormatException e) {
        return false;
    }
}



    private void saveBookToFile(Book book) {
        String projectDir = System.getProperty("user.dir");
        String outputFilePath = projectDir + "/output/output.txt";
        File outputFile = new File(outputFilePath);

        // Check if output.txt exists; create it if it doesn't
        if (!outputFile.exists()) {
            try {
                createOutputFile(outputFilePath);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error creating 'output.txt': " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Write the book details to output.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {  // 'true' to append
            writer.write("Title: " + book.getTitle());
            writer.newLine();
            writer.write("Author: " + book.getAuthor());
            writer.newLine();
            writer.write("ISBN: " + book.getIsbn());
            writer.newLine();
            writer.write("Genre: " + book.getGenre());
            writer.newLine();
            writer.write("Year: " + book.getYear());
            writer.newLine();
            writer.newLine();  // Separate entries

            JOptionPane.showMessageDialog(this, "Book added successfully to output.txt!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to 'output.txt': " + e.getMessage(), "Write Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createOutputFile(String outputFilePath) throws IOException {
        File file = new File(outputFilePath);
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            if (!file.getParentFile().mkdirs()) {
                throw new IOException("Failed to create output directory");
            }
        }
        if (!file.createNewFile()) {
            throw new IOException("Failed to create output file");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddHandler(new Library()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel author;
    private javax.swing.JTextField authorField;
    private javax.swing.JLabel genre;
    private javax.swing.JComboBox<String> genreField;
    private javax.swing.JLabel isbn;
    private javax.swing.JTextField isbnField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel title;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel year;
    private javax.swing.JTextField yearField;
    // End of variables declaration//GEN-END:variables
}
