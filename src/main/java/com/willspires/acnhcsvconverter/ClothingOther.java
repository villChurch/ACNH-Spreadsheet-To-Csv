package com.willspires.acnhcsvconverter;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClothingOther {

    private Sheets sheetsService;
    private String SPREADSHEET_ID;

    ClothingOther(final Sheets sheetsService, final String SPREADSHEET_ID) {
        this.sheetsService = sheetsService;
        this.SPREADSHEET_ID = SPREADSHEET_ID;
    }

    public void getOtherClothing() {
        GetSpreadsheetData getSpreadsheetData =
                new GetSpreadsheetData(sheetsService, "Clothing Other", SPREADSHEET_ID);
        Spreadsheet response = getSpreadsheetData.getSpreadsheetsInformation();
        List<Integer> imageLocations = Arrays.asList(1,2);
        File file = new File("Clothing_Other.csv");
        WriteSpreadsheetDataToFile writeData = new WriteSpreadsheetDataToFile(response, file, imageLocations);
        writeData.writeDataToFile();
    }
}
