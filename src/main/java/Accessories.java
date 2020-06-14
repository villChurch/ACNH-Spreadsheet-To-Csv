import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import lombok.Setter;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Setter
public class Accessories {

    private Sheets sheetsService;
    private String SPREADSHEET_ID;

    Accessories (Sheets sheetsService, String SPREADSHEET_ID) {
        this.setSheetsService(sheetsService);
        this.setSPREADSHEET_ID(SPREADSHEET_ID);
    }

    public void getAccessories() {
        GetSpreadsheetData getSpreadsheetData =
                new GetSpreadsheetData(sheetsService, "Accessories", SPREADSHEET_ID);
        Spreadsheet response = getSpreadsheetData.getSpreadsheetsInformation();
        List<Integer> imageLocations = Arrays.asList(1,2);
        File file = new File("Accessories.csv");
        WriteSpreadsheetDataToFile writeData = new WriteSpreadsheetDataToFile(response, file, imageLocations);
        writeData.writeDataToFile();
    }
}
