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
public class DrugHandler {

    //declare
    private ArrayList<Drug> drugs;

    //constructor
    public DrugHandler() {
        drugs = new ArrayList<>();
    }

    //add default contries to arrayList
    public void setDefaults() {
        drugs.add(new Drug("Cocaine", new OldMemory()));
        drugs.add(new Drug("Heroin", new TenProcent()));//dette er basePrice
        drugs.add(new Drug("Amphetamine", new CompletelyRandom()));
        drugs.add(new Drug("Acid", new CompletelyRandom()));
        drugs.add(new Drug("Angel dust", new OneOfTen()));
        drugs.add(new Drug("Crystal Meth", 800, 38));
        drugs.add(new Drug("Hash", new SimpleTwoChoise()));
        drugs.add(new Drug("Weed", new OneOfTen()));
        drugs.add(new Drug("Mushrooms:", new SecondsClock()));
        drugs.add(new Drug("Valium", 290, 80));

    }

    /**
     * *
     *denne metode "opretter plads" til at player kan opbevare de forskellige stoffer han køber
     */
    public void setPlayerDefaults() {
        drugs.add(new Drug("Cocaine", new PlayerPackages()));
        drugs.add(new Drug("Heroin", new PlayerPackages()));
        drugs.add(new Drug("Amphetamine", new PlayerPackages()));
        drugs.add(new Drug("Acid", new PlayerPackages()));
        drugs.add(new Drug("Angel dust", new PlayerPackages()));
        drugs.add(new Drug("Crystal Meth", new PlayerPackages()));
        drugs.add(new Drug("Hash", new PlayerPackages()));
        drugs.add(new Drug("Weed", new PlayerPackages()));
        drugs.add(new Drug("Mushrooms:", new PlayerPackages()));
        drugs.add(new Drug("Valium", new PlayerPackages()));
    }

    public ArrayList<Drug> getDrugs() {
        return drugs;
    }

    public String[] getDrugsAsArray() {
        String[] temp = new String[drugs.size()];

        for (int i = 0; i < drugs.size(); i++) {
            temp[i] = drugs.get(i).toString();
        }
        return temp;
    }

    public int getPrice(String name) {
        return drugs.get(getIndex(name)).getPrice();
    }

    public boolean addPackages(String name, int packages) {
        int index = getIndex(name);

        //denne if-sætning sørger for at ændre antallet af packages hvis navnet på stoffet allerede eksisterer
        if (index != -1) {
            drugs.get(index).addPackages(packages);
            return true;

        } else {

            return false;
        }
    }

    /**
     * *
     * denne metode tjekker pom navnet eksisterer, og fjerner kun antal hvis det
     * gør. hvis alle stoffets pakker sælges på en gang, så fjernes hele navnet
     * på stoffet
     *
     * @param drug
     * @return
     */
    public boolean removePackages(String name, int packages) {
        int index = getIndex(name);

        if (index != -1) {
            //Hvis navnet allerede eksisterer, så fjernes det antal der skal sælgess
            if (drugs.get(index).getPackages() > packages) {

                drugs.get(index).removePackages(packages);

                //hvis denne betingelse udføres, kan player sælge drugs
                return true;
            } else if (drugs.get(index).getPackages() == packages) {
                drugs.remove(index);
                //hvis denne betingelse udføres, kan player sælge drugs
                return true;
            } else {
                System.out.println("You FAIL, LOOSER!");
            }
        }
        return false;

    }

    /**
     * Denne metode returnerer index udfra navn
     *
     * @param name
     * @return index
     */
    private int getIndex(String name) {
        int index = -1;
        //denne if-sætning tjekker om navnet man prøver at fjerne allerede eksisterer
        //break stopper for-loopen hvis navnet findes
        for (int i = 0; i < drugs.size(); i++) {
            if (drugs.get(i).getName().equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }

}
