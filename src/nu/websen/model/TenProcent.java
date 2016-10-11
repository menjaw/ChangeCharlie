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
public class TenProcent implements PriceInterface {

    private int price;
    private int packages;

    //constructor
    public TenProcent() {
        packages = 40;
        price = 180;
    }

    @Override
    public int getPackages() {
        return packages;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void strategy() {
        price = (int) (price * 1.1);
        packages = (int) (packages * 1.1);
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
