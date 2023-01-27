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


/*
Questo codice rappresenta una classe Java che controlla il login degli utenti del sistema. La classe estende l'interfaccia Initializable, che consente di eseguire il codice iniziale quando la finestra di login viene aperta. La classe contiene diversi elementi dell'interfaccia utente come un pulsante di login, una casella di selezione per selezionare se l'utente è un amministratore o un cliente, una casella di testo per inserire il nome utente e una casella di testo per inserire la password.

La classe contiene anche diverse funzioni, tra cui switchToSignup e validateLogin. La funzione switchToSignup viene chiamata quando l'utente fa clic sul pulsante di registrazione e carica una nuova finestra per la registrazione. La funzione validateLogin viene chiamata quando l'utente fa clic sul pulsante di accesso e controlla se le credenziali inserite sono valide. In caso contrario, viene visualizzato un messaggio di errore.

La funzione validateLogin crea un oggetto di tipo Admin o Customer in base alla scelta dell'utente e chiama il metodo logIn dell'oggetto creato per verificare le credenziali. Se le credenziali sono valide, carica una nuova finestra per l'interfaccia dell'amministratore o del cliente. In caso contrario, visualizza un messaggio di errore.

La funzione initialize inizializza la combobox loginScelta per mostrare le opzioni "Admin" e "Cliente" e la funzione getChoice prende la scelta dell'utente dalla combobox.
 */
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
        stage.centerOnScreen();
    }
    private String[] adminOrCostumerChoiceBox = {"Admin","Cliente"};


    @FXML
    void validateLogin(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {

        String uname = username.getText();
        String upass = password.getText();
        if (uname.equals("") || upass.equals("")) {
            wrongLogIn.setText("Inserisci tutte le credenziali.");
            wrongLogIn.setVisible(true);
        }
        else {
            String tipoUtente=loginScelta.getValue();
            if(tipoUtente== null) {
                wrongLogIn.setText("Seleziona tipo utente.");
                wrongLogIn.setVisible(true);
            }else{
            switch (tipoUtente){
            case("Admin"):
                Admin admin = new Admin(username.getText(), password.getText());
                if (admin.logIn()) {
                    tipoUtente="/bookshopparthenope/gui/adminpanel.fxml";}
                else { tipoUtente="";}
                break;
            case("Cliente"):
                Customer customer = new Customer(username.getText(), password.getText());
                if (customer.logIn()) {
                    tipoUtente="/bookshopparthenope/gui/home.fxml";}
                else { tipoUtente="";System.out.println("aaaa");}
                break;
            default:
                wrongLogIn.setText("Seleziona tipo utente");
                wrongLogIn.setVisible(true);
                break;
            }
            if (tipoUtente.equals("")){
                wrongLogIn.setText("Credenziali errate");
                wrongLogIn.setVisible(true);
            }
            else{
            root = FXMLLoader.load(getClass().getResource(tipoUtente));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
            } }
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
