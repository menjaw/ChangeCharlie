/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.websen.controller;

import java.util.ArrayList;
import nu.websen.model.CountryHandler;
import nu.websen.model.Drug;
import nu.websen.model.FileHandler;
import nu.websen.model.Player;

/**
 *
 * @author MENJA
 */
public class GameController {

    private FileHandler fh;
    private ArrayList<String> highScores;
    public CountryHandler ch;
    public Player player;
    private int turns;

    //constructor som initialiserer objekter
    public GameController() {
        fh = new FileHandler();
        fh.setFile("Hightscores.txt");
        load();
        ch = new CountryHandler();
        player = new Player();
    }

    /**
     * *
     * Returnerer det aktuelle land
     */
    public String getCurrentCountry() {
        return ch.getCurrentCountry();
    }

    public String[] getCurrentCountryDrugsAsArray() {

        return ch.getCurrentCountryDrugsAsArray();
    }

    /**
     * *
     * Denne metode sørger for det er muligt at rejse fra land til land
     *
     * @param name
     */
    public void travelTo(String name) {
        ch.travelTo(name);
        ch.randomStrategy();
        turns++;
    }

    /**
     * *
     * returnerer players name
     */
    public String getName() {
        return player.getName();
    }

    /**
     * *
     * Returnerer players cash
     */
    public int getCash() {
        return player.getCash();
    }

    /**
     * *
     *
     * @param drug
     */
    public Boolean buyDrug(String name, int packages) {
        int price = ch.getPrice(name);

        boolean p = player.buyDrug(name, price, packages);
        boolean c = ch.sellDrug(name, packages);

        return p && c;

    }

    /**
     * *
     *
     * @param drug
     */
    public Boolean sellDrug(String name, int packages) {
        int price = ch.getPrice(name);

        boolean p = player.sellDrug(name, price, packages);
        boolean c = ch.buyDrug(name, packages);

        return p && c;
    }

    /**
     * *
     *
     * @param filename
     * @return
     */
    public void load() {
        highScores = fh.loadFile();
    }

    /**
     * @param filename
     * @return
     */
    public void save() {
        highScores.add(player.getName() + ", " + player.getCash());
        fh.saveFile(highScores);
    }

    public String[] getOtherCountries() {

        return ch.getOtherCountries();
    }

    public String[] getPlayerDrugs() {
        return player.getDrugsAsArray();
    }
}
