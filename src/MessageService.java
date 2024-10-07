import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MessageService {
    private String username;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    // Constructor
    public MessageService(String username) {
        this.username = username;
    }

    // Metodo para formatear el mensaje con el username y la hora actual
    public String formatMessage(String message) {
        String time = LocalDateTime.now().format(formatter);
        return username + " [" + time + "]: " + message;
    }
}