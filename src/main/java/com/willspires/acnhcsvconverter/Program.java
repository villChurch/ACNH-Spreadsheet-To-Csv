package com.willspires.acnhcsvconverter;

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
        Miscellaneous miscellaneous = new Miscellaneous(sheetsService, SPREADSHEET_ID);
        miscellaneous.getMiscellaneousData();
        WallMounted wallMounted = new WallMounted(sheetsService, SPREADSHEET_ID);
        wallMounted.getWallMountedData();
        Wallpaper wallpaper = new Wallpaper(sheetsService, SPREADSHEET_ID);
        wallpaper.getWallpapers();
        Floors floors = new Floors(sheetsService, SPREADSHEET_ID);
        floors.getFloorings();
        Rugs rugs = new Rugs(sheetsService, SPREADSHEET_ID);
        rugs.getRugs();
        Photos photos = new Photos(sheetsService, SPREADSHEET_ID);
        photos.getPhotos();
        Posters posters = new Posters(sheetsService, SPREADSHEET_ID);
        posters.getPosters();
        Tools tools = new Tools(sheetsService, SPREADSHEET_ID);
        tools.getTools();
        Fencing fencing = new Fencing(sheetsService, SPREADSHEET_ID);
        fencing.getFences();
        Tops tops = new Tops(sheetsService, SPREADSHEET_ID);
        tops.getTops();
        Bottoms bottoms = new Bottoms(sheetsService, SPREADSHEET_ID);
        bottoms.getBottoms();
        DressUp dressUp = new DressUp(sheetsService, SPREADSHEET_ID);
        dressUp.getDressUps();
        Headwear headwear = new Headwear(sheetsService, SPREADSHEET_ID);
        headwear.getHeadwear();
        Accessories accessories = new Accessories(sheetsService, SPREADSHEET_ID);
        accessories.getAccessories();
        Socks socks = new Socks(sheetsService, SPREADSHEET_ID);
        socks.getSocks();
        Shoes shoes = new Shoes(sheetsService, SPREADSHEET_ID);
        shoes.getShoes();
        Bags bags = new Bags(sheetsService, SPREADSHEET_ID);
        bags.getBags();
        Umbrellas umbrellas = new Umbrellas(sheetsService, SPREADSHEET_ID);
        umbrellas.getUmbrellas();
        Music music = new Music(sheetsService, SPREADSHEET_ID);
        music.getMusic();
        Insects insects = new Insects(sheetsService, SPREADSHEET_ID);
        insects.getInsects();
        Fish fish = new Fish(sheetsService, SPREADSHEET_ID);
        fish.getFish();
        Recipes recipes = new Recipes(sheetsService, SPREADSHEET_ID);
        recipes.getRecipes();
        Fossils fossils = new Fossils(sheetsService, SPREADSHEET_ID);
        fossils.getFossils();
        Art art = new Art(sheetsService, SPREADSHEET_ID);
        art.getArt();
        Other other = new Other(sheetsService, SPREADSHEET_ID);
        other.getOther();
        Construction construction = new Construction(sheetsService, SPREADSHEET_ID);
        construction.getConstruction();
        Achievements achievements = new Achievements(sheetsService, SPREADSHEET_ID);
        achievements.getAchievements();
        SeaCreatures seaCreatures = new SeaCreatures(sheetsService, SPREADSHEET_ID);
        seaCreatures.getSeaCreatures();
        ClothingOther clothingOther = new ClothingOther(sheetsService, SPREADSHEET_ID);
        clothingOther.getOtherClothing();
    }
}
