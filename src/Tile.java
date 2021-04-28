import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;

public class Tile extends ImageView {
    /** calls the ImageView constructor
     * a tile is an ImageView
     * @param connection
     * @param tileType
     * @throws IOException
     */
    public Tile(GameConnection connection, String tileType) throws IOException {
        super(connection.resolveTileTexture(tileType));
    }

}
