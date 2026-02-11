package com.ui.dataproviders;

import com.google.gson.Gson;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.TestData;
import com.ui.pojo.user;
import com.utillity.CSVReaderUtillity;
import com.utillity.ExcelReaderUtility;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {


    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> loginDataProvider() {
        Gson gson = new Gson();

        File testDataFile = new File(System.getProperty("user.dir") + "/testData/logindata.json");

        FileReader fileReader;
        try {
            fileReader = new FileReader(testDataFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        TestData data = gson.fromJson(fileReader, TestData.class);

        List<Object[]> dataToReturn = new ArrayList<>();

        for (user user : data.getData()) {
            dataToReturn.add(new Object[]{user});
        }

        return dataToReturn.iterator();
    }

    @DataProvider(name = "LoginTestCSVDataProvider")
    public Iterator<user> loginCSVDataProvider() throws CsvValidationException, IOException {
        return CSVReaderUtillity.readCSVFile("loginData.csv");
    }

    @DataProvider(name ="LoginTestExcelDataProvider")
    public Iterator<user> loginExcelDataProvider() throws IOException, InvalidFormatException {
        return ExcelReaderUtility.readExcelFile("loginTestData1.xlsx");
    }


}
