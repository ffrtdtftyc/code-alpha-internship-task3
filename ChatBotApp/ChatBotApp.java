import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatBotApp extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public ChatBotApp() {
        setTitle("Java AI Chatbot");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        sendButton = new JButton("Send");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());

        setVisible(true);
    }

    private void sendMessage() {
        String userInput = inputField.getText();
        if (!userInput.trim().isEmpty()) {
            chatArea.append("You: " + userInput + "\n");
            String botResponse = getResponse(userInput);
            chatArea.append("Bot: " + botResponse + "\n");
            inputField.setText("");
        }
    }

    // Rule-based chatbot logic (formerly in BotLogic.java)
    private String getResponse(String input) {
        input = input.toLowerCase();

        if (input.contains("hello") || input.contains("hi")) {
            return "Hello! How can I assist you today?";
        } else if (input.contains("your name")) {
            return "I’m JavaBot, your virtual assistant.";
        } else if (input.contains("bye")) {
            return "Goodbye! Have a nice day!";
        } else if (input.contains("help")) {
            return "I can assist with general queries like greetings, names, or FAQs.";
        } else {
            return "I'm not sure how to respond to that. Can you rephrase?";
        }
    }

    public static void main(String[] args) {
        new ChatBotApp();
    }
}
