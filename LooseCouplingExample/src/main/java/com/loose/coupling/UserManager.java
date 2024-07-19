package com.loose.coupling;

public class UserManager {

    // Reference  var of interface
    public UserDataProvider userDataProvider;

    public UserManager(UserDataProvider _userDataProvider) {
        this.userDataProvider = _userDataProvider;
    }
    public String getUserInfo () {
        return userDataProvider.getUserDetails();
    }
}
