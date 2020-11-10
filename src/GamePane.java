import javafx.scene.layout.FlowPane;


public class GamePane extends FlowPane {
    public GamePane() {
        GameBoardView view = new GameBoardView();
        GameControls controls = new GameControls();

        getChildren().add(view);
        getChildren().add(controls);
    }
}
