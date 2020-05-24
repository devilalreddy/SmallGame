package game;

import controller.PlayerController;
import display.Display;
import entity.GameObject;
import entity.Player;
import gfx.SpriteLibrary;
import input.Input;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public  static int SPRITE_SIZE = 64;
    private Display display;
    private List<GameObject> gameObject;
    private Input input;
    private SpriteLibrary spriteLibrary;

    public List<GameObject> getGameObject() {
        return gameObject;
    }

    public Game(int height , int width){
        input = new Input();
        display = new Display(width,height, input);
        gameObject = new ArrayList<>();
        spriteLibrary = new SpriteLibrary();
        gameObject.add(new Player(new PlayerController(input), spriteLibrary));
    }

    public  void update(){
            gameObject.forEach(gameObject -> gameObject.update());
    }

    public void render(){
        display.render(this);
    }

}
