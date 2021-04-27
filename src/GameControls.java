import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class GameControls extends BorderPane {
    public GameControls(EventHandler<ActionEvent> lbuttonAction,
                        EventHandler<ActionEvent> rbuttonAction,
                        EventHandler<ActionEvent> ubuttonAction,
                        EventHandler<ActionEvent> dbuttonAction,
                        EventHandler<ActionEvent> abuttonAction) {
        var leftButton = new Button("<");
        var rightButton = new Button(">");
        var upButton = new Button("^");
        var downButton = new Button("v");
        var actionButton = new Button("*");

        leftButton.setOnAction(lbuttonAction);
        rightButton.setOnAction(rbuttonAction);
        upButton.setOnAction(ubuttonAction);
        downButton.setOnAction(dbuttonAction);
        actionButton.setOnAction(abuttonAction);

        setAlignment(leftButton, Pos.CENTER);
        setAlignment(rightButton, Pos.CENTER);
        setAlignment(upButton, Pos.CENTER);
        setAlignment(upButton, Pos.CENTER);
        setAlignment(downButton, Pos.CENTER);
        setAlignment(actionButton, Pos.CENTER);
        setLeft(leftButton);
        setRight(rightButton);
        setCenter(actionButton);
        setTop(upButton);
        setBottom(downButton);
    }
}
