/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.utils;

/**
 *
 * @author Admin
 */
public class util {
    public static boolean isNumeric(String string) {
    int intValue;
		
    System.out.println(String.format("Parsing string: \"%s\"", string));
		
    if(string == null || string.equals("")) {
        System.out.println("String cannot be parsed, it is null or empty.");
        return false;
    }
    
    try {
        intValue = Integer.parseInt(string);
        return true;
    } catch (NumberFormatException e) {
        System.out.println("Input String cannot be parsed to Integer.");
    }
    return false;
}
}
