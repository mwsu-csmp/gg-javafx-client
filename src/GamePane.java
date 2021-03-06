import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;


public class GamePane extends BorderPane {
    private final GameBoardView gameView = new GameBoardView(20, 12);

    private final ListView<String> inventory= new ListView<>(
            FXCollections.observableArrayList(
                    "sword",
                    "potion",
                    "5 bucks"
            )
    );
    private int testOrientationX = 0; // part of a testing harness, remove later
    private int testOrientationY = 0; // part of a testing harness, remove later
    private Board testboard1 = null;// part of a testing harness, remove later
    private Board testboard2 = null;// part of a testing harness, remove later
    private int currentTestBoard = 1; // part of a testing harness, remove later

    private final GameControls controls;
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

        controls = new GameControls(
                event -> {
                    testOrientationX-=50;
                    gameView.setOrientation(testOrientationX, testOrientationY);
                },
                event -> {
                    testOrientationX+=50;
                    gameView.setOrientation(testOrientationX, testOrientationY);
                },
                event -> {
                    testOrientationY-= 50;
                    gameView.setOrientation(testOrientationX, testOrientationY);
                },
                event -> {
                    testOrientationY+= 50;
                    gameView.setOrientation(testOrientationX, testOrientationY);
                },
                event -> {
                    currentTestBoard = (currentTestBoard) % 2 + 1; // toggle between two test maps
                    gameView.setBoard(currentTestBoard ==1 ? testboard1 : testboard2 );
                    gameView.setOrientation(0, 0);
                }
        );

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
        testboard1 = new Board(gameConnection, "outside");
        testboard2 = new Board(gameConnection, "foyer");
        gameView.setBoard(testboard1 );
        gameView.setOrientation(0, 0);;
    }
}
