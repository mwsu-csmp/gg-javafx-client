import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class LoginPane extends FlowPane {
    private final TextField url;
    private final TextField username;
    private final PasswordField password;
    private final Button login;
    private final Button clear;

    public LoginPane() {
        url = new TextField();
        username = new TextField();
        password = new PasswordField();
        login = new Button("login");
        clear = new Button("clear");
        getChildren().add(new Text("Game URL"));
        getChildren().add(url);
        getChildren().add(new Text("Username"));
        getChildren().add(username);
        getChildren().add(new Text("Password"));
        getChildren().add(password);
        getChildren().add(login);
        getChildren().add(clear);

        login.setOnAction(event -> {
            System.out.println("TODO: handle login for " + username.getText());
        });

        clear.setOnAction(event -> {
            url.clear();
            username.clear();
            password.clear();
        });
    }
}
