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
public class BasePrice implements PriceInterface {

    private int price;
    private int packages;
    private Random rand;

    public BasePrice(int price, int packages) {
        rand = new Random();
        this.price = price;
        this.packages = packages;
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
        updatePrice();
        updatePackages();
    }

    /**
     * *
     * Denne metode udregner en tilfældig pris med de kriterier som gælder for
     * salg og køb af produkter og bruges kun i Country klassen
     *
     * @param drug
     */
    private void updatePrice() {
        if (rand.nextInt(100) < 65) {
            int modifier = rand.nextInt(85) + 1;

            if (rand.nextBoolean()) {
                price += (price * modifier) / 100;
            } else {
                price -= (price * modifier) / 100;
            }

        }
    }

    /**
     * *
     * Denne metode udregner et tilfældigt antal pakker af produktet og bruges
     * kun i denne Country klassen
     *
     * @param drug
     */
    private void updatePackages() {
        if (rand.nextInt(100) < 65) {
            int modifier = rand.nextInt(40) + 15;

            if (packages < 10) {
                packages += 10;
            }

            if (rand.nextBoolean()) {
                packages += (packages * modifier) / 100;
            } else {
                packages -= (packages * modifier) / 100;
            }

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
