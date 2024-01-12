package com.tubes.laporin.Views;

import com.tubes.laporin.Controllers.Lawyer.LawyerController;
import com.tubes.laporin.Controllers.User.UserController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    private AccountType loginAccountType;
    // User View
    private final ObjectProperty<userMenuOptions> userSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane profileView;

    // Lawyer View
    private final ObjectProperty<lawyerMenuOptions> lawyerSelectedMenuItem;
    private AnchorPane createUserView;
    private AnchorPane usersView;
    private AnchorPane lawyersView;

    public ViewFactory(){
        this.loginAccountType = AccountType.USER;
        this.userSelectedMenuItem = new SimpleObjectProperty<>();
        this.lawyerSelectedMenuItem = new SimpleObjectProperty<>();
    }
    public AccountType getLoginAccountType(){
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public ObjectProperty<userMenuOptions> getUserSelectedMenuItem() {
        return userSelectedMenuItem;
    }

    public AnchorPane getDashboardView(){
        if (dashboardView == null){
            try {
                dashboardView = new FXMLLoader(getClass().getResource("/Fxml/User/Dashboard.fxml")).load();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return dashboardView;
    }
    public AnchorPane getProfileView(){
        if (profileView == null){
            try {
                profileView = new FXMLLoader(getClass().getResource("/Fxml/User/Profile.fxml")).load();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return profileView;
    }




    // Lawyer Views Section
    public ObjectProperty<lawyerMenuOptions> getLawyerSelectedMenuItem(){
        return lawyerSelectedMenuItem;
    }
    public AnchorPane getCreateUserView(){
        if (createUserView == null){
            try {
                createUserView = new FXMLLoader(getClass().getResource("/Fxml/Lawyer/CreateUsers.fxml")).load();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return createUserView;
    }

    public AnchorPane getUsersView() {
        if (usersView == null){
            try {
                usersView = new FXMLLoader(getClass().getResource("/Fxml/Lawyer/Users.fxml")).load();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return usersView;
    }
    public AnchorPane getLawyersView(){
        if (lawyersView == null){
            try {
                lawyersView = new FXMLLoader(getClass().getResource("/Fxml/Lawyer/Lawyers.fxml")).load();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return lawyersView;
    }
    public void showUserWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/User/User.fxml"));
        UserController userController = new UserController();
        loader.setController(userController);
        createStage(loader);
    }
    public void showLawyerWindow(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Lawyer/Lawyer.fxml"));
        LawyerController controller = new LawyerController();
        fxmlLoader.setController(controller);
        createStage(fxmlLoader);
    }


    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/anchor.png"))));
        stage.setResizable(false);
        stage.setTitle("Laporin");
        stage.show();
    }

    public void closeStage(Stage stage){
        stage.close();
    }
}
