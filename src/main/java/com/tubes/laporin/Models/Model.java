package com.tubes.laporin.Models;

import com.tubes.laporin.Views.AccountType;
import com.tubes.laporin.Views.UserCellFactory;
import com.tubes.laporin.Views.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final UserCellFactory userCellFactory;
    private final DatabaseDriver databaseDriver;
    // User Data section
    private final User user;
    private final Admin admin;
    private final Lawyer lawyer;
    private boolean userLoginSuccessFlag;
    private boolean adminLoginSuccessFlag;
    private boolean userRegisterSuccessFLag;
    // Lawyer Data Section
    private final ObservableList<User> users;
    private final ObservableList<Lawyer> lawyers;


    private Model(){
        this.viewFactory = new ViewFactory();
        this.userCellFactory = new UserCellFactory();
        this.databaseDriver = new DatabaseDriver();

        // User Data Section
        this.userLoginSuccessFlag = false;
        this.user = new User("","","",null);
        this.userRegisterSuccessFLag = false;
        // Admin Data Section
        this.adminLoginSuccessFlag = false;
        this.admin = new Admin("","");
        // All Lawyer Data Section
        this.lawyer = new Lawyer("",null,"","",0,"");
        this.users = FXCollections.observableArrayList();
        this.lawyers = FXCollections.observableArrayList();
    }

    public static synchronized Model getInstance(){
        if (model == null){
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }
    public UserCellFactory getUserCellFactory(){return userCellFactory;}
    public DatabaseDriver getDatabaseDriver(){return databaseDriver;}
    // User Method Section
    public boolean getUserLoginSuccessFlag() {return this.userLoginSuccessFlag;}
    public void setUserLoginSuccessFlag(boolean flag){this.userLoginSuccessFlag=flag;}
    public User getUser(){
        return user;
    }
    public boolean getUserRegisterSuccessFlag(){return this.userRegisterSuccessFLag;}
    public void setUserRegisterSuccessFLag(boolean flag){this.userRegisterSuccessFLag=flag;}
    public boolean getAdminLoginSuccessFlag(){return this.adminLoginSuccessFlag;}
    public void setAdminLoginSuccessFlag(boolean flag){this.adminLoginSuccessFlag=flag;}
    public Admin getAdmin(){
        return admin;
    }
    public Lawyer getLawyer(){return lawyer;}
    public void evaluateUserCred(String username, String password){
        ResultSet resultset = databaseDriver.getUserData(username,password);
        try {
            if (resultset.next()) {
                this.user.firstNameProperty().set(resultset.getString("FirstName"));
                this.user.lastNameProperty().set(resultset.getString("LastName"));
                this.user.usernameProperty().set(resultset.getString("Username"));
                String[] dateParts = resultset.getString("Date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                this.user.dateCreatedProperty().set(date);
                this.userLoginSuccessFlag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void evaluateAdminCred(String username, String password){
        ResultSet resultset = databaseDriver.getAdminData(username,password);
        try {
            if (resultset.next()) {
                this.admin.usernameProperty().set(resultset.getString("Username"));
                this.admin.passwordProperty().set(resultset.getString("Password"));
                this.adminLoginSuccessFlag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void evaluateUserRegister(String username){
        ResultSet resultSet = databaseDriver.searchUser(username);
        try {
            if (resultSet.next()){
                this.userRegisterSuccessFLag = false;
            }
            else {
                this.userRegisterSuccessFLag = true;
            }
        } catch (SQLException e){e.printStackTrace();}
    }
    public ObservableList<Lawyer> getLawyers(){
        return lawyers;
    }
    public ObservableList<User> getUsers(){
        return users;
    }
    public void setUsers(){
        ResultSet resultSet = databaseDriver.getAllUsersData();
        try {
            while (resultSet.next()){
                String uname = resultSet.getString("Username");
                String fname = resultSet.getString("FirstName");
                String lname = resultSet.getString("LastName");
                String[] dateParts = resultSet.getString("Date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                users.add(new User(uname, fname, lname, date));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setLawyers(){
        ResultSet resultSet = databaseDriver.getAllLawyersData();
        try {
            while (resultSet.next()){
                String name = resultSet.getString("Name");
                String[] dateParts = resultSet.getString("Date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                String shift = resultSet.getString("Shift");
                String time = resultSet.getString("Time");
                double price = resultSet.getDouble("Price");
                lawyers.add(new Lawyer(name,date,shift,time,price,""));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
