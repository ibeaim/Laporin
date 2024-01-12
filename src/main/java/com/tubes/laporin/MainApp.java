package com.tubes.laporin;

import com.tubes.laporin.Models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage){
        Model.getInstance().getViewFactory().showLoginWindow();
    }

}