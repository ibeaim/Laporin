package com.tubes.laporin.Models;

import java.sql.*;
import java.time.LocalDate;

public class DatabaseDriver {
    private Connection connection;
    public DatabaseDriver() {
        try{
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/laporin",
                    "root","");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

//    User Section
    public ResultSet getUserData(String username, String password){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery(
                    "SELECT * FROM users WHERE Username='"+username +"' AND Password='"+password+"';");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet searchUser(String username){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery(
                    "SELECT * FROM users WHERE Username='"+username+"';"
            );
        } catch (SQLException e){e.printStackTrace();}
        return resultSet;
    }
    public void deleteUser(String username){
        Statement statement;
        try {
            statement = this.connection.createStatement();
            // Execute delete query
            int rowsDeleted = statement.executeUpdate(
                    "DELETE FROM users WHERE Username='"+username+"';"
            );
            // Display results
            if (rowsDeleted > 0) {
                System.out.println("Data deleted successfully!");
            } else {
                System.out.println("No data found for the given username.");
            }
        } catch (SQLException e){e.printStackTrace();}
    }
//    Lawyer Section
    public ResultSet getAdminData(String username, String password){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM admin WHERE Username='"+username+"' AND Password='"+password+"';");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getAllUsersData(){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users;");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet getAllLawyersData(){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM lawyers;");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }
    public void createUser(String Username, String Password, String FirstName, String LastName, LocalDate Date){
        Statement statement;
        try {
            statement = this.connection.createStatement();
            statement.executeUpdate("INSERT INTO "+
                    "users (Username, Password, FirstName, LastName, Date)"+
                    "VALUES ('"+Username+"','"+Password+"','"+FirstName+"','"+LastName+"', '"+Date.toString()+"');");
        } catch (SQLException e){e.printStackTrace();}
    }

}
