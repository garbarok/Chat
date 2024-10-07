import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserInputPanel extends JPanel {
    private JTextField textField;
    private JButton sendButton;
    private JButton resetButton;

    public UserInputPanel() {
        this.setLayout(new FlowLayout());
        this.setBackground(Color.DARK_GRAY);

        // Crear los componentes
        JLabel label = new JLabel("Enter text:");
        label.setForeground(Color.WHITE);
        textField = new JTextField(20);
        sendButton = new JButton("Send");
        resetButton = new JButton("Reset");

        // Añadir componente al panel
        this.add(label);
        this.add(textField);
        this.add(sendButton);
        this.add(resetButton);
    }

    // Metodo para agregar listeners a los botones
    public void addSendActionListener(ActionListener actionListener) {
        sendButton.addActionListener(actionListener);
        textField.addActionListener(actionListener);  // Trigger action on Enter key
    }

    // Metodo para agregar listeners a el boton reset
    public void addResetActionListener(ActionListener actionListener) {
        resetButton.addActionListener(actionListener);
    }

    // Metodo para obtener el input del usuario
    public String getUserInput() {
        String input = textField.getText().trim();
        textField.setText("");
        return input;
    }
}