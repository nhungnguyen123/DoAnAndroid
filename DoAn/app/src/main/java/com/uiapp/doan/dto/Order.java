package com.uiapp.doan.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.uiapp.doan.interactor.api.response.BaseResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongnhung on 11/3/16.
 */

//Order dua vao
public class Order extends BaseResponse {

    @SerializedName("_id")
    @Expose
    private String id;

    @SerializedName("accountKH")
    @Expose
    private String accountKH;

    public String getAccountKH() {
        return accountKH;
    }

    public void setAccountKH(String accountKH) {
        this.accountKH = accountKH;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("ngaydatyeucau")
    @Expose
    private String ngaydatyeucau;

    @SerializedName("tenkhuvuc")
    @Expose
    private String tenkhuvuc;

    public String getTenkhuvuc() {
        return tenkhuvuc;
    }

    public void setTenkhuvuc(String tenkhuvuc) {
        this.tenkhuvuc = tenkhuvuc;
    }

    @SerializedName("mayc")
    @Expose
    private String mayc;
    // quan lam
    @SerializedName("quan")
    @Expose
    private String quan;
    @SerializedName("ngaylam")
    @Expose
    private String ngaylam;
    @SerializedName("trangthai")
    @Expose
    private String trangthai;
    @SerializedName("hotenTho")
    @Expose
    private String hotenTho;
    @SerializedName("cmndTho")
    @Expose
    private String cmndTho;
    @SerializedName("hotenKH")
    @Expose
    private String hotenKH;
    @SerializedName("sodt")
    @Expose
    private String sodt;

    // dia chi cua khach hang
    @SerializedName("diachi")
    @Expose
    private String diachi;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("sdtTho")
    @Expose
    private String sdtTho;
    @SerializedName("giobatdau")
    @Expose
    private String giobatdau;
    @SerializedName("gioketthuc")
    @Expose
    private String gioketthuc;
    @SerializedName("phidichvu")
    @Expose
    private String phidichvu;
    @SerializedName("__v")
    @Expose
    private String v;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("dichvuyc")
    @Expose
    private List<String> dichvuyc = new ArrayList<String>();


    @SerializedName("nhanxet")
    @Expose
    private String nhanxet;



    public String getNhanxet() {
        return nhanxet;
    }

    public void setNhanxet(String nhanxet) {
        this.nhanxet = nhanxet;
    }

    /**
     *
     * @return
     * The ngaydatyeucau
     */
    public String getNgaydatyeucau() {
        return ngaydatyeucau;
    }

    /**
     *
     * @param ngaydatyeucau
     * The ngaydatyeucau
     */
    public void setNgaydatyeucau(String ngaydatyeucau) {
        this.ngaydatyeucau = ngaydatyeucau;
    }

    /**
     *
     * @return
     * The mayc
     */
    public String getMayc() {
        return mayc;
    }

    /**
     *
     * @param mayc
     * The mayc
     */
    public void setMayc(String mayc) {
        this.mayc = mayc;
    }

    /**
     *
     * @return
     * The quan
     */
    public String getQuan() {
        return quan;
    }

    /**
     *
     * @param quan
     * The quan
     */
    public void setQuan(String quan) {
        this.quan = quan;
    }

    /**
     *
     * @return
     * The ngaylam
     */
    public String getNgaylam() {
        return ngaylam;
    }

    /**
     *
     * @param ngaylam
     * The ngaylam
     */
    public void setNgaylam(String ngaylam) {
        this.ngaylam = ngaylam;
    }

    /**
     *
     * @return
     * The trangthai
     */
    public String getTrangthai() {
        return trangthai;
    }

    /**
     *
     * @param trangthai
     * The trangthai
     */
    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    /**
     *
     * @return
     * The hotenTho
     */
    public String getHotenTho() {
        return hotenTho;
    }

    /**
     *
     * @param hotenTho
     * The hotenTho
     */
    public void setHotenTho(String hotenTho) {
        this.hotenTho = hotenTho;
    }

    /**
     *
     * @return
     * The cmndTho
     */
    public String getCmndTho() {
        return cmndTho;
    }

    /**
     *
     * @param cmndTho
     * The cmndTho
     */
    public void setCmndTho(String cmndTho) {
        this.cmndTho = cmndTho;
    }

    /**
     *
     * @return
     * The hotenKH
     */
    public String getHotenKH() {
        return hotenKH;
    }

    /**
     *
     * @param hotenKH
     * The hotenKH
     */
    public void setHotenKH(String hotenKH) {
        this.hotenKH = hotenKH;
    }

    /**
     *
     * @return
     * The sodt
     */

    /**
     *
     * @return
     * The diachi
     */
    public String getDiachi() {
        return diachi;
    }

    /**
     *
     * @param diachi
     * The diachi
     */
    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    /**
     *
     * @return
     * The mota
     */
    public String getMota() {
        return mota;
    }

    /**
     *
     * @param mota
     * The mota
     */
    public void setMota(String mota) {
        this.mota = mota;
    }

    /**
     *
     * @return
     * The sdtTho
     */
    public String getSdtTho() {
        return sdtTho;
    }

    /**
     *
     * @param sdtTho
     * The sdtTho
     */
    public void setSdtTho(String sdtTho) {
        this.sdtTho = sdtTho;
    }

    /**
     *
     * @return
     * The giobatdau
     */

    /**
     *
     * @return
     * The gioketthuc
     */




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
     * The dichvuyc
     */
    public List<String> getDichvuyc() {
        return dichvuyc;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getGiobatdau() {
        return giobatdau;
    }

    public void setGiobatdau(String giobatdau) {
        this.giobatdau = giobatdau;
    }

    public String getGioketthuc() {
        return gioketthuc;
    }

    public void setGioketthuc(String gioketthuc) {
        this.gioketthuc = gioketthuc;
    }

    public String getPhidichvu() {
        return phidichvu;
    }

    public void setPhidichvu(String phidichvu) {
        this.phidichvu = phidichvu;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    /**
     *
     * @param dichvuyc
     * The dichvuyc
     */
    public void setDichvuyc(List<String> dichvuyc) {
        this.dichvuyc = dichvuyc;
    }

}
