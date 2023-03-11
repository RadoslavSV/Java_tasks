// Set up a server that will receive a connection from a client, send
// a string to the client, and close the connection.

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Server extends Application {
    // DESERIALIZES FROM FILE 'cards.xml' LIST OF ALL CREDIT CARD OBJECTS
    private final List<CreditCard> loadedCards = XMLSerializationCreditCard.deserializeFromXML();
    private TextField txtInputLink;
    private TextArea txaChatText;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket connection;
    private int counter = 1;

    public Server() throws IOException {
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(14));
        root.setSpacing(8);
        txtInputLink = new TextField();
        txtInputLink.setPromptText("Type text");
        txaChatText = new TextArea();
        txtInputLink.setOnAction(event -> {
            sendData(txtInputLink.getText());
            txtInputLink.setText("");
        }
        );

        txaChatText.setMaxSize(1.7976931348623157E308, 1.7976931348623157E308);
        root.getChildren().addAll(txtInputLink, txaChatText);
        Scene scene = new Scene(root, 350, 250, Color.web("#666970"));
        // shutdown thread gracefully
        primaryStage.setOnCloseRequest(evt -> stop());
        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);
        primaryStage.show();
        Thread thread = new Thread(() -> runServer());
        thread.start();
    }

    public void runServer() {
        try {
            server = new ServerSocket(12345, 100);

            while (true) {
                try {
                    waitForConnection();
                    getStreams();
                    processConnection();
                }
                catch (EOFException eofException) {
                    displayMessage("\nServer terminated connection");
                }
                finally {
                    closeConnection();
                    counter++;
                }
            }
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void waitForConnection() throws IOException {
        displayMessage("Waiting for connection\n");
        connection = server.accept();
        displayMessage("Connection " + counter + " received from: "
                + connection.getInetAddress().getHostName());
    }

    private void getStreams() throws IOException {
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();

        input = new ObjectInputStream(connection.getInputStream());

        displayMessage("\nGot I/O streams\n");
    }

    private void processConnection() throws IOException {
        String message = "Connection successful";
        sendData(message);

        setTextFieldEditable(true);

        do {
            try {
                message = (String) input.readObject();
                displayMessage("\n" + message);

                // GOES THROUGH THE WHOLE LIST OF CREDIT CARDS AND CHECK IF THE RECEIVED NUMBER IS PRESENT THERE
                for(var x : loadedCards) {
                    if (Objects.equals(message.substring(10), x.getNumber())) {
                        sendData(String.format("Credit Card is present and its token is %s", x.getToken()));
                        break;
                    }
                }
                // IF THE MESSAGE ENDS WITH 'list',
                // SORTS THE CARDS BY NUMBER AND
                // SENDS EACH ONE'S INFO AS A MESSAGE TO THE CLIENT
                if(message.matches("^.*>>> list$")) {
                    loadedCards.stream()
                            .sorted(Comparator.comparing(CreditCard::getNumber))
                            .forEach(x -> sendData(String.format("Credit Card: %s with token %s", x.getNumber(), x.getToken())));
                }

                if(message.matches("^.*>>> tokens$")) {
                    loadedCards.stream()
                            .sorted(Comparator.comparing(CreditCard::getToken))
                            .forEach(x -> sendData(String.format("Token: %s of credit card %s", x.getToken(), x.getNumber())));
                }
            }
            catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown object type received");
            }

        } while (!message.toUpperCase().equals("CLIENT>>> TERMINATE"));
    }

    private void closeConnection() {
        displayMessage("\nTerminating connection\n");
        setTextFieldEditable(false);

        try {
            if (output != null)  output.close();
            if (input != null)  input.close();
            if (connection != null) connection.close();
        }
        catch (IOException ioException) {
        }
    }

    private void sendData(String message) {
        try {
            output.writeObject("SERVER>>> " + message);
            output.flush();
            displayMessage("\nSERVER>>> " + message);
        }
        catch (IOException ioException) {
            txaChatText.appendText("\nError writing object");
        }
    }

    private void displayMessage(final String messageToDisplay) {
        Platform.runLater(()
                ->
                {
                    txaChatText.appendText(messageToDisplay);
                }

        );
    }

    private void setTextFieldEditable(final boolean editable) {
        Platform.runLater(()
                ->
                {
                    txtInputLink.setEditable(editable);
                }

        );
    }

    @Override
    public void stop() {
        Platform.exit();
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

}
