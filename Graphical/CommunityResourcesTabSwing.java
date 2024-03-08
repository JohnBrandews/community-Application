package Graphical;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CommunityResourcesTabSwing extends JPanel {

    private final List<String> communityResources = new ArrayList<>();

    public CommunityResourcesTabSwing() {
        JLabel resourcesLabel = new JLabel("Community Resources");
        add(resourcesLabel);

        JTextArea resourceTextArea = new JTextArea(5, 30);
        resourceTextArea.setLineWrap(true);
        add(resourceTextArea);

        JButton submitButton = new JButton("Submit Resource");
        submitButton.addActionListener(e -> {
            String resourceText = resourceTextArea.getText();
            if (!resourceText.isEmpty()) {
                communityResources.add(resourceText);
                resourceTextArea.setText(""); // Clear the input field
                // Update the UI to display the new resource (e.g., add to a list)
                // You can customize this part based on your UI design.
            }
        });
        add(submitButton);

        // Display the list of community resources (customize as needed)
        // For simplicity, we'll just print them to the console here.
        communityResources.forEach(System.out::println);
    }

    // Other methods for handling resources (e.g., editing, deleting) can be added here
    // ...

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Community Resources Tab (Swing)");
            frame.add(new CommunityResourcesTabSwing());

            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
