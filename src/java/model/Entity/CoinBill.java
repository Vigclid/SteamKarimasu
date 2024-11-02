/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Entity;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class CoinBill {
    private String CoinBillId, StatusBill;
    private int UserId;
    private LocalDate DateOfCrate;
    private Float currency;

    public CoinBill(String coinBillId, int userId, LocalDate dateOfCrate, Float currency, String statusBill) {
        CoinBillId = coinBillId;
        StatusBill = statusBill;
        UserId = userId;
        DateOfCrate = dateOfCrate;
        this.currency = currency;
    }
    public CoinBill (){

    }

    public String getCoinBillId() {
        return CoinBillId;
    }

    public void setCoinBillId(String coinBillId) {
        CoinBillId = coinBillId;
    }

    public String getStatusBill() {
        return StatusBill;
    }

    public void setStatusBill(String statusBill) {
        StatusBill = statusBill;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public LocalDate getDateOfCrate() {
        return DateOfCrate;
    }

    public void setDateOfCrate(LocalDate dateOfCrate) {
        DateOfCrate = dateOfCrate;
    }

    public Float getCurrency() {
        return currency;
    }

    public void setCurrency(Float currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "CoinBill{" +
                "CoinBillId='" + CoinBillId + '\'' +
                ", StatusBill='" + StatusBill + '\'' +
                ", UserId=" + UserId +
                ", DateOfCrate=" + DateOfCrate +
                ", currency=" + currency +
                '}';
    }
}
