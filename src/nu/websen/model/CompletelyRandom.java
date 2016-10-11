/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.websen.model;

import java.util.Random;
import nu.websen.interfaces.PriceInterface;

/**
 *
 * @author MENJA
 */
public class CompletelyRandom implements PriceInterface{
    private int packages;
    private int price;
    private Random rand; 

    //constructor
    public CompletelyRandom() {
        rand = new Random();
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

    @Override
    public void strategy() {   
        price =  rand.nextInt(12000)+10;
        packages = rand.nextInt(400)+2;    
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
