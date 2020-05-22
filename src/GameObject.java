import java.awt.*;

public abstract class GameObject {
    public Position position;
    public Size size;

    public GameObject() {
        position = new Position(50,50);
        size = new Size(50, 50);
    }

    public abstract void update();
    public abstract Image getSprite();

    public Position getPosition() {
        return position;
    }

    public Size getSize() {
        return size;
    }
}
