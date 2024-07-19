package com.loose.coupling;

public class UserDBProvider implements UserDataProvider {
    public String getUserDetails () {
        return "User details from db";
    }
}
