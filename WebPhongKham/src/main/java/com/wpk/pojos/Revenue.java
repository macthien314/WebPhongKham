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
public class Revenue implements Comparable<Revenue> {
    private int month;
    private int year;
    
    private BigDecimal price;
    
    public Revenue(){
    
    }
    public Revenue(int month, int year){
        this.month = month;
        this.year = year;
    }
    public Revenue(int month, int year, BigDecimal price){
        this.month = month;
        this.year = year;
        this.price = price;
    }
    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    


    @Override
    public boolean equals(Object obj) {
        Revenue r = (Revenue) obj;
        if(this.month == r.getMonth() && this.year == r.getYear())
            return true;
        return false;
    }

   

    @Override
    public int compareTo(Revenue o) {
        if(this.year > o.year)
            return 1;
        else if(this.year == o.year){
                if(this.month == o.getMonth())
                    return 0;
                if(this.month < o.getMonth())
                    return -1;
                if(this.month > o.getMonth())
                    return 1;
             }
        return -1;
    }
    
}
