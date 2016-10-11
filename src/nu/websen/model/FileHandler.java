/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.websen.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MENJA
 */
public class FileHandler {
    private File file;
    private ArrayList<String> strings;

    public FileHandler() {
        strings = new ArrayList<>();
    }

    public void setFile(String fileName) {
        //her oprettes nyt objekt og leder efter filnavnet
        file = new File(fileName);

        try {
            //findes filen ikke, så laves en fil her, så man undgår fejl
            file.createNewFile();
        } catch (Exception ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> loadFile() {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while (br.ready()) {
                strings.add(br.readLine());
            }
        } catch (Exception ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return strings;
    }

    public String getFileName() {
        return file.getName();
    }

    public boolean saveFile(ArrayList<String> strings) {
        this.strings = strings;

        try {
            FileWriter fw = new FileWriter(file);

            for (int i = 0; i < strings.size(); i++) {
                if (i > 0) {
                    fw.write("\r\n" + strings.get(i));
                } else {
                    fw.write(strings.get(i));
                }
            }
            //sørger for at det nyoprettede objekt bliver skrevet ind i filen
            fw.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return this.strings.size() > 0;
    }
}
