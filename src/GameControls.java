import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class GameControls extends BorderPane {
    public GameControls() {
        setLeft(new Button("<"));
        setRight(new Button(">"));
        setTop(new Button("^"));
        setBottom(new Button("v"));
    }
}
