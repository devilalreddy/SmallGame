import java.util.ArrayList;
import java.util.List;

public class Game {
    private Display display;
    private List<GameObject> gameObject;
    private  Input input;

    public List<GameObject> getGameObject() {
        return gameObject;
    }

    public Game(int height , int width){
        input = new Input();
        display = new Display(width,height, input);
        gameObject = new ArrayList<>();
        gameObject.add(new Player(new PlayerController(input)));
    }

    public  void update(){
            gameObject.forEach(gameObject -> gameObject.update());
    }

    public void render(){
        display.render(this);
    }

}
