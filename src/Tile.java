import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;

public class Tile extends ImageView {
    public Tile(GameConnection connection, String tileType) throws IOException {
        super(connection.resolveTileTexture(tileType));
    }

}
