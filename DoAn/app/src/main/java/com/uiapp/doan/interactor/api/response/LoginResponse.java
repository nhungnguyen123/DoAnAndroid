package com.uiapp.doan.interactor.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.uiapp.doan.dto.User;

/**
 * Created by hongnhung on 11/6/16.
 */

public class LoginResponse extends BaseResponse {

    @SerializedName("results")
    @Expose
    public User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
