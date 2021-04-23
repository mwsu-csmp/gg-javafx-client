import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GameBoardView  extends FlowPane {
    public GameBoardView(int width, int height) {
        // TODO: set up the window with the specified size
    }

    /** moves the window's upper-left-hand-corner to the specified
     * cooridinates on the current board
     * @param row
     * @param col
     */
    public void setOrientation(int row, int col) {
        // TODO: move window over the appropriate place on the board
    }

    /** sets the current board for this view */
    public void setBoard(Board board) {
        // TODO: manage window over board
        // TODO: ensure board can be updated with new board
        getChildren().add(board);
    }


}
