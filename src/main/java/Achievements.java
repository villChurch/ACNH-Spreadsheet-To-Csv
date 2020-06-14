import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import lombok.Setter;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Setter
public class Achievements {

    private Sheets sheetsService;
    private String SPREADSHEET_ID;

    Achievements (Sheets sheetsService, String SPREADSHEET_ID) {
        this.setSheetsService(sheetsService);
        this.setSPREADSHEET_ID(SPREADSHEET_ID);
    }

    public void getAchievements() {
        GetSpreadsheetData getSpreadsheetData =
                new GetSpreadsheetData(sheetsService, "Achievements", SPREADSHEET_ID);
        Spreadsheet response = getSpreadsheetData.getSpreadsheetsInformation();
        List imageLocations = Collections.EMPTY_LIST;
        File file = new File("Achievements.csv");
        WriteSpreadsheetDataToFile writeData = new WriteSpreadsheetDataToFile(response, file, imageLocations);
        writeData.writeDataToFile();
    }
}
