package com.health.medicare.emedicare;

/**
 * Created by M1035979 on 2/25/2018.
 */

public class UserDetails {
    UserDetails() {

    }

    void setUserName(String userName) {
        this.userName = userName;
    }

    void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    void setEmail(String email) {
        this.email = email;
    }

    void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    UserDetails(String userName, String mobileNumber, String email, String address, String password) {
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    private String userName;
    private String mobileNumber;
    private String email;

    private String address;
    private String password;
    String getUserName() {
        return userName;
    }

    String getMobileNumber() {
        return mobileNumber;
    }

    String getEmail() {
        return email;
    }

    String getAddress() {
        return address;
    }


    String getPassword() {
        return password;
    }
}
