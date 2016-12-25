package com.uiapp.doan.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by hongnhung on 11/6/16.
 */

public class KhachHang implements Serializable {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("matkhau")
    @Expose
    private String matkhau;
    @SerializedName("hoten")
    @Expose
    private String hoten;
    @SerializedName("taikhoan")
    @Expose
    private String taikhoan;
    @SerializedName("diachi")
    @Expose
    private String diachi;
    @SerializedName("email")
    @Expose
    private String email;


    public KhachHang( String matkhau, String hoten, String taikhoan, String diachi, String email) {
        this.matkhau = matkhau;
        this.hoten = hoten;
        this.taikhoan = taikhoan;
        this.diachi = diachi;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return matkhau;
    }

    public void setPassword(String password) {
        this.matkhau = password;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
