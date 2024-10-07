import javax.swing.*;
import java.awt.*;

public class ChatDisplay {
    private JTextArea textArea;

    // Constructor
    public ChatDisplay() {
        textArea = new JTextArea();
        textArea.setForeground(Color.DARK_GRAY);
        textArea.setBackground(Color.WHITE);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setEditable(false);
    }


    public void displayMessage(String message) {
        textArea.append(message + "\n");
    }

    public JScrollPane getChatScrollPane() {
        return new JScrollPane(textArea);
    }


    public void clearChat() {
        textArea.setText("");
    }
}