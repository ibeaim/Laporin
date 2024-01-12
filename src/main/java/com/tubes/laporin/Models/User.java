package com.tubes.laporin.Models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class User {
    private final StringProperty username;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final ObjectProperty<LocalDate> dateCreated;
    public User (String userName, String firstname, String lastname, LocalDate date){
        this.username = new SimpleStringProperty(this,"Username",userName);
        this.firstName = new SimpleStringProperty(this,"FirstName",firstname);
        this.lastName = new SimpleStringProperty(this, "LastName",lastname);
        this.dateCreated = new SimpleObjectProperty<>(this,"Date", date);
    }
    public StringProperty usernameProperty(){return username;}
    public StringProperty firstNameProperty(){return firstName;}
    public StringProperty lastNameProperty(){return lastName;}
    public ObjectProperty<LocalDate> dateCreatedProperty(){return dateCreated;}
}
