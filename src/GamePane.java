import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class GamePane extends BorderPane {
    private final GameBoardView gameView = new GameBoardView();
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

    public GamePane() {
        VBox leftPane = new VBox();
        leftPane.getChildren().add(gameView);
        leftPane.getChildren().add(chat);
        BorderPane messageSendBar = new BorderPane();
        messageSendBar.setLeft(message);
        messageSendBar.setRight(sendMessage);
        leftPane.getChildren().add(messageSendBar);

        VBox rightPane = new VBox();
        rightPane.getChildren().add(inventory);
        rightPane.getChildren().add(controls);

        setLeft(leftPane);
        setRight(rightPane);
    }
}
