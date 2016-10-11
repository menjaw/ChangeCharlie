/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.websen.view;

import java.util.ArrayList;
import java.util.Scanner;
import nu.websen.controller.GameController;
import nu.websen.model.Drug;

/**
 *
 * @author MENJA
 */
public class Main {

    private static GameController gc;
    private static Scanner scanner;

    public static void main(String[] args) {
        gc = new GameController();
        scanner = new Scanner(System.in);
        game();
        gc.save();
        showHighScores();
    }

    private static void showHighScores() {
        // Print out all highScores and highlight the current players highScore
    }

    /**
     * Start the game!
     */
    private static void game() {
        System.out.println("Gangster Game! Welcome Peter the gangster!");

        System.out.println("Type 'm' to get the menu");

        while (!gameMenu()) {
//            if (gc.gameHasEnded()) {
//                break;
//            }
        }
    }

    /**
     * Shows the player stats such as his cash, and friends in high places
     * maybe.
     */
    private static void showPlayerStats() {
        System.out.println("Player stats:");
    }

    /**
     * Shows the player his drugs.
     */
    private static void showPlayerDrugs() {
        System.out.println("Player drugs:");
        ArrayList<Drug> tempDrugs = gc.player.getDh().getDrugs();
        String[] drugs = new String[tempDrugs.size()];

        int i = 0;
        for (Drug drug : tempDrugs) {
            drugs[i] = drug.toString();
            i++;
        }

        String drugsText = prettifyDrugs(drugs);
        System.out.println(drugsText);
    }

    /**
     * Shows the currentCountry's drugs
     */
    private static void showCurrentCountryDrugs() {
        System.out.println(gc.getCurrentCountry() + " drugs:");
        ArrayList<Drug> tempDrugs = gc.ch.getCurrentCountryDrugs();
        String[] drugs = new String[tempDrugs.size()];

        int i = 0;
        for (Drug drug : tempDrugs) {
            drugs[i] = drug.toString();
            i++;
        }

        String drugsText = prettifyDrugs(drugs);
        System.out.println(drugsText);
    }

    /**
     * Handles the purchase of drugs.
     */
    private static void buyDrugs() {
        System.out.println("Buy drugs:");
        String[] drugs = gc.getCurrentCountryDrugsAsArray();
        System.out.println(prettifyDrugs(drugs, true));

        String name = getDrugName("Select a drug:", drugs);
        int packages = getInt("Enter Amount of " + name + ", that you want:", 1,
                drugs.length);

        if (gc.buyDrug(name, packages)) {
            System.out.println("You successfully bought: " + name + ", "
                    + packages);
            System.out.println("You now have: " + gc.getCash() + " in cash");
        } else {
            System.out.println(gc.getCurrentCountry() + " don't have that "
                    + "many of that drug.");
        }

    }

    /**
     * Handles sale of drugs.
     */
    private static void sellDrugs() {
        System.out.println("Sell drugs:");

        String[] drugs = gc.getPlayerDrugs();
        System.out.println(prettifyDrugs(drugs, true));

        String name = getDrugName("Select a drug:", drugs);
        int packages = getInt("Enter Amount of " + name + ", that you want:", 1,
                drugs.length);

        if (gc.sellDrug(name, packages)) {
            System.out.println("You successfully sold: " + name + ", " +
                    packages);
            System.out.println("You now have: " + gc.getCash() + " in cash");
        } else {
            System.out.println("You don't have that many of that drug.");
        }

    }

    private static String getDrugName(String question, String[] drugs) {
        String name = "";
        System.out.println(question);
        do {
            try {
                int input = Integer.parseInt(scanner.nextLine()) - 1;

                for (int i = 0; i < drugs.length; i++) {
                    if (input == i) {
                        name = drugs[i].split(";")[1].replace(",", "");
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println("Please enter a number between 1 & "
                        + drugs.length);
            }
        } while (name.isEmpty());
        return name;
    }

    private static int getInt(String question, int low, int high) {
        int input = 0;
        System.out.println(question);
        do {
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a number between " + low + ""
                        + " & " + high);
            }
        } while (input == 0);
        return input;
    }

    /**
     * Handles all traveling, and only shows the player the countries he/she can
     * travel to.
     */
    private static void travel() {
        System.out.println("Travel to a country below:");

        String[] countries = gc.getOtherCountries();
        for (int i = 0; i < countries.length; i++) {
            System.out.println((i + 1) + " " + countries[i]);
        }

        boolean givenACountry = false;
        do {
            try {
                int input = Integer.parseInt(scanner.nextLine()) - 1;

                for (int i = 0; i < countries.length; i++) {
                    if (input == i) {
                        gc.travelTo(countries[i]);
                        givenACountry = true;
                        break;
                    }
                }

            } catch (Exception e) {

            }
        } while (!givenACountry);

        System.out.println("Welcome to " + gc.getCurrentCountry());
    }

