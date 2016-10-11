/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.websen.model;

import java.util.Calendar;
import java.util.TimeZone;
import nu.websen.interfaces.PriceInterface;

/**
 *
 * @author MENJA
 */
public class SecondsClock implements PriceInterface {

    private int price;
    private int packages;

    public SecondsClock() {
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
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        int sec = cal.get(Calendar.SECOND);
        if (sec == 0) {
            sec++;
        }
        price = (sec * 2);
        packages = sec;
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
