package com.sy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Outlay")
public class Outlay implements Serializable {
    private Integer id;
    private String outlayname;
    private BigDecimal outlayprice;
    private BigDecimal estimate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String description;
    private Integer shopid;

    @Column(name = "shopid", nullable = false)
    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "estimate", nullable = false)
    public BigDecimal getEstimate() {
        return estimate;
    }

    public void setEstimate(BigDecimal estimate) {
        this.estimate = estimate;
    }

    @Basic
    @Column(name = "outlayname", nullable = true, length = 255)
    public String getOutlayname() {
        return outlayname;
    }

    public void setOutlayname(String outlayname) {
        this.outlayname = outlayname;
    }

    @Basic
    @Column(name = "outlayprice", nullable = true, precision = 2)
    public BigDecimal getOutlayprice() {
        return outlayprice;
    }

    public void setOutlayprice(BigDecimal outlayprice) {
        this.outlayprice = outlayprice;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outlay outlay = (Outlay) o;
        return Objects.equals(id, outlay.id) &&
                Objects.equals(outlayname, outlay.outlayname) &&
                Objects.equals(outlayprice, outlay.outlayprice) &&
                Objects.equals(date, outlay.date) &&
                Objects.equals(description, outlay.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, outlayname, outlayprice, date, description);
    }

    @Override
    public String toString() {
        return "Outlay{" +
                "id=" + id +
                ", outlayname='" + outlayname + '\'' +
                ", outlayprice=" + outlayprice +
                ", estimate=" + estimate +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
