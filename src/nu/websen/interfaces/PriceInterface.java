/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.websen.interfaces;

/**
 *
 * @author MENJA
 */
public interface PriceInterface {

    /**
     * *
     * Get packages
     *
     * @return
     */
    int getPackages();

    /**
     * *
     * getPrice
     *
     * @return
     */
    int getPrice();

    /**
     * *
     * make strategy
     */
    void strategy();

    /**
     *
     * @param packages
     */
    void addPackages(int packages);

    /**
     * @param packages
     * @return
     */
    boolean removePackages(int packages);
}
