import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;

public class Tile extends ImageView {
    public Tile(String imageFilePath) throws IOException {
        super(new Image(new FileInputStream(imageFilePath)));
    }

}
