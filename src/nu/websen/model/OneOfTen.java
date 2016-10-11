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
public class OneOfTen implements PriceInterface {

    private int packages;
    private int price;

    private Random rand;

    private int[] packagesArray;
    private int[] priceArray;

    public OneOfTen() {
        rand = new Random();
        packagesArray = new int[]{100, 190, 200000, 2, 95, 30, 165, 185, 250};
        priceArray = new int[]{150, 230, 180, 2350, 17, 360, 190, 440, 550};
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
        packages = packagesArray[rand.nextInt(packagesArray.length )];
        price = priceArray[rand.nextInt(priceArray.length)];
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
