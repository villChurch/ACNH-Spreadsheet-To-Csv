import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.CellData;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.var;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Setter
class Reactions {

    private Sheets sheetsService;
    private static String SPREADSHEET_ID = "13d_LAJPlxMa_DubPTuirkIV4DERBMXbrWQsmSh8ReK4";

    Reactions(Sheets sheetsService) {
        this.setSheetsService(sheetsService);
    }
    @SneakyThrows
    void getReactions() {
        Sheets.Spreadsheets.Get request = sheetsService.spreadsheets().get(SPREADSHEET_ID);
        request.setRanges(Collections.singletonList("Reactions"));
        request.setIncludeGridData(true);

        var imageResponse = request.execute();

        var testImage = imageResponse.getSheets().get(0).getData().get(0).getRowData().get(2).getValues().get(1).getUserEnteredValue().getFormulaValue().split("https://")[1].split(".png")[0];

        System.out.println(imageResponse.getSheets().get(0).getData().get(0).getRowData().get(2).getValues().get(0).getUserEnteredValue().getStringValue());
        System.out.println(testImage + ".png");

        var newHeaders = imageResponse.getSheets().get(0).getData().get(0).getRowData().get(0).getValues();
        var newResponses = imageResponse.getSheets().get(0).getData().get(0).getRowData();
        newResponses.remove(0);

        StringBuilder newSb = new StringBuilder();
        File newOutput = new File("headersv2.csv");
        FileWriter testNewOutputWriter = new FileWriter(newOutput);

        for (var item: newHeaders){
            if(null != item.getUserEnteredValue().getFormulaValue()){
                String value = item.getUserEnteredValue().getFormulaValue().split("https://")[1].split(".png")[0];
                value = "https://" + value + ".png";
                newSb.append(value).append(",");
            } else {
                newSb.append(item.getUserEnteredValue().getStringValue()).append(",");
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
