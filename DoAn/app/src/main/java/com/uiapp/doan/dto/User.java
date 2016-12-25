package com.uiapp.doan.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by hongnhung on 11/6/16.
 */

public class User implements Serializable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("cmnd")
    @Expose
    private String cmnd;
    @SerializedName("passwork")
    @Expose
    private String passwork;
    @SerializedName("quyen")
    @Expose
    private String quyen;
    @SerializedName("username")
    @Expose
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
