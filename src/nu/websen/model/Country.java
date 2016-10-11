/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.websen.model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author MENJA
 */
public class Country {

    //declare
    private String name;
    private DrugHandler dh;
    private Random rand;

    //constructor
    public Country(String name) {
        this.name = name;
        dh = new DrugHandler();
        dh.setDefaults();
        rand = new Random();
    }

    //getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DrugHandler getDh() {
        return dh;
    }

    public void setDh(DrugHandler dh) {
        this.dh = dh;
    }

    public int getPrice(String name) {
        return dh.getPrice(name);
    }

    public void randomStrategy() {
        for (Drug drug : dh.getDrugs()) {
            drug.strategy();
        }
    }

    public String[] getDrugsAsArray() {

        return dh.getDrugsAsArray();
    }

    /**
     * *
     * her køber landet stoffer af player. stofferne tilføjes til landet
     */
    public boolean buyDrug(String name, int packages) {
        return dh.addPackages(name, packages);
    }

    /**
     * *
     * her køber player stoffer af landet, stofferne trækkes fra landet
     */
    public boolean sellDrug(String name, int packages) {

        return dh.removePackages(name, packages);

    }
}
