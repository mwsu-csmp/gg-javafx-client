import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

public class LoginPane extends BorderPane {
    private String authenticatedUser = null;
    private final Consumer<GameConnection>  postLoginAction;
    private final TextField url;
    private final TextField username;
    private final PasswordField password;
    private final Button login;
    private final Button clear;
    private final Label errorMessage = new Label();

    /**
     *
     * @param postLoginAction action to be run on the authenticated user name when someone logs in
     */
    public LoginPane(Consumer<GameConnection> postLoginAction, HttpClient client) {
        this.postLoginAction = postLoginAction;
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
        setBottom(errorMessage);

        // login button should attempt to authenticate user and run the post login action if successful
        login.setOnAction(event -> {
            // TODO: authenticate user properly
            var username = this.username.getText();
            var password = this.password.getText();
            //var request = HttpRequest.newBuilder()
            //        .uri(URI.create(url.getText()));

            //try {
                // TODO: connect to game
                //client.sendAsync(request, ...
                authenticatedUser = username;
                var gameConnection = new GameConnection(client, username);
                postLoginAction.accept(gameConnection);
            //} catch(IOException e) {
            //    errorMessage.setText("ERROR: could not authenticate user" + this.username.getText() + " with given password");
            //} catch(InterruptedException e2) {
            //    errorMessage.setText("ERROR: could not authenticate user" + this.username.getText() + " with given password");
            //}
        });

        clear.setOnAction(event -> {
            url.clear();
            username.clear();
            password.clear();
        });
    }

    public String getAuthenticatedUser() {
        return authenticatedUser;
    }
}
