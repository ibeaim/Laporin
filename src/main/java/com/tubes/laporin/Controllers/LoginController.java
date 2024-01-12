package com.tubes.laporin.Controllers;

import com.tubes.laporin.Models.Model;
import com.tubes.laporin.Views.AccountType;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    public Text loginTitle;
    @FXML
    public Button login_Btn;
    @FXML
    public CheckBox login_checkBox;
    @FXML
    public AnchorPane login_form;
    @FXML
    public PasswordField login_passwordHidden;
    @FXML
    public TextField login_passwordText;
    @FXML
    public Button login_switchForm;
    @FXML
    public TextField login_username;
    @FXML
    public Text registerTitle;
    @FXML
    public Button register_Btn;
    @FXML
    public CheckBox register_checkBox;
    @FXML
    public TextField register_firstName;
    @FXML
    public AnchorPane register_form;
    @FXML
    public TextField register_lastName;
    @FXML
    public PasswordField register_passwordHidden;
    @FXML
    public TextField register_passwordText;
    @FXML
    public Button register_switchForm;
    @FXML
    public TextField register_username;
    public ChoiceBox<AccountType> login_choiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_choiceBox.setItems(FXCollections.observableArrayList(AccountType.LAWYER, AccountType.USER));
        login_choiceBox.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        login_choiceBox.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(login_choiceBox.getValue()));
        login_Btn.setOnAction(this::handle);
        register_Btn.setOnAction(this::handleRegister);
    }
    private void onLogin(){
        Stage stage = (Stage) login_choiceBox.getScene().getWindow();
        alertMessage alert = new alertMessage();
        String password = getPassword();
        if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.USER){
            // Evaluate Login  Credentials
            Model.getInstance().evaluateUserCred(login_username.getText(),password);
            if(Model.getInstance().getUserLoginSuccessFlag()){
                Model.getInstance().getViewFactory().showUserWindow();
                alert.successMessage("Login Success!");
                // Close login stage
                Model.getInstance().getViewFactory().closeStage(stage);
            } else {
                // Show Alert
                alert.errorMessage("Incorrect Username/Password");
            }
        } else {
            // Evaluate Login  Credentials
            Model.getInstance().evaluateAdminCred(login_username.getText(),password);
            if(Model.getInstance().getAdminLoginSuccessFlag()){
                Model.getInstance().getViewFactory().showLawyerWindow();
                alert.successMessage("Login Success!");
                // Close login stage
                Model.getInstance().getViewFactory().closeStage(stage);
            } else {
                emptyFieldLogin();
                // Show Alert
                alert.errorMessage("Incorrect Username/Password");
            }
        }
    }
    private void onRegister(){
        alertMessage alertMessage = new alertMessage();
        String fname = register_firstName.getText();
        String lname = register_lastName.getText();
        String uname = register_username.getText();
        String password = getPasswordRegister();
        Model.getInstance().evaluateUserRegister(uname);
        if (Model.getInstance().getUserRegisterSuccessFlag()){
            Model.getInstance().getDatabaseDriver().createUser(uname,password,fname,lname,LocalDate.now());
            alertMessage.successMessage("Register Success ! Please go to Login Page");
            emptyFieldRegister();
        }
        else {
            alertMessage.errorMessage("Username Already Exist");
            register_username.setText("");
        }
    }
    private String getPassword(){
        if(login_passwordText.isVisible()){
            return login_passwordText.getText();
        } else {
            return login_passwordHidden.getText();
        }
    }
    private String getPasswordRegister(){
        if(register_passwordText.isVisible()){
            return register_passwordText.getText();
        } else {
            return register_passwordHidden.getText();
        }
    }
    public void showPassword(){
        if(login_checkBox.isSelected()){
            login_passwordText.setText(login_passwordHidden.getText());
            login_passwordText.setVisible(true);
            login_passwordHidden.setVisible(false);
        } else {
            login_passwordHidden.setText(login_passwordText.getText());
            login_passwordHidden.setVisible(true);
            login_passwordText.setVisible(false);
        }
    }
    public void showPasswordRegister(){
        if(register_checkBox.isSelected()){
            register_passwordText.setText(register_passwordHidden.getText());
            register_passwordText.setVisible(true);
            register_passwordHidden.setVisible(false);
        } else {
            register_passwordHidden.setText(register_passwordText.getText());
            register_passwordHidden.setVisible(true);
            register_passwordText.setVisible(false);
        }
    }
    public void switchForm (ActionEvent event){
        if(event.getSource() == register_switchForm){
            register_form.setVisible(false);
            login_form.setVisible(true);
        }else if (event.getSource() == login_switchForm){
            register_form.setVisible(true);
            login_form.setVisible(false);
        }
    }
    private void emptyFieldRegister(){
        register_username.setText("");
        register_firstName.setText("");
        register_lastName.setText("");
        register_passwordHidden.setText("");
        register_passwordText.setText("");
    }
    private void emptyFieldLogin(){
        login_username.setText("");
        login_passwordHidden.setText("");
        login_passwordText.setText("");
    }
    private void handle(ActionEvent event) {
        onLogin();
    }
    private void handleRegister(ActionEvent event) {
        onRegister();
    }
}
