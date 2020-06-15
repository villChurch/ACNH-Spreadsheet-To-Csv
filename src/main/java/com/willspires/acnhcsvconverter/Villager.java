package com.willspires.acnhcsvconverter;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import lombok.Setter;
import lombok.SneakyThrows;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Setter
class Villager {

    private Sheets sheetsService;
    private String SPREADSHEET_ID;

    Villager(Sheets sheetsService, String SPREADSHEET_ID) {
        this.setSheetsService(sheetsService);
        this.setSPREADSHEET_ID(SPREADSHEET_ID);
    }

    @SneakyThrows
    void getVillagers() {
        GetSpreadsheetData getSpreadsheetData =
                new GetSpreadsheetData(sheetsService, "Villagers", SPREADSHEET_ID);
        Spreadsheet response = getSpreadsheetData.getSpreadsheetsInformation();
        File file = new File("Villagers.csv");
        List<Integer> imageLocations = Arrays.asList(1,2,3);
        WriteSpreadsheetDataToFile writeData = new WriteSpreadsheetDataToFile(response, file, imageLocations);
        writeData.writeDataToFile();
    }
}
