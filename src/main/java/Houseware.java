import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.CellData;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.var;

import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;

@Setter
class Houseware {
    private Sheets sheetsService;
    private String SPREADSHEET_ID;

    Houseware(Sheets sheetsService, String SPREADSHEET_ID) {
        this.setSheetsService(sheetsService);
        this.setSPREADSHEET_ID(SPREADSHEET_ID);
    }

    @SneakyThrows
    void getHouseware() {
        GetSpreadsheetData getSpreadsheetData =
                new GetSpreadsheetData(sheetsService, "Housewares", SPREADSHEET_ID);
        Spreadsheet response = getSpreadsheetData.getSpreadsheetsInformation();
        List<Integer> imageLocations = Collections.singletonList(1);
        File file = new File("Housewares.csv");
        WriteSpreadsheetDataToFile writeData = new WriteSpreadsheetDataToFile(response, file, imageLocations);
        writeData.writeDataToFile();
    }
}
