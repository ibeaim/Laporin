package com.tubes.laporin.Controllers.Lawyer;

import com.tubes.laporin.Models.Model;
import com.tubes.laporin.Models.User;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class UserListCellController implements Initializable {
    public Label unameAcc_lbl;
    public Label fNameAcc_lbl;
    public Label dateAcc_lbl;
    public Label lNameAcc_lbl;
    public Button delete_btn;

    private final User user;
    public UserListCellController(User user){
        this.user = user;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        unameAcc_lbl.textProperty().bind(user.usernameProperty());
        fNameAcc_lbl.textProperty().bind(user.firstNameProperty());
        lNameAcc_lbl.textProperty().bind(user.lastNameProperty());
        dateAcc_lbl.textProperty().bind(user.dateCreatedProperty().asString());
        delete_btn.setOnAction(event -> onDeleteUser(user.usernameProperty().get()));
    }
    private void onDeleteUser(String username){
        Model.getInstance().getDatabaseDriver().deleteUser(username);
        Model.getInstance().getUsers().clear();
        Model.getInstance().setUsers();
    }
}
