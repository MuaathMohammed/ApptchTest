package com.example.loginwithwebapi.Models;

public class Users {
    public int ID ;
    public String UserName ;

    public String UserEmail ;
    public String UserPassword ;

    public Users(int ID, String userName, String userEmail, String userPassword, String userConfirmPassword) {
        this.ID = ID;
        UserName = userName;
        UserEmail = userEmail;
        UserPassword = userPassword;
        UserConfirmPassword = userConfirmPassword;
    }

    public String UserConfirmPassword ;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getUserConfirmPassword() {
        return UserConfirmPassword;
    }

    public void setUserConfirmPassword(String userConfirmPassword) {
        UserConfirmPassword = userConfirmPassword;
    }
}
