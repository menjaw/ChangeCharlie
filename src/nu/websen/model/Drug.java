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
public class Drug {

    //declare
    private String name;
    private PriceInterface pricePackage;

    //constructor
    public Drug(String name, int price, int packages) {
        this.name = name;
        this.pricePackage = new BasePrice(price, packages);
    }
//constructor

    public Drug(String name, PriceInterface pricePackage) {
        this.name = name;
        this.pricePackage = pricePackage;
    }

    //getter and setter som gør det muligt at flytte rundt på dataen
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return pricePackage.getPrice();
    }

    public int getPackages() {
        return pricePackage.getPackages();
    }

    public void strategy() {
        pricePackage.strategy();
    }

    public void addPackages(int packages) {
        pricePackage.addPackages(packages);
    }

    public boolean removePackages(int packages) {
        return pricePackage.removePackages(packages);
    }

    @Override
    public String toString() {
        return name + ";" + pricePackage.getPrice() + ";" + pricePackage.getPackages();
    }
    
    
}
