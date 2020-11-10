import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class GameControls extends BorderPane {
    public GameControls() {
        var leftButton = new Button("<");
        var rightButton = new Button(">");
        var upButton = new Button("^");
        var downButton = new Button("v");
        var actionButton = new Button("*");

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
