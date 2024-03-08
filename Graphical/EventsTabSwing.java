package Graphical;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EventsTabSwing extends JPanel {

    private final List<String> upcomingEvents = new ArrayList<>();

    public EventsTabSwing() {
        JLabel eventsLabel = new JLabel("Upcoming Events");
        add(eventsLabel);

        JTextArea eventTextArea = new JTextArea(5, 30);
        eventTextArea.setLineWrap(true);
        add(eventTextArea);

        JButton submitButton = new JButton("Submit Event");
        submitButton.addActionListener(e -> {
            String eventText = eventTextArea.getText();
            if (!eventText.isEmpty()) {
                upcomingEvents.add(eventText);
                eventTextArea.setText(""); // Clear the input field
                // Update the UI to display the new event (e.g., add to a list)
                // You can customize this part based on your UI design.
            }
        });
        add(submitButton);

        // Display the list of upcoming events (customize as needed)
        // For simplicity, we'll just print them to the console here.
        upcomingEvents.forEach(System.out::println);
    }

    // Other methods for handling events (e.g., editing, deleting) can be added here
    // ...

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Upcoming Events Tab (Swing)");
            frame.add(new EventsTabSwing());

            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
