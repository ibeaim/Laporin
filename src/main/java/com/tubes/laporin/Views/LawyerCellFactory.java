package com.tubes.laporin.Views;

import com.tubes.laporin.Controllers.User.LawyersCellListController;
import com.tubes.laporin.Models.Lawyer;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class LawyerCellFactory extends ListCell<Lawyer> {
    @Override
    protected void updateItem(Lawyer lawyer, boolean empty){
        super.updateItem(lawyer, empty);
        if (empty){
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/User/LawyersCellList.fxml"));
            LawyersCellListController controller = new LawyersCellListController(lawyer);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
