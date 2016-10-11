/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.websen.model;

import java.util.ArrayList;

/**
 *
 * @author MENJA
 */
public class Player {

    //Declare
    private String name;
    private int cash;
    private DrugHandler dh;

    //constructor
    public Player() {
        name = "Peter the Gangster";
        cash = 5000;
        dh = new DrugHandler();

        dh.setPlayerDefaults();
    }

    //getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public DrugHandler getDh() {
        return dh;
    }

    public void setDh(DrugHandler dh) {
        this.dh = dh;
    }

    public String[] getDrugsAsArray() {
        return dh.getDrugsAsArray();
    }

    public boolean buyDrug(String name, int price, int packages) {
        int drugCost = price * packages;
        if (drugCost < cash) {
            cash -= drugCost;
            return dh.addPackages(name, packages);

        } else {
            System.out.println("You can't afford these drugs, little junkie-traveller");
            return false;
        }
    }

    public boolean sellDrug(String name, int price, int packages) {
        boolean b = dh.removePackages(name, packages);
        if (b) {

            //her gemmes profitten i playerens cash-variabel
            cash += price * packages;
        }
        return b;
    }
}
