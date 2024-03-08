package Graphical;
// VolunteeringTabSwing.java
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VolunteeringTabSwing extends JPanel {

    private final List<String> volunteeringOpportunities = new ArrayList<>();

    public VolunteeringTabSwing() {
        JLabel volunteeringLabel = new JLabel("Volunteering Opportunities");
        add(volunteeringLabel);

        JTextArea opportunityTextArea = new JTextArea(5, 30);
        opportunityTextArea.setLineWrap(true);
        add(opportunityTextArea);

        JButton submitButton = new JButton("Submit Opportunity");
        submitButton.addActionListener(e -> {
            String opportunityText = opportunityTextArea.getText();
            if (!opportunityText.isEmpty()) {
                volunteeringOpportunities.add(opportunityText);
                opportunityTextArea.setText(""); // Clear the input field
                // Update the UI to display the new opportunity (e.g., add to a list)
                // You can customize this part based on your UI design.
            }
        });
        add(submitButton);

        // Display the list of volunteering opportunities (customize as needed)
        // For simplicity, we'll just print them to the console here.
        volunteeringOpportunities.forEach(System.out::println);
    }

    // Other methods for handling opportunities (e.g., editing, deleting) can be added here
    // ...

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Volunteering Opportunities Tab (Swing)");
            frame.add(new VolunteeringTabSwing());

            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
