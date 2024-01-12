package com.tubes.laporin.Controllers.Lawyer;

import com.tubes.laporin.Models.Lawyer;
import com.tubes.laporin.Models.Model;
import com.tubes.laporin.Views.LawyerCellFactory;
import com.tubes.laporin.Views.UserCellFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class LawyersController implements Initializable {

    public ListView<Lawyer> lawyers_listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initLawyersList();
        lawyers_listView.setItems(Model.getInstance().getLawyers());
        lawyers_listView.setCellFactory(e -> new LawyerCellFactory());
    }
    private void initLawyersList(){
        if (Model.getInstance().getLawyers().isEmpty()){
            Model.getInstance().setLawyers();
        }
    }
}
