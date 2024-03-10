package Graphical;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeTabSwing extends JPanel {

    private final List<String> allActivities = new ArrayList<>();
    private final JTextArea activitiesTextArea;
    private final CardLayout cardLayout;
    private final JPanel cardPanel;
    private final HashMap<String, String> userDataMap = new HashMap<>();

    public HomeTabSwing() {
        // Create a CardLayout to manage different "pages"
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        add(cardPanel);

        // Create a text area to display all activities
        activitiesTextArea = new JTextArea(10, 30);
        activitiesTextArea.setEditable(false); // Read-only
        cardPanel.add(new JScrollPane(activitiesTextArea), "Home");

        // Display all initial activities
        updateActivitiesTextArea();

        // Create the "About" panel
        JPanel aboutPanel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome to the community official platform", SwingConstants.CENTER);
        JButton signUpButton = new JButton("Sign Up");
        JButton logInButton = new JButton("Log In");

        aboutPanel.add(welcomeLabel, BorderLayout.NORTH);
        aboutPanel.add(signUpButton, BorderLayout.WEST);
        aboutPanel.add(logInButton, BorderLayout.EAST);

        cardPanel.add(aboutPanel, "About");

        // ActionListener for the "Sign Up" button
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSignUpForm();
            }
        });

        // ActionListener for the "Log In" button
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLogInForm();
            }
        });

        // Show the "About" panel
        cardLayout.show(cardPanel, "About");
    }

    // Method to add an activity from other tabs
    public void addActivity(String activity) {
        allActivities.add(activity);
        updateActivitiesTextArea();
    }

    private void updateActivitiesTextArea() {
        activitiesTextArea.setText(""); // Clear existing content
        allActivities.forEach(activity -> activitiesTextArea.append(activity + "\n"));
    }

    private void showSignUpForm() {
        JFrame signUpFrame = new JFrame("Sign Up");
        JPanel signUpPanel = new JPanel(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Enter your name:");
        JTextField nameField = new JTextField();
        JLabel passwordLabel = new JLabel("Enter your password:");
        JTextField passwordField = new JPasswordField();
        JButton okButton = new JButton("OK");

        signUpPanel.add(nameLabel);
        signUpPanel.add(nameField);
        signUpPanel.add(passwordLabel);
        signUpPanel.add(passwordField);
        signUpPanel.add(new JLabel());
        signUpPanel.add(okButton);

        signUpFrame.add(signUpPanel);
        signUpFrame.pack();
        signUpFrame.setVisible(true);

        // ActionListener for the "OK" button in the sign-up form
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String password = passwordField.getText();

                // Store the name and password in a data structure or database
                storeUserData(name, password);

                signUpFrame.dispose();
                JOptionPane.showMessageDialog(HomeTabSwing.this, "Sign-up successful. Please log in.");
                showLogInForm();
            }
        });
    }

    private void storeUserData(String name, String password) {
        // Example: Storing in a HashMap
        userDataMap.put(name, password);
    }

    private void showLogInForm() {
        JFrame logInFrame = new JFrame("Log In");
        JPanel logInPanel = new JPanel(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Enter your name:");
        JTextField nameField = new JTextField();
        JLabel passwordLabel = new JLabel("Enter your password:");
        JTextField passwordField = new JPasswordField();
        JButton logInButton = new JButton("Log In");

        logInPanel.add(nameLabel);
        logInPanel.add(nameField);
        logInPanel.add(passwordLabel);
        logInPanel.add(passwordField);
        logInPanel.add(new JLabel());
        logInPanel.add(logInButton);

        logInFrame.add(logInPanel);
        logInFrame.pack();
        logInFrame.setVisible(true);

        // ActionListener for the "Log In" button in the log-in form
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String password = passwordField.getText();

                // Check if the name and password match the stored data
                if (validateUserData(name, password)) {
                    logInFrame.dispose();
                    JOptionPane.showMessageDialog(HomeTabSwing.this, "Log-in successful.");
                    showEventsTab(); // Show the events tab after successful login
                } else {
                    JOptionPane.showMessageDialog(HomeTabSwing.this, "Incorrect information.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean validateUserData(String name, String password) {
        // Example: Checking against the stored HashMap
        String storedPassword = userDataMap.get(name);
        return storedPassword != null && storedPassword.equals(password);
    }

    private void showEventsTab() {
        // Create an instance of the EventsTabSwing class
        EventsTabSwing eventsTab = new EventsTabSwing();

        // Create a new JFrame to display the EventsTabSwing
        JFrame eventsFrame = new JFrame("Events Tab");
        eventsFrame.add(eventsTab);
        eventsFrame.setSize(600, 400);
        eventsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        eventsFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Home Tab (Swing)");
            HomeTabSwing homeTab = new HomeTabSwing();
            frame.add(homeTab);

            // Example: Adding an activity from another tab
            homeTab.addActivity("Upcoming Event: Community Cleanup on May 15");

            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}