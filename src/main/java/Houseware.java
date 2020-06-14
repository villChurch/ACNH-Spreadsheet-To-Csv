import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.CellData;
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
        Sheets.Spreadsheets.Get request = sheetsService.spreadsheets().get(SPREADSHEET_ID);
        request.setRanges(Collections.singletonList("Housewares"));
        request.setIncludeGridData(true);

        var imageResponse = request.execute();

        var testImage = imageResponse.getSheets().get(0).getData().get(0).getRowData().get(2).getValues().get(1).getUserEnteredValue().getFormulaValue().split("https://")[1].split(".png")[0];

        var newHeaders = imageResponse.getSheets().get(0).getData().get(0).getRowData().get(0).getValues();
        var newResponses = imageResponse.getSheets().get(0).getData().get(0).getRowData();
        newResponses.remove(0);

        StringBuilder newSb = new StringBuilder();
        File newOutput = new File("housewareV2.csv");
        FileWriter testNewOutputWriter = new FileWriter(newOutput);

        for (var item: newHeaders){
            if(null != item.getUserEnteredValue().getFormulaValue()){
                String value = item.getUserEnteredValue().getFormulaValue().split("https://")[1].split(".png")[0];
                value = "https://" + value + ".png";
                newSb.append(value).append(",");
            } else {
                var value = item.getUserEnteredValue().getStringValue();
                value = value.replace(' ', '_');
                value = value.replace('/', '_');
                newSb.append(value).append(",");
            }
        }

        testNewOutputWriter.append(newSb.toString());
        testNewOutputWriter.append(System.lineSeparator());
        newSb.setLength(0);

        for (var item : newResponses) {
            List<CellData> rowData = item.getValues();
            for(int i = 0; i < rowData.size(); i ++) {
                try {
                    if (i == 1) {
                        String value = rowData.get(i).getUserEnteredValue().getFormulaValue().split("https://")[1].split(".png")[0];
                        value = "https://" + value + ".png";
                        newSb.append(value).append(",");
                    } else {
                        newSb.append(rowData.get(i).getUserEnteredValue().getStringValue()).append(",");
                    }
                } catch (NullPointerException ex) {
                    newSb.append(",");
                }
            }
            testNewOutputWriter.append(newSb.toString());
            testNewOutputWriter.append(System.lineSeparator());
            newSb.setLength(0);
        }
        testNewOutputWriter.close();
    }
}
