/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author rafael
 */
public class ItemPurchased implements Serializable {

    private String location;
    private double value;

    public ItemPurchased(String location, double value) {
        this.location = location;
        this.value = value;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ItemPurchased:" + " Local: " + location + ", Valor: R$" + value + "\n";
    }

}
