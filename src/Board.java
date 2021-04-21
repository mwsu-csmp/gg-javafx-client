import javafx.scene.layout.GridPane;
import java.io.IOException;

public class Board extends GridPane {

    public Board()  {

        Tile sample;
        {
            try {
                sample = new Tile("resources/tile.png");
                add(sample, 0, 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
