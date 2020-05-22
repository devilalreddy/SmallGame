import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Display display;
    private List<GameObject> gameObject;

    public List<GameObject> getGameObject() {
        return gameObject;
    }

    public Game(int height , int width){
        display = new Display(width,height);
        gameObject = new ArrayList<>();
        gameObject.add(new Square());
    }

    public  void update(){
            gameObject.forEach(gameObject -> gameObject.update());
    }

    public void render(){
        display.render(this);
    }

}
