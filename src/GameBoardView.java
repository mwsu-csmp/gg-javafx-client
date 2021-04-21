import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.io.FileInputStream;
import java.io.IOException;

public class GameBoardView  extends FlowPane {
    public GameBoardView() {
        Board board = new Board();
        getChildren().add(board);
    }
}
