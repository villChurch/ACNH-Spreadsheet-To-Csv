import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import lombok.Setter;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Setter
public class Other {

    private Sheets sheetsService;
    private String SPREADSHEET_ID;

    Other (Sheets sheetsService, String SPREADSHEET_ID) {
        this.setSheetsService(sheetsService);
        this.setSPREADSHEET_ID(SPREADSHEET_ID);
    }

    public void getOther() {
        GetSpreadsheetData getSpreadsheetData =
                new GetSpreadsheetData(sheetsService, "Other", SPREADSHEET_ID);
        Spreadsheet response = getSpreadsheetData.getSpreadsheetsInformation();
        List<Integer> imageLocations = Arrays.asList(1,2);
        File file = new File("Other.csv");
        WriteSpreadsheetDataToFile writeData = new WriteSpreadsheetDataToFile(response, file, imageLocations);
        writeData.writeDataToFile();
    }
}
