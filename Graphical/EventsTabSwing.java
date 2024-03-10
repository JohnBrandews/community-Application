package Graphical;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventsTabSwing extends JPanel {
    private final Map<String, List<String>> eventCategories = new HashMap<>();
    private JTextArea eventTextArea;
    private JButton submitButton;
    private JPanel eventPanel;

    public EventsTabSwing() {
        setLayout(new BorderLayout());

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Create buttons for event categories
        JButton weddingsButton = new JButton("Weddings");
        JButton burialsButton = new JButton("Burials");
        JButton sportsButton = new JButton("Sports Activities");
        JButton voluntaryButton = new JButton("Voluntary Activities");

        // Initialize event lists for each category
        eventCategories.put("Weddings", new ArrayList<>());
        eventCategories.put("Burials", new ArrayList<>());
        eventCategories.put("Sports Activities", new ArrayList<>());
        eventCategories.put("Voluntary Activities", new ArrayList<>());

        // Add action listeners to buttons
        weddingsButton.addActionListener(e -> showEventUI("Weddings"));
        burialsButton.addActionListener(e -> showEventUI("Burials"));
        sportsButton.addActionListener(e -> showEventUI("Sports Activities"));
        voluntaryButton.addActionListener(e -> showEventUI("Voluntary Activities"));

        // Add buttons to the button panel
        buttonPanel.add(weddingsButton);
        buttonPanel.add(burialsButton);
        buttonPanel.add(sportsButton);
        buttonPanel.add(voluntaryButton);

        // Add the button panel to the main panel
        add(buttonPanel, BorderLayout.NORTH);

        // Initialize the event panel with the "Weddings" category
        showEventUI("Weddings");
    }

    private void showEventUI(String category) {
        if (eventPanel != null) {
            remove(eventPanel);
        }

        eventPanel = new JPanel(new BorderLayout());

        eventTextArea = new JTextArea(5, 30);
        eventTextArea.setLineWrap(true);
        eventPanel.add(new JScrollPane(eventTextArea), BorderLayout.CENTER);

        submitButton = new JButton("Submit Event");
        submitButton.addActionListener(e -> {
            String eventText = eventTextArea.getText();
            if (!eventText.isEmpty()) {
                eventCategories.get(category).add(eventText);
                eventTextArea.setText(""); // Clear the input field
                displayEvents(category);
            }
        });
        eventPanel.add(submitButton, BorderLayout.SOUTH);

        add(eventPanel, BorderLayout.CENTER);
        displayEvents(category);
        revalidate(); // Update the panel's layout
        repaint(); // Redraw the panel
    }

    private void displayEvents(String category) {
        JTextArea eventsDisplay = new JTextArea(10, 30);
        eventsDisplay.setEditable(false);
        for (String event : eventCategories.get(category)) {
            eventsDisplay.append(event + "\n");
        }
        eventPanel.add(new JScrollPane(eventsDisplay), BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Upcoming Events Tab (Swing)");
            frame.add(new EventsTabSwing());

            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}