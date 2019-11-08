package com.sy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Moneymanager")
public class Moneymanager implements Serializable {
    private Integer id;
    private Integer orderid;
    private BigDecimal price;
    private Integer discount;
    private BigDecimal realprice;
    private BigDecimal frontmoney;
    private BigDecimal balancemoney;
    private String remarks;
    private BigDecimal latermoney;
    private BigDecimal refund;
    private BigDecimal realincome;
    private BigDecimal givechange;
    private String state;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate laterTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate refundTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate frontTime;
    private Integer type;
    private Integer paytype;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "orderid")
    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "realprice")
    public BigDecimal getRealprice() {
        return realprice;
    }

    public void setRealprice(BigDecimal realprice) {
        this.realprice = realprice;
    }

    @Basic
    @Column(name = "realincome")
    public BigDecimal getRealincome() {
        return realincome;
    }

    public void setRealincome(BigDecimal realincome) {
        this.realincome = realincome;
    }

    @Basic
    @Column(name = "givechange")
    public BigDecimal getGivechange() {
        return givechange;
    }

    public void setGivechange(BigDecimal givechange) {
        this.givechange = givechange;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "discount", nullable = true)
    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "frontmoney", nullable = true, precision = 2)
    public BigDecimal getFrontmoney() {
        return frontmoney;
    }

    public void setFrontmoney(BigDecimal frontmoney) {
        this.frontmoney = frontmoney;
    }

    @Basic
    @Column(name = "balancemoney", nullable = true, precision = 2)
    public BigDecimal getBalancemoney() {
        return balancemoney;
    }

    public void setBalancemoney(BigDecimal balancemoney) {
        this.balancemoney = balancemoney;
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
    @Column(name = "latermoney", nullable = true, precision = 2)
    public BigDecimal getLatermoney() {
        return latermoney;
    }

    public void setLatermoney(BigDecimal latermoney) {
        this.latermoney = latermoney;
    }

    @Basic
    @Column(name = "refund", nullable = true, precision = 2)
    public BigDecimal getRefund() {
        return refund;
    }

    public void setRefund(BigDecimal refund) {
        this.refund = refund;
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
    @Column(name = "laterTime", nullable = true)
    public LocalDate getLaterTime() {
        return laterTime;
    }

    public void setLaterTime(LocalDate laterTime) {
        this.laterTime = laterTime;
    }

    @Basic
    @Column(name = "refundTime", nullable = true)
    public LocalDate getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(LocalDate refundTime) {
        this.refundTime = refundTime;
    }

    @Basic
    @Column(name = "frontTime", nullable = true)
    public LocalDate getFrontTime() {
        return frontTime;
    }

    public void setFrontTime(LocalDate frontTime) {
        this.frontTime = frontTime;
    }

    @Basic
    @Column(name = "type", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "paytype", nullable = true)
    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Moneymanager)) return false;
        Moneymanager that = (Moneymanager) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getOrderid(), that.getOrderid()) &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getDiscount(), that.getDiscount()) &&
                Objects.equals(getFrontmoney(), that.getFrontmoney()) &&
                Objects.equals(getBalancemoney(), that.getBalancemoney()) &&
                Objects.equals(getRemarks(), that.getRemarks()) &&
                Objects.equals(getLatermoney(), that.getLatermoney()) &&
                Objects.equals(getRefund(), that.getRefund()) &&
                Objects.equals(getRealincome(), that.getRealincome()) &&
                Objects.equals(getGivechange(), that.getGivechange()) &&
                Objects.equals(getState(), that.getState()) &&
                Objects.equals(getLaterTime(), that.getLaterTime()) &&
                Objects.equals(getRefundTime(), that.getRefundTime()) &&
                Objects.equals(getFrontTime(), that.getFrontTime()) &&
                Objects.equals(getType(), that.getType()) &&
                Objects.equals(getPaytype(), that.getPaytype());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOrderid(), getPrice(), getDiscount(), getFrontmoney(), getBalancemoney(), getRemarks(), getLatermoney(), getRefund(), getRealincome(), getGivechange(), getState(), getLaterTime(), getRefundTime(), getFrontTime(), getType(), getPaytype());
    }

    @Override
    public String toString() {
        return "Moneymanager{" +
                "id=" + id +
                ", orderid=" + orderid +
                ", price=" + price +
                ", discount=" + discount +
                ", realprice=" + realprice +
                ", frontmoney=" + frontmoney +
                ", balancemoney=" + balancemoney +
                ", remarks='" + remarks + '\'' +
                ", latermoney=" + latermoney +
                ", refund=" + refund +
                ", realincome=" + realincome +
                ", givechange=" + givechange +
                ", state='" + state + '\'' +
                ", laterTime=" + laterTime +
                ", refundTime=" + refundTime +
                ", frontTime=" + frontTime +
                ", type=" + type +
                ", paytype=" + paytype +
                '}';
    }
}
