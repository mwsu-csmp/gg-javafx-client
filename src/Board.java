import javafx.scene.layout.GridPane;
import java.io.IOException;

public class Board extends GridPane {

    public Board()  {
        final int boardWidth = 20;
        final int boardHeight = 12;

        for(int row=0; row<boardHeight; row++) {
            for (int col = 0; col < boardWidth; col++) {
                Tile sample = null;
                {
                    try {
                        sample = new Tile("resources/tile.png");
                        add(sample, 0, 0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Board.setRowIndex(sample, row);
                Board.setColumnIndex(sample, col);
            }
        }


    }
}
