import javax.swing.*;
import java.awt.*;

public class BorrowDeleteScreen {
    public BorrowDeleteScreen(Library library) {
        JFrame frame = new JFrame("Borrow/Delete Book");
        frame.setSize(400, 250);
        frame.setLayout(new GridLayout(5, 2));

        JTextField title = new JTextField();
        JButton borrow = new JButton("Borrow");
        JButton delete = new JButton("Delete");
        JButton exit = new JButton("Exit");
        JTextArea display = new JTextArea();

        borrow.setBackground(Color.CYAN);
        delete.setBackground(Color.CYAN);
        exit.setBackground(Color.CYAN);

        frame.add(new JLabel("Book Title:"));
        frame.add(title);
        frame.add(borrow);
        frame.add(delete);
        frame.add(exit);
        frame.add(new JScrollPane(display));

        borrow.addActionListener(e -> {
            if (library.borrowBook(title.getText())) {
                library.saveToFile();
                display.setText("Borrowed: " + title.getText());
            } else {
                display.setText("Book not found or already borrowed.");
            }
        });

        delete.addActionListener(e -> {
            if (library.deleteBook(title.getText())) {
                library.saveToFile();
                display.setText("Deleted: " + title.getText());
            } else {
                display.setText("Book not found.");
            }
        });

        exit.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }
}
