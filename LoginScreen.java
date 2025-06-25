import javax.swing.*;
import java.awt.*;
import java.io.*;

public class LoginScreen {
    public LoginScreen() {
        JFrame frame = new JFrame("Login");
        frame.setSize(400, 250);
        frame.setLayout(new GridLayout(4, 2));
        frame.getContentPane().setBackground(Color.BLACK);

        JLabel nameLabel = new JLabel("Name:");
        JLabel passLabel = new JLabel("Password:");
        JTextField name = new JTextField();
        JPasswordField pass = new JPasswordField();
        JButton login = new JButton("Login");
        JLabel msg = new JLabel();

        nameLabel.setForeground(Color.WHITE);
        passLabel.setForeground(Color.WHITE);
        msg.setForeground(Color.WHITE);

        name.setBackground(Color.DARK_GRAY);
        name.setForeground(Color.WHITE);
        pass.setBackground(Color.DARK_GRAY);
        pass.setForeground(Color.WHITE);

        login.setBackground(Color.GRAY);
        login.setForeground(Color.WHITE);

        frame.add(nameLabel);
        frame.add(name);
        frame.add(passLabel);
        frame.add(pass);
        frame.add(login);
        frame.add(msg);

        login.addActionListener(e -> {
            String user = name.getText();
            String pwd = new String(pass.getPassword());
            try (BufferedReader br = new BufferedReader(new FileReader("user.txt"))) {
                String line = br.readLine();
                if (line != null && line.equals(user + "," + pwd)) {
                    frame.dispose();
                    new BookManagementScreen();
                } else {
                    msg.setText("Invalid credentials");
                }
            } catch (IOException ex) {
                msg.setText("User not found.");
            }
        });

        frame.setVisible(true);
    }
}
