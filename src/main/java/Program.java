import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;
import lombok.SneakyThrows;
import lombok.var;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Program {

    private static String SPREADSHEET_ID = "13d_LAJPlxMa_DubPTuirkIV4DERBMXbrWQsmSh8ReK4";
    @SneakyThrows
    public static void main(String[] args){
        Sheets sheetsService = SheetServiceUtil.getSheetsService();

        ValueRange housewares = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID, "Housewares")
                .execute();

        List<List<Object>> housewareValues = housewares.getValues();

        System.out.println(housewareValues.get(0));
        List<Object> headers = housewareValues.get(0);

        File testOutput = new File("housewares.csv");
        if(testOutput.createNewFile()) {
            System.out.println("Created file: " + testOutput.getPath());
        }
        FileWriter outputWriter = new FileWriter(testOutput);
        StringBuilder sb = new StringBuilder();


        for(Object item : headers){
            String value = item.toString();
            value = value.replace(' ', '_');
            value = value.replace('/', '_');
            sb.append(value).append(",");
        }

        outputWriter.append(sb.toString());
        sb.setLength(0);
        housewareValues.remove(0); //remove headers

        for(List<Object> value : housewareValues) {
            value.forEach(x -> sb.append(x).append(","));
            outputWriter.append(sb.toString());
            outputWriter.append(System.lineSeparator());
            sb.setLength(0);
        }

        outputWriter.close();

        Reactions reactions = new Reactions(sheetsService);
        reactions.getReactions();
    }
}
