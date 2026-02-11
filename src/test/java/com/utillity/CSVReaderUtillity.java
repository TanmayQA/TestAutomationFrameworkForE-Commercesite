package com.utillity;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtillity {

    public static Iterator<user> readCSVFile(String filename) throws IOException, CsvValidationException {
        File csvfile = new File(System.getProperty("user.dir") + "/testData/" + filename);
        FileReader fileReader = null;
        CSVReader csvfileReader;
        String[] line;
        user userdata;
        List<user> userList = null;
        try {
            fileReader = new FileReader(csvfile);
            csvfileReader = new CSVReader(fileReader);
            csvfileReader.readNext(); // row 1 -- Reading the col names-- row 1 skip the col names
            userList = new ArrayList<user>();
            while ((line = csvfileReader.readNext()) != null) {
                userdata = new user(line[0], line[1]);
                userList.add(userdata);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }
        return userList.iterator();

    }
}
