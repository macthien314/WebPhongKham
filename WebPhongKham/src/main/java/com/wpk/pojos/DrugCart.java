/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.pojos;

import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
public class DrugCart {
    private int drugID;
    private String drugName;
    private String userGuide;
    private int quantity;

    public DrugCart() {
    }

 
    
    /**
     * @return the drugID
     */
    public int getDrugID() {
        return drugID;
    }

    /**
     * @param drugID the drugID to set
     */
    public void setDrugID(int drugID) {
        this.drugID = drugID;
    }

    /**
     * @return the drugName
     */
    public String getDrugName() {
        return drugName;
    }

    /**
     * @param drugName the drugName to set
     */
    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    /**
     * @return the price
     */
 

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the userGuide
     */
    public String getUserGuide() {
        return userGuide;
    }

    /**
     * @param userGuide the userGuide to set
     */
    public void setUserGuide(String userGuide) {
        this.userGuide = userGuide;
    }
}
