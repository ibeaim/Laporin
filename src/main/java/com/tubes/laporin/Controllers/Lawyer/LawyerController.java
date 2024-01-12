package com.tubes.laporin.Controllers.Lawyer;

import com.tubes.laporin.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LawyerController implements Initializable {
    public BorderPane lawyer_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getLawyerSelectedMenuItem().addListener(
                (observableValue, oldValLaw, newValLaw) -> {
            switch (newValLaw) {
                case USERS -> lawyer_parent.setCenter(Model.getInstance().getViewFactory().getUsersView());
                case LAWYERS -> lawyer_parent.setCenter(Model.getInstance().getViewFactory().getLawyersView());
                default -> lawyer_parent.setCenter(Model.getInstance().getViewFactory().getCreateUserView());
            }
        });
    }
}
