package com.tubes.laporin.Controllers.Lawyer;

import com.tubes.laporin.Controllers.alertMessage;
import com.tubes.laporin.Models.Model;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CreateUsersController implements Initializable {
    public TextField fName_fld;
    public TextField lName_fld;
    public TextField uName_fld;
    public TextField pwd_fld;
    public Button create_btn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        create_btn.setOnAction(event -> createUser());
    }
    private void createUser(){
        alertMessage alert = new alertMessage();
        String fname = fName_fld.getText();
        String lname = lName_fld.getText();
        String uname = uName_fld.getText();
        String password = pwd_fld.getText();
        Model.getInstance().evaluateUserRegister(uname);
        if (Model.getInstance().getUserRegisterSuccessFlag()){
            Model.getInstance().getDatabaseDriver().createUser(uname,password,fname,lname,LocalDate.now());
            alert.successMessage("Create User Success");
            Model.getInstance().getUsers().clear();
            Model.getInstance().setUsers();
            emptyField();
        }
        else {
            alert.errorMessage("Username Already Exist");
            uName_fld.setText("");
        }
    }
    private void emptyField(){
        fName_fld.setText("");
        lName_fld.setText("");
        uName_fld.setText("");
        pwd_fld.setText("");
    }
}