    /**
     * The game menu
     *
     * @return
     */
    private static boolean gameMenu() {
        switch (scanner.nextLine()) {
            case "h":
            case "m":
                System.out.println(menuText());
                break;
            case "1":
                showPlayerStats();
                break;
            case "2":
                showPlayerDrugs();
                break;
            case "3":
                showCurrentCountryDrugs();
                break;
            case "4":
                buyDrugs();
                break;
            case "5":
                sellDrugs();
                break;
            case "6":
                travel();
                break;
            case "exit":
            case "q":
                return true;
            default:
                System.out.println("Invalid input, try again.");
                break;
        }
        return false;
    }

    /**
     * Just a method to handle the menu text, so it doesn't clutter the switch
     * case.
     *
     * @return
     */
    private static String menuText() {
        String temp = "";
        String pad = "\n  ";
        temp += "Menu options:";
        temp += pad + "'m' or 'h' To open this menu.";
        temp += pad + "'1' Display your stats.";
        temp += pad + "'2' Display your drugs.";
        temp += pad + "'3' Display " + gc.getCurrentCountry() + " drugs.";
        temp += pad + "'4' Buy drugs.";
        temp += pad + "'5' Sell drugs.";
        temp += pad + "'6' Travel.(Costs a turn)";
        temp += pad + "'exit' or 'q' To exit the game.";
        return temp;
    }

     /**
     * Ridicules amount of code just to make it look good in the console.
     *
     * @param array
     * @return Pretty drugs
     */
    private static String prettifyDrugs(String[] array) {
        return prettifyDrugs(array, false);
    }

    /**
     * Ridicules amount of code just to make it look good in the console.
     *
     * @param array
     * @return Pretty drugs
     */
    private static String prettifyDrugs(String[] array, boolean numbered) {
        String temp = "";

        int[] maxLengths = getMaxLengths(array, numbered);

        for (int i = 0; i < array.length; i++) {
            if (numbered) {
                array[i] = (i + 1) + ";" + array[i];
            }
            for (int j = 0; j < maxLengths.length; j++) {
                int diff = maxLengths[j] - array[i].split(";")[j].length();

                temp += array[i].split(";")[j];
                if (j != maxLengths.length - 1) {
                    temp += ",";
                }

                // Spacing
                diff += 2;

                for (int k = 0; k < diff; k++) {
                    temp += " ";
                }
            }
            temp += "\n";
        }

        //adding titles the titles, with proper spacing.
        String[] titlesArray = {"#", "Name", "Price", "Packages"};
        String tempTitles = "";
        for (int i = 0; i < maxLengths.length; i++) {
            int diff;
            if (numbered) {
                diff = maxLengths[i] - titlesArray[i].length();
                tempTitles += titlesArray[i];
            } else {
                diff = maxLengths[i] - titlesArray[i + 1].length();
                tempTitles += titlesArray[i + 1];
            }

            if (i != maxLengths.length - 1) {
                tempTitles += ",";
            }

            // Spacing
            diff += 2;

            for (int k = 0; k < diff; k++) {
                tempTitles += " ";
            }
        }
        temp = tempTitles + "\n" + temp;

        return temp;
    }

    /**
     * Extract maxLengths from array.
     *
     * @param array
     * @return maxLengths
     */
    private static int[] getMaxLengths(String[] array, boolean isNumbered) {
        int[] maxLengths = new int[0];
        if (array.length > 0 && isNumbered) {
            maxLengths = new int[array[0].split(";").length + 1];
        } else if (array.length > 0) {
            maxLengths = new int[array[0].split(";").length];
        }

        //set default maxLengths
        int num = 0;
        if (isNumbered) {
            maxLengths[num] = "#".length();
            num++;
        }
        maxLengths[num] = "Name".length();
        num++;
        maxLengths[num] = "Price".length();
        num++;
        maxLengths[num] = "Packages".length();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < maxLengths.length; j++) {
                //if it is numbered, do this, that and that.
                if (isNumbered && j == 0) {
                    int numberLength = ((i + 1) + "").length();
                    if (numberLength > maxLengths[j]) {
                        maxLengths[j] = numberLength;
                    }
                } else if (isNumbered) {
                    if (array[i].split(";")[j - 1].length() > maxLengths[j]) {
                        maxLengths[j] = array[i].split(";")[j - 1].length();
                    }
                } else if (array[i].split(";")[j].length() > maxLengths[j]) {
                    maxLengths[j] = array[i].split(";")[j].length();
                }
            }
        }

        return maxLengths;
    }

}
