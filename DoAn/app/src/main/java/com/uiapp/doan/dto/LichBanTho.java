package com.uiapp.doan.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by hongnhung on 11/18/16.
 */

public class LichBanTho implements Serializable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("cmnd")
    @Expose
    private String cmnd;
    @SerializedName("giobd")
    @Expose
    private Integer giobd;
    @SerializedName("giokt")
    @Expose
    private Integer giokt;
    @SerializedName("ngay")
    @Expose
    private String ngay;
    @SerializedName("__v")
    @Expose
    private Integer v;

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

    public Integer getGiobd() {
        return giobd;
    }

    public void setGiobd(Integer giobd) {
        this.giobd = giobd;
    }

    public Integer getGiokt() {
        return giokt;
    }

    public void setGiokt(Integer giokt) {
        this.giokt = giokt;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }
}
