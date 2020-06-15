package com.willspires.acnhcsvconverter;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import lombok.Setter;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Setter
public class Miscellaneous {

    private Sheets sheetsService;
    private String SPREADSHEET_ID;

    Miscellaneous(Sheets sheetsService, String SPREADSHEET_ID){
        this.setSheetsService(sheetsService);
        this.setSPREADSHEET_ID(SPREADSHEET_ID);
    }

    public void getMiscellaneousData(){
        GetSpreadsheetData getSpreadsheetData =
                new GetSpreadsheetData(sheetsService, "Miscellaneous", SPREADSHEET_ID);
        Spreadsheet response = getSpreadsheetData.getSpreadsheetsInformation();
        List<Integer> imageLocations = Collections.singletonList(1);
        File file = new File("Miscellaneous.csv");
        WriteSpreadsheetDataToFile writeData = new WriteSpreadsheetDataToFile(response, file, imageLocations);
        writeData.writeDataToFile();
    }
}
