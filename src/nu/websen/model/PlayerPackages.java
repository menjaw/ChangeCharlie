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
public class PlayerPackages implements PriceInterface {

    private int packages;

    //constructor 
    public PlayerPackages() {
        packages = 0;
    }

    @Override
    public int getPackages() {
        return packages;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public void strategy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
