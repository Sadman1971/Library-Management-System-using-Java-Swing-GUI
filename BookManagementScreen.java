import javax.swing.*;
import java.awt.*;

public class BookManagementScreen {
    private Library library = new Library();

    public BookManagementScreen() {
        library.loadFromFile();

        JFrame frame = new JFrame("Book Management");
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(6, 2));

        JTextField title = new JTextField();
        JTextField author = new JTextField();
        JButton add = new JButton("Add Book");
        JButton list = new JButton("List Books");
        JButton next = new JButton("Next");
        JTextArea area = new JTextArea();

        add.setBackground(Color.CYAN);
        list.setBackground(Color.CYAN);
        next.setBackground(Color.CYAN);

        frame.add(new JLabel("Book Title:"));
        frame.add(title);
        frame.add(new JLabel("Author:"));
        frame.add(author);
        frame.add(add);
        frame.add(list);
        frame.add(new JLabel("Books:"));
        frame.add(new JScrollPane(area));
        frame.add(next);

        add.addActionListener(e -> {
            library.addBook(new Book(title.getText(), author.getText()));
            library.saveToFile();
            area.setText("Book added: " + title.getText());
            title.setText("");
            author.setText("");
        });

        list.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (Book b : library.getBooks()) sb.append(b).append("\n");
            area.setText(sb.toString());
        });

        next.addActionListener(e -> {
            frame.dispose();
            new BorrowDeleteScreen(library);
        });

        frame.setVisible(true);
    }
}
