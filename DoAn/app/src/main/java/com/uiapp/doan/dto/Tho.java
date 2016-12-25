package com.uiapp.doan.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.uiapp.doan.interactor.api.response.BaseResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongnhung on 10/30/16.
 */

public class Tho  {
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("cmnd")
    @Expose
    private String cmnd;
    @SerializedName("hoten")
    @Expose
    private String hoten;
    @SerializedName("gioitinh")
    @Expose
    private String gioitinh;
    @SerializedName("quequan")
    @Expose
    private String quequan;
    @SerializedName("diachihientai")
    @Expose
    private String diachihientai;
    @SerializedName("sodt")
    @Expose
    private String sodt;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("motakinhnghiem")
    @Expose
    private String motakinhnghiem;
    @SerializedName("sonamkinhnghiem")
    @Expose
    private Integer sonamkinhnghiem;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("ngaysinh")
    @Expose
    private String ngaysinh;
    @SerializedName("hinhanh")
    @Expose
    private String hinhanh;
    @SerializedName("sotruong")
    @Expose
    private List<String> sotruong;
    @SerializedName("diachi")
    @Expose
    private DiaChi diachi;
    @SerializedName("danhgia")
    @Expose
    private String danhgia;
    @SerializedName("trinhdohocvan")
    @Expose
    private String trinhdohocvan;

    @SerializedName("xacnhan")
    @Expose
    private Boolean xacnhan;

    @SerializedName("luongtheogio")
    @Expose
    private String luongtheogio;

    public String getLuongtheogio() {
        return luongtheogio;
    }

    public void setLuongtheogio(String luongtheogio) {
        this.luongtheogio = luongtheogio;
    }

    public Boolean getXacnhan() {
        return xacnhan;
    }

    public void setXacnhan(Boolean xacnhan) {
        this.xacnhan = xacnhan;
    }

    /**

     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The _id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The cmnd
     */
    public String getCmnd() {
        return cmnd;
    }

    /**
     *
     * @param cmnd
     * The cmnd
     */
    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    /**
     *
     * @return
     * The hoten
     */
    public String getHoten() {
        return hoten;
    }

    /**
     *
     * @param hoten
     * The hoten
     */
    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    /**
     *
     * @return
     * The gioitinh
     */
    public String getGioitinh() {
        return gioitinh;
    }

    /**
     *
     * @param gioitinh
     * The gioitinh
     */
    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    /**
     *
     * @return
     * The quequan
     */
    public String getQuequan() {
        return quequan;
    }

    /**
     *
     * @param quequan
     * The quequan
     */
    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    /**
     *
     * @return
     * The diachihientai
     */
    public String getDiachihientai() {
        return diachihientai;
    }

    /**
     *
     * @param diachihientai
     * The diachihientai
     */
    public void setDiachihientai(String diachihientai) {
        this.diachihientai = diachihientai;
    }

    /**
     *
     * @return
     * The sodt
     */
    public String getSodt() {
        return sodt;
    }

    /**
     *
     * @param sodt
     * The sodt
     */
    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The motakinhnghiem
     */
    public String getMotakinhnghiem() {
        return motakinhnghiem;
    }

    /**
     *
     * @param motakinhnghiem
     * The motakinhnghiem
     */
    public void setMotakinhnghiem(String motakinhnghiem) {
        this.motakinhnghiem = motakinhnghiem;
    }

    /**
     *
     * @return
     * The sonamkinhnghiem
     */
    public Integer getSonamkinhnghiem() {
        return sonamkinhnghiem;
    }

    /**
     *
     * @param sonamkinhnghiem
     * The sonamkinhnghiem
     */
    public void setSonamkinhnghiem(Integer sonamkinhnghiem) {
        this.sonamkinhnghiem = sonamkinhnghiem;
    }

    /**
     *
     * @return
     * The v
     */
    public Integer getV() {
        return v;
    }

    /**
     *
     * @param v
     * The __v
     */
    public void setV(Integer v) {
        this.v = v;
    }

    /**
     *
     * @return
     * The ngaysinh
     */
    public String getNgaysinh() {
        return ngaysinh;
    }

    /**
     *
     * @param ngaysinh
     * The ngaysinh
     */
    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    /**
     *
     * @return
     * The hinhanh
     */
    public String getHinhanh() {
        return hinhanh;
    }

    /**
     *
     * @param hinhanh
     * The hinhanh
     */
    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    /**
     *
     * @return
     * The sotruong
     */
    public List<String> getSotruong() {
        return sotruong;
    }

    /**
     *
     * @param sotruong
     * The sotruong
     */
    public void setSotruong(List<String> sotruong) {
        this.sotruong = sotruong;
    }

    /**
     *
     * @return
     * The diachi
     */
    public DiaChi getDiachi() {
        return diachi;
    }

    /**
     *
     * @param diachi
     * The diachi
     */
    public void setDiachi(DiaChi diachi) {
        this.diachi = diachi;
    }

    /**
     *
     * @return
     * The danhgia
     */
    public String getDanhgia() {
        return danhgia;
    }

    /**
     *
     * @param danhgia
     * The danhgia
     */
    public void setDanhgia(String danhgia) {
        this.danhgia = danhgia;
    }

    /**
     *
     * @return
     * The trinhdohocvan
     */
    public String getTrinhdohocvan() {
        return trinhdohocvan;
    }

    /**
     *
     * @param trinhdohocvan
     * The trinhdohocvan
     */
    public void setTrinhdohocvan(String trinhdohocvan) {
        this.trinhdohocvan = trinhdohocvan;
    }

}
