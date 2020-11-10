import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.io.FileInputStream;
import java.io.IOException;

public class GameBoardView  extends FlowPane {
    public GameBoardView() {
        try {
            Image demo = new Image(new FileInputStream("resources/sample.png"));
            ImageView demoScreen = new ImageView(demo);
            demoScreen.setX(0);
            demoScreen.setY(0);
            demoScreen.fitHeightProperty().setValue(300);
            demoScreen.fitWidthProperty().setValue(400);
            demoScreen.setPreserveRatio(true);
            getChildren().add(demoScreen);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
