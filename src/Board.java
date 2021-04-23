import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javafx.scene.layout.GridPane;
import java.io.IOException;

public class Board extends GridPane {

    public Board(GameConnection connection, String boardName)  {
        var jsonDescription = connection.getBoardJSON(boardName);
        Gson parser = new Gson();
        var boardInfo = parser.fromJson(jsonDescription, JsonObject.class);

        // TODO: parse json
        // TODO: use json parameters to initialize board
        // TODO: use

        final int boardWidth = boardInfo.get("width").getAsInt();
        final int boardHeight = boardInfo.get("height").getAsInt();

        for(int row=0; row<boardHeight; row++) {
            for (int col = 0; col < boardWidth; col++) {
                Tile sample = null;
                {
                    try {
                        sample = new Tile(connection, "grass");
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
