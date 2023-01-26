package bookshopparthenope;

import bookshopparthenope.Model.UserManagement.Admin;
import bookshopparthenope.Model.UserManagement.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.swing.*;

public class LoginController  implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button loginButton;

    @FXML
    private ComboBox<String> loginScelta;

    @FXML
    private PasswordField password;

    @FXML
    private Hyperlink signupButton;
    @FXML
    private Text wrongLogIn;
    @FXML
    private TextField username;



    @FXML
    void switchToSignup(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/bookshopparthenope/gui/registrazione.fxml"));
        Stage window = (Stage) signupButton.getScene().getWindow();
        window.setScene(new Scene(root,580,580));
    }
    private String[] adminOrCostumerChoiceBox = {"Admin","Costumer"};


    @FXML
    void validateLogin(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {


        String uname= username.getText();
        String upass= password.getText();
        if (uname.equals("") || upass.equals(""))
        {
            wrongLogIn.setText("Inserisci tutte le credenziali.");
            wrongLogIn.setVisible(true);
        }else

        if (loginScelta.getValue() == "Admin") {
            Admin admin = new Admin(username.getText(), password.getText());
            admin.logIn();
            if (!admin.logIn()) {
                wrongLogIn.setText("Credenziali errate");
                wrongLogIn.setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null,"Login effettuato!");
                root = FXMLLoader.load(getClass().getResource("/bookshopparthenope/gui/adminpanel.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } else if (loginScelta.getValue() == null) {
            wrongLogIn.setText("Seleziona tipo utente.");
            wrongLogIn.setVisible(true);
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        loginScelta.getItems().addAll(adminOrCostumerChoiceBox);
        loginScelta.setOnAction(this::getChoice);

    }

    public void getChoice(ActionEvent event) {

        String adminOrCostumerChoiceBox = loginScelta.getValue();
    }


}
