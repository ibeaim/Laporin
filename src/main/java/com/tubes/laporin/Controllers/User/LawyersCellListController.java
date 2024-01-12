package com.tubes.laporin.Controllers.User;

import com.tubes.laporin.Models.DatabaseDriver;
import com.tubes.laporin.Models.Lawyer;
import com.tubes.laporin.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class LawyersCellListController implements Initializable {
    public Label law_name_lbl;
    public Label law_date_lbl;
    public Label law_shift_lbl;
    public Label law_time_lbl;
    public Label law_price_lbl;
    public Button law_get_btn;

    private final Lawyer lawyer;
    public LawyersCellListController(Lawyer lawyer){
        this.lawyer = lawyer;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        law_name_lbl.textProperty().bind(lawyer.nameProperty());
        law_date_lbl.textProperty().bind(lawyer.dateProperty().asString());
        law_shift_lbl.textProperty().bind(lawyer.shiftProperty());
        law_time_lbl.textProperty().bind(lawyer.timeProperty());
        law_price_lbl.textProperty().bind(lawyer.priceProperty().asString());
    }
}
