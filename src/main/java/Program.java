import com.google.api.services.sheets.v4.Sheets;
import lombok.SneakyThrows;

public class Program {


    @SneakyThrows
    public static void main(String[] args){
        Sheets sheetsService = SheetServiceUtil.getSheetsService();
        String SPREADSHEET_ID = "13d_LAJPlxMa_DubPTuirkIV4DERBMXbrWQsmSh8ReK4";
        Reactions reactions = new Reactions(sheetsService, SPREADSHEET_ID);
        reactions.getReactions();
        Houseware houseware = new Houseware(sheetsService, SPREADSHEET_ID);
        houseware.getHouseware();
        Villager villager = new Villager(sheetsService, SPREADSHEET_ID);
        villager.getVillagers();
    }
}
