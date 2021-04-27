import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GameBoardView extends StackPane {

    private Board board;
    private int width;
    private int height;

    public GameBoardView(int width, int height) {
        this.width = width*25;
        this.height = height*25;
        this.setPrefWidth(width*25);
        this.setPrefHeight(height*25);
        this.setMaxHeight(height*25);
        this.setMaxWidth(width*25);
    }

    /** moves the window's upper-left-hand-corner to the specified
     * cooridinates on the current board
     * @param row
     * @param col
     */
    public void setOrientation(int row, int col) {
        final Rectangle outputClip = new Rectangle();
        outputClip.setX(row);
        outputClip.setY(col);
        outputClip.setWidth(width);
        outputClip.setHeight(height);
        board.setClip(outputClip);
    }

    /** sets the current board for this view */
    public void setBoard(Board board) {
        this.board = board;
        if(getChildren().size() == 0) getChildren().add(new Pane(board));
        else getChildren().set(0, new Pane(board));
    }

}
