package com.sy.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "orderform")
public class Orderform implements Serializable {
    private Integer orderid;
    private String bridegroom;
    private String bride;
    private String shopname;
    private String tel;
    private LocalDate orderTime;
    private LocalDate photoTime;
    private LocalDate weddingTime;
    private LocalDate takeTime;
    private String photographer;
    private String remarks;
    private String state;
    private Integer memberId;

    @Id
    @Column(name = "orderid", nullable = false)
    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "bridegroom", nullable = true, length = 255)
    public String getBridegroom() {
        return bridegroom;
    }

    public void setBridegroom(String bridegroom) {
        this.bridegroom = bridegroom;
    }

    @Basic
    @Column(name = "bride", nullable = true, length = 255)
    public String getBride() {
        return bride;
    }

    public void setBride(String bride) {
        this.bride = bride;
    }

    @Basic
    @Column(name = "shopname", nullable = true, length = 255)
    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 255)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "orderTime", nullable = true)
    public LocalDate getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDate orderTime) {
        this.orderTime = orderTime;
    }

    @Basic
    @Column(name = "photoTime", nullable = true)
    public LocalDate getPhotoTime() {
        return photoTime;
    }

    public void setPhotoTime(LocalDate photoTime) {
        this.photoTime = photoTime;
    }

    @Basic
    @Column(name = "weddingTime", nullable = true)
    public LocalDate getWeddingTime() {
        return weddingTime;
    }

    public void setWeddingTime(LocalDate weddingTime) {
        this.weddingTime = weddingTime;
    }

    @Basic
    @Column(name = "takeTime", nullable = true)
    public LocalDate getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(LocalDate takeTime) {
        this.takeTime = takeTime;
    }

    @Basic
    @Column(name = "photographer", nullable = true, length = 255)
    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    @Basic
    @Column(name = "remarks", nullable = true, length = 255)
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "state", nullable = true, length = 255)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "memberId", nullable = true)
    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orderform orderform = (Orderform) o;
        return Objects.equals(orderid, orderform.orderid) &&
                Objects.equals(bridegroom, orderform.bridegroom) &&
                Objects.equals(bride, orderform.bride) &&
                Objects.equals(shopname, orderform.shopname) &&
                Objects.equals(tel, orderform.tel) &&
                Objects.equals(orderTime, orderform.orderTime) &&
                Objects.equals(photoTime, orderform.photoTime) &&
                Objects.equals(weddingTime, orderform.weddingTime) &&
                Objects.equals(takeTime, orderform.takeTime) &&
                Objects.equals(photographer, orderform.photographer) &&
                Objects.equals(remarks, orderform.remarks) &&
                Objects.equals(state, orderform.state) &&
                Objects.equals(memberId, orderform.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderid, bridegroom, bride, shopname, tel, orderTime, photoTime, weddingTime, takeTime, photographer, remarks, state, memberId);
    }

    @Override
    public String toString() {
        return "Orderform{" +
                "orderid=" + orderid +
                ", bridegroom='" + bridegroom + '\'' +
                ", bride='" + bride + '\'' +
                ", shopname='" + shopname + '\'' +
                ", tel='" + tel + '\'' +
                ", orderTime=" + orderTime +
                ", photoTime=" + photoTime +
                ", weddingTime=" + weddingTime +
                ", takeTime=" + takeTime +
                ", photographer='" + photographer + '\'' +
                ", remarks='" + remarks + '\'' +
                ", state='" + state + '\'' +
                ", memberId=" + memberId +
                '}';
    }
}
