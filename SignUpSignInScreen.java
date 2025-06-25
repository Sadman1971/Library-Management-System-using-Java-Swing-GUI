import javax.swing.*;
import java.awt.*;
import java.io.*;

public class SignUpSignInScreen {
    public SignUpSignInScreen() {
        JFrame frame = new JFrame("Sign Up / Sign In");
        frame.setSize(400, 250);
        frame.setLayout(new GridLayout(4, 2));
        frame.getContentPane().setBackground(Color.BLACK);

        JLabel nameLabel = new JLabel("Name:");
        JLabel passLabel = new JLabel("Password:");
        JTextField name = new JTextField();
        JPasswordField pass = new JPasswordField();
        JButton signup = new JButton("Sign Up");
        JButton signin = new JButton("Sign In");
        JLabel msg = new JLabel();

        // Set all text to white
        nameLabel.setForeground(Color.WHITE);
        passLabel.setForeground(Color.WHITE);
        msg.setForeground(Color.WHITE);

        // Optional: dark background and white text for fields
        name.setBackground(Color.DARK_GRAY);
        name.setForeground(Color.WHITE);
        pass.setBackground(Color.DARK_GRAY);
        pass.setForeground(Color.WHITE);

        // Button color
        signup.setBackground(Color.GRAY);
        signup.setForeground(Color.WHITE);
        signin.setBackground(Color.GRAY);
        signin.setForeground(Color.WHITE);

        frame.add(nameLabel);
        frame.add(name);
        frame.add(passLabel);
        frame.add(pass);
        frame.add(signup);
        frame.add(signin);
        frame.add(msg);

        signup.addActionListener(e -> {
            String user = name.getText();
            String pwd = new String(pass.getPassword());
            try (FileWriter fw = new FileWriter("user.txt")) {
                fw.write(user + "," + pwd);
                msg.setText("Signed Up!");
            } catch (IOException ex) {
                msg.setText("Error saving user.");
            }
        });

        signin.addActionListener(e -> {
            frame.dispose();
            new LoginScreen();
        });

        frame.setVisible(true);
    }
}
