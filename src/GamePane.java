import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class GamePane extends BorderPane {
    private final GameBoardView gameView = new GameBoardView(20, 12);
    private final GameControls controls = new GameControls();
    private final ListView<String> inventory= new ListView<>(
            FXCollections.observableArrayList(
                    "sword",
                    "potion",
                    "5 bucks"
            )
    );
    private final TextArea chat = new TextArea();
    private final TextField message = new TextField();
    private final Button sendMessage = new Button("Send");
    private final Label authenticatedUser = new Label();
    private GameConnection gameConnection;

    public GamePane() {
        VBox leftPane = new VBox();
        leftPane.getChildren().add(gameView);
        leftPane.getChildren().add(chat);
        BorderPane messageSendBar = new BorderPane();
        var messagePane = new HBox();
        messagePane.getChildren().add(authenticatedUser);
        messagePane.getChildren().add(message);
        messageSendBar.setLeft(messagePane);
        messageSendBar.setRight(sendMessage);
        leftPane.getChildren().add(messageSendBar);

        VBox rightPane = new VBox();
        rightPane.getChildren().add(inventory);
        rightPane.getChildren().add(controls);

        setLeft(leftPane);
        setRight(rightPane);
    }

    /** client connected over network to game, load game details */
    public void setGameConnection(GameConnection connection) {
        this.gameConnection = connection;
        this.authenticatedUser.setText(connection.getUsername());
        // for now, load a dummy board to test and view top left corner of board:
        gameView.setBoard(new Board(gameConnection,"outside"));
        gameView.setOrientation(0, 0);
    }

}
