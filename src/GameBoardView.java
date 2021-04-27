import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GameBoardView extends StackPane {
    public GameBoardView(int width, int height) {
        this.setPrefWidth(width);
        this.setPrefHeight(height);
        this.setMaxHeight(height);
        this.setMaxWidth(width);
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
        // TODO: ensure board can be updated with new board
        getChildren().add(board);
    }


}
