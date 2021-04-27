import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.util.HashMap;

public class Board extends GridPane {

    public Board(GameConnection connection, String boardName)  {
        var jsonDescription = connection.getBoardJSON(boardName);
        Gson parser = new Gson();
        var boardInfo = parser.fromJson(jsonDescription, JsonObject.class);

        // TODO: parse json
        // TODO: use json parameters to initialize board

        final int boardWidth = boardInfo.get("width").getAsInt();
        final int boardHeight = boardInfo.get("height").getAsInt();
        final JsonObject tileTypes = boardInfo.get("tileTypes").getAsJsonObject();
        final HashMap<String,String> tileHashMap = new HashMap<>();
        for(String key : tileTypes.keySet()){
            String value = tileTypes.get(key).getAsString();
            tileHashMap.put(key,value);
        }
        final String tilemap = boardInfo.get("tilemap").getAsString();

        for(int row=0; row<boardHeight; row++) {
            for (int col = 0; col < boardWidth; col++) {
                Tile sample = null;
                {
                    try {
                        sample = new Tile(connection, tileHashMap.get(""+tilemap.charAt(col+(boardWidth+1)*row)));
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
