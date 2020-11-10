import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** main class for running the GG client application */
public class GGClient extends Application {

    private LoginPane loginPane;
    private Scene loginScene;

    private GamePane gamePane;
    private Scene gameScene;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        loginPane = new LoginPane();
        loginScene = new Scene(loginPane);
        gamePane = new GamePane();
        gameScene = new Scene(gamePane);
        primaryStage.setScene(loginScene);

        loginPane.setLoginAction(event -> {
            primaryStage.setScene(gameScene);
        });

        primaryStage.setTitle("GG Client");
        primaryStage.show();
    }
}
