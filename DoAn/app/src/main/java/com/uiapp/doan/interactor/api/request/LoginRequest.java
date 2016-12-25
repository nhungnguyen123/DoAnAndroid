package com.uiapp.doan.interactor.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by hongnhung on 11/6/16.
 */

public class LoginRequest implements Serializable {
    @SerializedName("username")
    @Expose
    public String username;

    @SerializedName("password")
    @Expose
    public String password;


    public LoginRequest(String username , String password){
        this.username = username;
        this.password = password;
    }






}
