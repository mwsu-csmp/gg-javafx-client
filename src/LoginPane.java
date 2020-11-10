import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginPane extends BorderPane {
    private final TextField url;
    private final TextField username;
    private final PasswordField password;
    private final Button login;
    private final Button clear;

    public LoginPane() {
        VBox fields = new VBox();
        HBox buttons = new HBox();
        fields.alignmentProperty().setValue(Pos.BOTTOM_CENTER);
        buttons.alignmentProperty().setValue(Pos.TOP_CENTER);
        url = new TextField();
        username = new TextField();
        password = new PasswordField();
        login = new Button("login");
        clear = new Button("clear");
        fields.getChildren().add(new Label("Game URL", url));
        fields.getChildren().add(new Label("Username", username));
        fields.getChildren().add(new Label("Password", password));
        buttons.getChildren().add(login);
        buttons.getChildren().add(clear);
        setTop(fields);
        setCenter(buttons);

        login.setOnAction(event -> {
            System.out.println("TODO: handle login for " + username.getText());
        });

        clear.setOnAction(event -> {
            url.clear();
            username.clear();
            password.clear();
        });
    }

    public void setLoginAction(EventHandler<ActionEvent> action) {
        login.setOnAction(action);
    }
}
