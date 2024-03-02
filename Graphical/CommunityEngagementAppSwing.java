package Graphical;
import javax.swing.*;
import java.awt.*;

public class CommunityEngagementAppSwing {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create a JFrame to hold the Swing components
            JFrame frame = new JFrame("Community Engagement Platform");

            // Create a JTabbedPane to hold the tabs
            JTabbedPane tabbedPane = new JTabbedPane();

            // Create and add the tabs
            JPanel homeTab = new JPanel();
            homeTab.add(new JLabel("Home Tab Content"));

            JPanel eventsTab = new JPanel();
            eventsTab.add(new JLabel("Events Tab Content"));

            JPanel resourcesTab = new JPanel();
            resourcesTab.add(new JLabel("Community Resources Tab Content"));

            JPanel volunteeringTab = new JPanel();
            volunteeringTab.add(new JLabel("Volunteering Tab Content"));

            JPanel chatTab = new JPanel();
            chatTab.add(new JLabel("Chat Tab Content"));

            tabbedPane.addTab("Home", homeTab);
            tabbedPane.addTab("Events", eventsTab);
            tabbedPane.addTab("Community Resources", resourcesTab);
            tabbedPane.addTab("Volunteering", volunteeringTab);
            tabbedPane.addTab("Chat", chatTab);

            // Add the tabbed pane to the frame
            frame.add(tabbedPane);

            // Set frame properties
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
