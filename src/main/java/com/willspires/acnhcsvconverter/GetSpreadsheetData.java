package com.willspires.acnhcsvconverter;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.Collections;

@Setter
class GetSpreadsheetData {

    private Sheets sheetsService;
    private String worksheetToGet;
    private String SPREADSHEET_ID;

    GetSpreadsheetData(Sheets sheetsService, String worksheetToGet, String SPREADSHEET_ID){
       this.setSheetsService(sheetsService);
       this.setWorksheetToGet(worksheetToGet);
       this.setSPREADSHEET_ID(SPREADSHEET_ID);
    }

    @SneakyThrows
    public Spreadsheet getSpreadsheetsInformation() {
        Sheets.Spreadsheets.Get request = sheetsService.spreadsheets().get(SPREADSHEET_ID);
        request.setRanges(Collections.singletonList(worksheetToGet));
        request.setIncludeGridData(true);
        return request.execute();
    }
}
