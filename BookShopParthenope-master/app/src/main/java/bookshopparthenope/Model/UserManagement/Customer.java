package bookshopparthenope.Model.UserManagement;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe che estende User per modellare un Cliente dello shop
 */
public class Customer extends User{

    protected String name;
    protected String surname;
    protected String email;

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }




    //Implementazione metodo login
    @Override
    public boolean logIn() throws SQLException, ClassNotFoundException {
        ResultSet set = DBService.logInCustomer(username, password);

        if (set != null) {
                this.username = set.getString(1);
                this.password = set.getString(2);
                return true;
        }
        return false;

    }
}
