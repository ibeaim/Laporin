package com.tubes.laporin.Views;

import com.tubes.laporin.Controllers.Lawyer.UserListCellController;
import com.tubes.laporin.Models.Model;
import com.tubes.laporin.Models.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class UserCellFactory extends ListCell<User> {
    @Override
    public void updateItem(User user, boolean empty){
        super.updateItem(user, empty);
        if (empty){
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Lawyer/UserListCell.fxml"));
            UserListCellController controller = new UserListCellController(user);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
