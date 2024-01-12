package com.tubes.laporin.Models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Admin {
    private final StringProperty username;
    private final StringProperty password;
    public Admin (String userName, String Password){
        this.username = new SimpleStringProperty(this,"Username",userName);
        this.password = new SimpleStringProperty(this,"Password",Password);
    }
    public StringProperty usernameProperty(){return username;}
    public StringProperty passwordProperty(){return password;}
}
