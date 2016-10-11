/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.websen.model;

import nu.websen.interfaces.PriceInterface;

/**
 *
 * @author MENJA
 */
public class SimpleTwoChoise implements PriceInterface {

    private int price;
    private int packages;
    private boolean change;

    public SimpleTwoChoise() {
        change = false;
        strategy();
    }

    @Override
    public int getPackages() {
        return packages;
    }

    @Override
    public int getPrice() {
        return price;
    }

    /**
     * *
     * Start with the White Price & Amount and then simply switch to the other
     * price every turn.
     */
    @Override
    public void strategy() {
        int whitePackages = 50;
        int blackPackages = 180;
        int whitePrice = 90;
        int blackPrice = 300;

        if (change) {
            price = blackPrice;
            packages = blackPackages;
            change = false;
        } else {
            price = whitePrice;
            packages = whitePackages;
            change = true;
        }

    }

    @Override
    public void addPackages(int packages) {
        this.packages += packages; 
    }

    @Override
    public boolean removePackages(int packages) {
        if (this.packages >= packages) {
            this.packages -= packages;
            return true;
        }
        return false;
    }

}
