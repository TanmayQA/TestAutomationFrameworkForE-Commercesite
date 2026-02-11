package com.utillity;

import com.ui.pojo.user;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {

    public static Iterator<user> readExcelFile(String filename) {
        File xlsxfile = new File(System.getProperty("user.dir") + "/testData/" + filename);

        XSSFWorkbook xssfWorkbook = null;
        List<user> userList = new ArrayList<user>();
        user user;
        Row row;
        Cell emailAddressCell;
        Cell passwordCell;
        XSSFSheet xssfSheet;
        Iterator<Row> rowIterator;
        try {
            xssfWorkbook = new XSSFWorkbook(xlsxfile);

            xssfSheet = xssfWorkbook.getSheet("loginData");
            rowIterator = xssfSheet.iterator();
            rowIterator.next(); // skipping the Col name
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                emailAddressCell = row.getCell(0);
                passwordCell = row.getCell(1);
                user = new user(emailAddressCell.toString(), passwordCell.toString());
                userList.add(user);

            }
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }

        return userList.iterator();
    }

}
