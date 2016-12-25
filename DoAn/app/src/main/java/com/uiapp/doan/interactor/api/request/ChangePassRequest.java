package com.uiapp.doan.interactor.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hongnhung on 12/15/16.
 */

public class ChangePassRequest {
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("passwork")
    @Expose
    private String passwork;
    @SerializedName("quyen")
    @Expose
    private String quyen;
    @SerializedName("cmnd")
    @Expose
    private String cmnd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswork() {
        return passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }
}
