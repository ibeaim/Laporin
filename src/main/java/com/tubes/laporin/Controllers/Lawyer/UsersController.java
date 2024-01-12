package com.tubes.laporin.Controllers.Lawyer;

import com.tubes.laporin.Models.Model;
import com.tubes.laporin.Models.User;
import com.tubes.laporin.Views.UserCellFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class UsersController implements Initializable {
    public ListView<User> users_listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initUsersList();
        users_listView.setItems(Model.getInstance().getUsers());
        users_listView.setCellFactory(e -> new UserCellFactory());
    }
    public void initUsersList(){
        if (Model.getInstance().getUsers().isEmpty()){
            Model.getInstance().setUsers();
        }
    }
}
