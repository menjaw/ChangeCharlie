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
public class CountryHandler {

    //declare
    private ArrayList<Country> countries;
    private Country currentCountry;

    //constructor
    public CountryHandler() {
        countries = new ArrayList<>();
        setDefaults();
    }

    //set deafult
    private void setDefaults() {
        currentCountry = new Country("Denmark");
        countries.add(currentCountry);
        countries.add(new Country("Colombia"));
        countries.add(new Country("Germany"));
        countries.add(new Country("USA"));
        countries.add(new Country("France"));
        countries.add(new Country("Afghanistan"));
    }

    public void randomStrategy() {
        for (Country country : countries) {
            country.randomStrategy();
        }
    }

    public String getCurrentCountry() {
        return currentCountry.getName();
    }

    public void travelTo(String name) {
        for (Country country : countries) {
            if (country.getName().equals(name)) {
                currentCountry = country;
                break;
            }
        }
    }

    public int getPrice(String name) {
        return currentCountry.getPrice(name);
    }

    public boolean buyDrug(String name, int packages) {
        return currentCountry.buyDrug(name, packages);
    }

    //sender det til currentCountry
    public boolean sellDrug(String name, int packages) {
        return currentCountry.sellDrug(name, packages);
    }

    public ArrayList<Drug> getCurrentCountryDrugs() {
        return currentCountry.getDh().getDrugs();
    }

    public String[] getOtherCountries() {

        String[] countryNames = new String[countries.size() - 1];

        int i = 0;
        for (Country country : countries) {
            if (!currentCountry.getName().equalsIgnoreCase(country.getName())) {
                countryNames[i] = country.getName();
                i++;
            }
        }
        return countryNames;
    }

        public String[] getCurrentCountryDrugsAsArray(){
        return currentCountry.getDrugsAsArray();
        }
}
