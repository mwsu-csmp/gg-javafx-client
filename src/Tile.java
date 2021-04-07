import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;

public class Tile {
    public Tile(String imageFilePath) {
        try {
            Image tile = new Image(new FileInputStream(imageFilePath));
            ImageView demoTile = new ImageView(tile);
            demoTile.setPreserveRatio(true);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
