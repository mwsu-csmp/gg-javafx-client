import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.http.HttpClient;

public class GameConnection {

    private final HttpClient client;
    private final String username;

    public GameConnection(HttpClient client, String username) {
        this.client = client;
        this.username = username;
    }

    public String getUsername() { return username; }
    public HttpClient getClient() { return client; }

    /** creates a javafx image associated with the tile type string
     * The tile type string is the same string specified in the board information
     * json provided by the server. The server will provide the specific
     * texture imaage associated with the tile type.
     * @param tileType
     * @return
     */
    public Image resolveTileTexture(String tileType) {
        //for now, hardcode a few tile types for debugging
        try {
            // TODO: retrieve correct texture from server
            switch(tileType) {
                case "wall":
                    return new Image(new FileInputStream("resources/wall.png"));
                case "floor":
                    return new Image(new FileInputStream("resources/floor.png"));
                case "grass":
                    return new Image(new FileInputStream("resources/grass.png"));

                default:
                    return new Image(new FileInputStream("resources/tile.png"));
            }
        }catch(IOException e) {
            // TODO: kill client connection, go back to login screen
            return null;
        }
    }

    public String getBoardJSON(String boardName) {
        // TODO: retrieve JSON from server

        // for now, return JSON for either outside or foyer
        if(boardName.equals("outside")) {
            return "{\"width\":17,\"tileTypes\":{\"@\":\"door\",\" \":\"grass\",\"#\":\"wall\"},\"height\":21,\"tilemap\":\"########@########\\n######## ########\\n######## ########\\n###          ####\\n#               #\\n#               #\\n#               #\\n#               #\\n#               #\\n#               #\\n#               #\\n#               #\\n#               #\\n#               #\\n#               #\\n#               #\\n#               #\\n#               #\\n#               #\\n#               #\\n#################\\n\"}";
        } else if(boardName.equals("foyer")) {
            return "{\"width\":23,\"tileTypes\":{\"@\":\"door\",\"#\":\"wall\",\"%\":\"countertop\",\"-\":\"floor\"},\"height\":18,\"tilemap\":\"#######--------########\\n#-----%%%%%%%%%%------#\\n#-----%--------%------#\\n#---------------------@\\n#---------------------#\\n#---------------------#\\n##--------%%%--------##\\n##-------%%%%%-------##\\n#--------%%%%%--------#\\n#--------%%%%%--------#\\n#--------%%%%%--------#\\n##-------------------##\\n##-------------------##\\n#---------------------#\\n#---------------------#\\n#---------------------#\\n###########@###########\\n#######################\\n\"}";
        } else {
            // TODO: Invalid board name, kill client
            return null;
        }
    }
}
