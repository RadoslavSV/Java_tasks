package serverapp;
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

public class Server extends Application {

    private TextField txtInputLink; // inputs message from user
    private TextArea txaChatText;// display information to user
    private ObjectOutputStream output; // output stream to client
    private ObjectInputStream input; // input stream from client
    private ServerSocket server; // server socket
    private Socket connection; // connection to client
    private int counter = 1; // counter of number of connections 
    // set up GUI

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
        ); // end call to handle(ActionEvent evt)

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

    // set up and run server 
    public void runServer() {
        try // set up server to receive connections; process connections
        {
            server = new ServerSocket(12345, 100); // create ServerSocket

            while (true) {
                try {
                    waitForConnection(); // wait for a connection
                    getStreams(); // get input & output streams
                    processConnection(); // process connection
                } // end try
                catch (EOFException eofException) {
                    displayMessage("\nServer terminated connection");
                } // end catch
                finally {
                    closeConnection(); //  close connection
                    counter++;
                } // end finally
            } // end while
        } // end try
        catch (IOException ioException) {
            ioException.printStackTrace();
        } // end catch
    } // end method runServer

    // wait for connection to arrive, then display connection info
    private void waitForConnection() throws IOException {
        displayMessage("Waiting for connection\n");
        connection = server.accept(); // allow server to accept connection            
        displayMessage("Connection " + counter + " received from: "
                + connection.getInetAddress().getHostName());
    } // end method waitForConnection

    // get streams to send and receive data
    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(connection.getInputStream());

        displayMessage("\nGot I/O streams\n");
    } // end method getStreams

    // process connection with client
    private void processConnection() throws IOException {
        String message = "Connection successful";// message to client
        sendData(message); // send connection successful message

        // enable enterField so server user can send messages
        setTextFieldEditable(true);

        do // process messages sent from client
        {
            try // read message and display it
            {
                message = (String) input.readObject(); // read new message
                displayMessage("\n" + message); // display message
            } // end try
            catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown object type received");
            } // end catch

        } while (!message.toUpperCase().equals("CLIENT>>> TERMINATE"));
    } // end method processConnection

// close streams and socket
    private void closeConnection() {
        displayMessage("\nTerminating connection\n");
        setTextFieldEditable(false); // disable enterField

        try {
            if (output != null)  output.close(); // close output stream
            if (input != null)  input.close(); // close input stream 
            if (connection != null) connection.close(); // close socket
        } // end try
        catch (IOException ioException) {
        } // end catch
    } // end method closeConnection

    // send message to client
    private void sendData(String message) {
        try // send object to client
        {
            output.writeObject("SERVER>>> " + message);
            output.flush(); // flush output to client
            displayMessage("\nSERVER>>> " + message);
        } // end try
        catch (IOException ioException) {
            txaChatText.appendText("\nError writing object");
        } // end catch
    } // end method sendData

    // manipulates displayArea in the event-dispatch thread
    private void displayMessage(final String messageToDisplay) {
        Platform.runLater(()
                -> // updates displayArea
                {
                    txaChatText.appendText(messageToDisplay); // append message
                } // end method run

        ); // end call to Platfrom.runLater
    } // end method displayMessage

    // manipulates enterField in the event-dispatch thread
    private void setTextFieldEditable(final boolean editable) {
        Platform.runLater(()
                -> // sets enterField's editability
                {
                    txtInputLink.setEditable(editable);
                } // end method run

        ); // end call to Platfrom.runLater
    } // end method setTextFieldEditable

    @Override
    public void stop() {
        Platform.exit();
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
