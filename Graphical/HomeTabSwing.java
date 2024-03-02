package Graphical;
import javax.swing.*;
import java.awt.*;

public class HomeTabSwing extends JPanel {

    public HomeTabSwing() {
        // Create and add components for the Home tab
        JLabel welcomeLabel = new JLabel("Welcome to the Community Engagement Platform!");
        add(welcomeLabel);

        // Add additional components and functionality as needed
        // (e.g., event cards, announcement feed, shortcuts, etc.)
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create a JFrame to hold the Swing components
            JFrame frame = new JFrame("Home Tab (Swing)");

            // Create an instance of your HomeTabSwing class
            HomeTabSwing homeTab = new HomeTabSwing();

            // Add the tab content to the frame
            frame.add(homeTab);

            // Set frame properties
            frame.setSize(400, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
