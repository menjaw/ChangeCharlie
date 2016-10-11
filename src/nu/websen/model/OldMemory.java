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
public class OldMemory implements PriceInterface{
    private int price;
    private int packages;
    private Random rand;
    private boolean firstTime;
    
    
    //constructor   
    public OldMemory() {
        price = 1000;
        packages = 100;
        rand = new Random();
        firstTime = true;
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
        int flatPrice = 17;
        int flatPackages = 13;
        int flatModifier = 25;
        
        //dette er priserne og pakkerne første gang 
        if (firstTime) {
            flatPrice = 75;
            flatPackages = 7;
            flatModifier = 55;
            firstTime = false;
        }
        
        int modifier = rand.nextInt(flatModifier)+ 10;
        if (rand.nextBoolean()) {
            price += (price * modifier)/100;
            packages += (packages * modifier)/100;
        }
        else{
            price -= (price * modifier)/100;
            packages -= (packages * modifier)/100;
        }
        
        price += flatPrice;
        packages += flatPackages;
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
