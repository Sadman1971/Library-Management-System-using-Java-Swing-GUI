import javax.swing.*;
import java.awt.*;

public class WelcomeScreen {
    public WelcomeScreen() {
        JFrame frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        try {
            ImageIcon icon = new ImageIcon("library.jpg");
            Image scaled = icon.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH);
            JLabel label = new JLabel(new ImageIcon(scaled));
            frame.add(label, BorderLayout.CENTER);
        } catch (Exception e) {
            JLabel label = new JLabel("Image not found", SwingConstants.CENTER);
            frame.add(label, BorderLayout.CENTER);
        }

        JButton next = new JButton("Next");
        next.setBackground(Color.CYAN);
        next.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(next, BorderLayout.SOUTH);

        next.addActionListener(e -> {
            frame.dispose();
            new SignUpSignInScreen();
        });

        frame.setVisible(true);
    }
}
