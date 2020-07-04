package com.willspires.acnhcsvconverter;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SeaCreatures {

    private Sheets sheetsService;
    private String SPREADSHEET_ID;

    SeaCreatures(final Sheets sheetsService, final String SPREADSHEET_ID) {
        this.sheetsService = sheetsService;
        this.SPREADSHEET_ID = SPREADSHEET_ID;
    }

    public void getSeaCreatures() {
        GetSpreadsheetData getSpreadsheetData =
                new GetSpreadsheetData(sheetsService, "Sea Creatures", SPREADSHEET_ID);
        Spreadsheet response = getSpreadsheetData.getSpreadsheetsInformation();
        List<Integer> imageLocations = Arrays.asList(2,3,4);
        File file = new File("SeaCreatures.csv");
        WriteSpreadsheetDataToFile writeData = new WriteSpreadsheetDataToFile(response, file, imageLocations);
        writeData.writeDataToFile();
    }
}
