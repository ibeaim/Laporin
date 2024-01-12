package com.tubes.laporin.Controllers.Lawyer;

import com.tubes.laporin.Models.Model;
import com.tubes.laporin.Views.lawyerMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LawyerMenuController implements Initializable {
    public Button create_user_btn;
    public Button users_btn;
    public Button lawyers_btn;
    public Button logout_Btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
    private void addListeners(){
        create_user_btn.setOnAction(event -> onCreateUser());
        users_btn.setOnAction(event -> onUsers());
        lawyers_btn.setOnAction(event -> onLawyers());
        logout_Btn.setOnAction(event -> onLogout());
    }
    private void onCreateUser(){
        Model.getInstance().getViewFactory().getLawyerSelectedMenuItem().set(lawyerMenuOptions.CREATE_USER);
    }
    private void onUsers(){
        Model.getInstance().getViewFactory().getLawyerSelectedMenuItem().set(lawyerMenuOptions.USERS);
    }
    private void onLawyers(){
        Model.getInstance().getViewFactory().getLawyerSelectedMenuItem().set(lawyerMenuOptions.LAWYERS);
    }
    private void onLogout() {
        // Get Stage
        Stage stage = (Stage) lawyers_btn.getScene().getWindow();
        // Close the Admin window
        Model.getInstance().getViewFactory().closeStage(stage);
        // Show Login Window
        Model.getInstance().getViewFactory().showLoginWindow();
        // Set Admin Login Success Flag To False
        Model.getInstance().setAdminLoginSuccessFlag(false);
    }
}
