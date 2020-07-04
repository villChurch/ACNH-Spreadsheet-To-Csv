package com.willspires.acnhcsvconverter;

import com.google.api.services.sheets.v4.model.CellData;
import com.google.api.services.sheets.v4.model.RowData;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.var;

import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;

@Setter
public class WriteSpreadsheetDataToFile {

    private Spreadsheet spreadsheet;
    private File file;
    private List<Integer> imageLocations;

    WriteSpreadsheetDataToFile (Spreadsheet spreadsheet, File file, List<Integer> imageLocations){
        this.setSpreadsheet(spreadsheet);
        this.setFile(file);
        this.setImageLocations(imageLocations);
    }

    @SneakyThrows
    public void writeDataToFile() {
        List<CellData> headers = spreadsheet.getSheets().get(0).getData().get(0).getRowData().get(0).getValues();
        List<RowData> sheetData = spreadsheet.getSheets().get(0).getData().get(0).getRowData();
        sheetData.remove(0);

        StringBuilder stringBuilder = new StringBuilder();
        FileWriter fileWriter = new FileWriter(file);


        for (int i = 0; i < headers.size(); i++) {
            String value;
            CellData data = headers.get(i);
            if (null != data.getUserEnteredValue().getFormulaValue()){
                value = data.getUserEnteredValue().getFormulaValue().split("https://")[1].split(".png")[0];
                value = "https://" + value + ".png";
            } else {
                value = data.getUserEnteredValue().getStringValue();
                value = value.replace(' ', '_');
                value = value.replace('/', '_');
            }
            stringBuilder.append(value);
            if ((i+1) != headers.size()){
                stringBuilder.append(",");
            }
        }

        fileWriter.append(stringBuilder.toString());
        fileWriter.append(System.lineSeparator());
        stringBuilder.setLength(0);

        for (var item : sheetData) {
            List<CellData> rowData = item.getValues();
            for (int i = 0; i < rowData.size(); i ++) {
                try {
                    int finalI = i;
                    if (imageLocations.stream().anyMatch(x -> x == finalI)) {
                        String value = rowData.get(i).getUserEnteredValue().getFormulaValue().split("://")[1].split(".png")[0];
                        value = "https://" + value + ".png";
                        stringBuilder.append(value);
                    } else {
//                        stringBuilder.append(rowData.get(i).getUserEnteredValue().getStringValue());
                        stringBuilder.append(rowData.get(i).getFormattedValue());
                    }
                } catch (NullPointerException ignored) {
                }
                if ((i + 1) != rowData.size()) {
                    stringBuilder.append(",");
                }
            }
            fileWriter.append(stringBuilder.toString());
            fileWriter.append(System.lineSeparator());
            stringBuilder.setLength(0);
        }
        fileWriter.close();
    }
}
