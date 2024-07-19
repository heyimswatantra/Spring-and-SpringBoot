package com.tight.coupling;

public class UserManager {
    public UserDB userDatabase = new UserDB();

    public String getUserInfo () {
        return userDatabase.getUserDetails();
    }
}
