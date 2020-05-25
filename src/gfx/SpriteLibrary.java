package gfx;

import game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SpriteLibrary {
    private  final  static String PATH_TO_UNITS = "/sprites/units";
     private Map<String,SpriteSet> units;
     private Map<String, Image> tiles;

    public SpriteLibrary(){
        units = new HashMap<>();
        tiles = new HashMap<>();
        loadSprintsFromDisk();
    }

    private void loadSprintsFromDisk() {
        loadUnits();
        loadTiles();
    }

    private void loadTiles() {
        BufferedImage bufferedImage = new BufferedImage(Game.SPRITE_SIZE,Game.SPRITE_SIZE, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setColor(Color.RED);
        graphics.drawRect(0,0,Game.SPRITE_SIZE,Game.SPRITE_SIZE);
        graphics.dispose();
        tiles.put("default",bufferedImage);
    }

    private void loadUnits(){
        String[] folderNames = getFolderNames(PATH_TO_UNITS);
        for (String folderName: folderNames) {
            SpriteSet spriteSet = new SpriteSet();
            String pathToFolder =PATH_TO_UNITS + "/" + folderName;
            String [] sheetsInFolder = getSheetsInFolder(pathToFolder);
            for (String sheetName : sheetsInFolder) {
                spriteSet.addSheet(
                        sheetName.substring(0, sheetName.length() -4),
                        ImageUtils.loadImage(pathToFolder + "/" + sheetName));
            }
            units.put(folderName, spriteSet);
        }
    }

    private String[] getSheetsInFolder(String basePath) {
        URL resource = SpriteLibrary.class.getResource(basePath);
        File file = new File(resource.getFile());
        return file.list((current , name) -> new File(current , name).isFile());
    }

    private String[] getFolderNames(String basePath) {
        URL resource = SpriteLibrary.class.getResource(basePath);
        File file = new File(resource.getFile());
        return file.list((current , name) -> new File(current , name).isDirectory());
     }

    public SpriteSet getUnit(String name) {
        return units.get(name);
    }

    public Image getTiles(String name) {
        return tiles.get(name);

    }
}
