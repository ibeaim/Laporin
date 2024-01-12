package com.tubes.laporin.Models;

import javafx.beans.property.*;
import javafx.scene.control.ListCell;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Lawyer {
    private final StringProperty name;
    private final ObjectProperty<LocalDate> date;
    private final StringProperty shift;
    private final StringProperty time;
    private final DoubleProperty price;
    private final StringProperty message;
    public Lawyer (String name, LocalDate date, String shift, String time, double price, String message){
        this.name = new SimpleStringProperty(this,"name",name);
        this.date = new SimpleObjectProperty<>(this,"Date", date);
        this.shift = new SimpleStringProperty(this, "Shift", shift);
        this.time = new SimpleStringProperty(this, "time", time);
        this.price = new SimpleDoubleProperty(this,"Price", price);
        this.message = new SimpleStringProperty(this,"Message", message);
    }

    public StringProperty nameProperty(){return this.name;}
    public ObjectProperty<LocalDate> dateProperty(){return this.date;}
    public StringProperty shiftProperty(){return this.shift;}
    public StringProperty timeProperty(){return this.time;}
    public DoubleProperty priceProperty(){return this.price;}
    public StringProperty messageProperty(){return this.message;}
}
