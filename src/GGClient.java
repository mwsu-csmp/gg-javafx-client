import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** main class for running the GG client application */
public class GGClient extends Application {

    private static LoginPane loginPane;
    private static Scene loginScene;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        loginPane = new LoginPane();
        loginScene = new Scene(loginPane);
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("GG Client");
        primaryStage.show();
    }
}
