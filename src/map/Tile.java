package map;

import gfx.SpriteLibrary;

import java.awt.*;

public class Tile {
    private Image sprite;
    public Tile(SpriteLibrary spriteLibrary) {
        this.sprite = spriteLibrary.getTiles("default");
    }

    public Image getSprite(){
        return sprite;
    }
}
