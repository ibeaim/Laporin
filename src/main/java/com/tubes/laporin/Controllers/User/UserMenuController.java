package com.tubes.laporin.Controllers.User;

import com.tubes.laporin.Models.Model;
import com.tubes.laporin.Views.userMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UserMenuController implements Initializable {
    public Button dashboard_Btn;
    public Button profile_Btn;
    public Button logout_Btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
    private void addListeners() {
        dashboard_Btn.setOnAction(event -> onDashboard());
        profile_Btn.setOnAction(event -> onProfile());
        logout_Btn.setOnAction(event -> onLogout());
    }
    private void onDashboard(){
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set(userMenuOptions.DASHBOARD);
    }
    private void onProfile(){
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set(userMenuOptions.PROFILE);
    }
    private void onLogout() {
        // Get Stage
        Stage stage = (Stage) logout_Btn.getScene().getWindow();
        // Close the client window
        Model.getInstance().getViewFactory().closeStage(stage);
        // Show Login Window
        Model.getInstance().getViewFactory().showLoginWindow();
        // Set Client Login Success Flag To False
        Model.getInstance().setUserLoginSuccessFlag(false);
    }
}
