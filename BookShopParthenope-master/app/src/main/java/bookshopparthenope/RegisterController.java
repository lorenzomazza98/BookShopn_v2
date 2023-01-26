package bookshopparthenope;



import bookshopparthenope.Model.UserManagement.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController{


    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private TextField registerCognome;

    @FXML
    private TextField registerEmail;

    @FXML
    private TextField registerNome;

    @FXML
    private PasswordField registerPassword;

    @FXML
    private TextField registerUsername;

    @FXML
    void registerUser(ActionEvent event) {

    }

    @FXML
    void switchToLogin(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("/bookshopparthenope/gui/login.fxml"));
        Stage window = (Stage) loginButton.getScene().getWindow();
        window.setScene(new Scene(root,650,450));
    }



}
