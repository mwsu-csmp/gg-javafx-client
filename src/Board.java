import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.util.HashMap;

public class Board extends GridPane {

    /** Builds the game board
     * rooms are hardcoded in via the json file in GameConnection
     * @param connection
     * @param boardName name of the room
     */
    public Board(GameConnection connection, String boardName)  {
        var jsonDescription = connection.getBoardJSON(boardName); // gets the JSON for the given room name
        Gson parser = new Gson();
        var boardInfo = parser.fromJson(jsonDescription, JsonObject.class);

        final int boardWidth = boardInfo.get("width").getAsInt(); // pulls width out of json file
        final int boardHeight = boardInfo.get("height").getAsInt(); // pulls height out of json file
        final JsonObject tileTypes = boardInfo.get("tileTypes").getAsJsonObject(); // pulls tile types out of json file
        final HashMap<String,String> tileHashMap = new HashMap<>();
        for(String key : tileTypes.keySet()){
            String value = tileTypes.get(key).getAsString();
            tileHashMap.put(key,value);
        } // hash map of the different tile types
        final String tilemap = boardInfo.get("tilemap").getAsString(); // pulls tile map from the json file

        for(int row=0; row<boardHeight; row++) { // builds the rows of board given the height
            for (int col = 0; col < boardWidth; col++) { // builds the columns of the board given the width
                Tile sample = null;
                { // makes a new tile
                    try {
                        sample = new Tile(connection, tileHashMap.get(""+tilemap.charAt(col+(boardWidth+1)*row)));
                        // makes a tile based on the spot in the json file and uses that as the key to pull from the hashMap
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
