package com.sy.vo;

import com.sy.entity.Moneymanager;

import java.math.BigDecimal;
import java.util.List;

//统计信息
public class MonaymanagerInfo {

    //收银流水集合
    private List<Moneymanager> moneymanagerList;

    //销售额
    private BigDecimal income;

    //以收实款
    private BigDecimal receivables;

    //余款
    private BigDecimal balance;

    //支出
    private BigDecimal expenditure;

    //订单数
    private Integer ordernum;

    //利润
    private BigDecimal profit;

    //月份
    private Integer month;

    //年份
    private Integer year;


    public BigDecimal getReceivables() {
        return receivables;
    }

    public void setReceivables(BigDecimal receivables) {
        this.receivables = receivables;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "MonaymanagerInfo{" +
                "moneymanagerList=" + moneymanagerList +
                ", income=" + income +
                ", receivables=" + receivables +
                ", balance=" + balance +
                ", expenditure=" + expenditure +
                ", ordernum=" + ordernum +
                ", profit=" + profit +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    public List<Moneymanager> getMoneymanagerList() {
        return moneymanagerList;
    }

    public void setMoneymanagerList(List<Moneymanager> moneymanagerList) {
        this.moneymanagerList = moneymanagerList;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(BigDecimal expenditure) {
        this.expenditure = expenditure;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}
