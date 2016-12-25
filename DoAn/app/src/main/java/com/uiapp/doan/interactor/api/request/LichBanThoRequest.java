package com.uiapp.doan.interactor.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hongnhung on 12/17/16.
 */

public class LichBanThoRequest {
    @SerializedName("cmnd")
    @Expose
    private String cmnd;
    @SerializedName("hotenKH")
    @Expose
    private String hotenKH;
    @SerializedName("ngay")
    @Expose
    private String ngay;
    @SerializedName("giobd")
    @Expose
    private String giobd;
    @SerializedName("giokt")
    @Expose
    private String giokt;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("_id")
    @Expose
    private String id;

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getHotenKH() {
        return hotenKH;
    }

    public void setHotenKH(String hotenKH) {
        this.hotenKH = hotenKH;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getGiobd() {
        return giobd;
    }

    public void setGiobd(String giobd) {
        this.giobd = giobd;
    }

    public String getGiokt() {
        return giokt;
    }

    public void setGiokt(String giokt) {
        this.giokt = giokt;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
