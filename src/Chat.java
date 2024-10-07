import javax.swing.*;
import java.awt.*;

public class Chat {
    private JPanel ChatFrame;
    private ChatDisplay chatDisplay;
    private UserInputPanel userInputPanel;
    private MessageService messageService;
    private String username;

    public static void main(String[] args) {
        // Crear un frame con un titulo
        JFrame frame = new JFrame("ChatFrame");

        // Crear un menu
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");
        // Agregar los menus al menuBar
        menuBar.add(file);
        menuBar.add(help);

        // Crear menu items
        JMenuItem open = new JMenuItem("Open");
        JMenuItem saveAs = new JMenuItem("Save As");
        // Agregar los menu items al menu
        file.add(open);
        file.add(saveAs);
        frame.setJMenuBar(menuBar);

        // Crear instancia de Chat
        Chat chatApp = new Chat();
        frame.setContentPane(chatApp.ChatFrame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);


        // Llamada al metodo promptForUsername
        chatApp.promptForUsername();
    }

    public Chat() {
        ChatFrame = new JPanel(new BorderLayout());
        ChatFrame.setBackground(Color.WHITE);

        // incializa los componentes
        chatDisplay = new ChatDisplay();
        userInputPanel = new UserInputPanel();
        messageService = new MessageService(username);


        ChatFrame.add(chatDisplay.getChatScrollPane(), BorderLayout.CENTER);
        ChatFrame.add(userInputPanel, BorderLayout.SOUTH);

        // agrega los listeners
        userInputPanel.addSendActionListener(e -> {
            String userInput = userInputPanel.getUserInput();
            if (!userInput.isEmpty()) {
                String formattedMessage = messageService.formatMessage(userInput);
                chatDisplay.displayMessage(formattedMessage);
            }
        });

        // agrega el listener para el boton reset
        userInputPanel.addResetActionListener(e -> chatDisplay.clearChat());
    }

    public void promptForUsername() {
        username = JOptionPane.showInputDialog(ChatFrame, "Please enter your username:", "Username", JOptionPane.PLAIN_MESSAGE);

        if (username == null || username.trim().isEmpty()) {
            username = "Anonymous";
        }

        messageService = new MessageService(username);

        chatDisplay.displayMessage("Welcome, " + username + "!");
    }
}