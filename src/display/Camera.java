package display;

import core.Position;
import core.Size;
import entity.GameObject;
import game.state.State;

import java.util.Optional;

public class Camera {
    private Position position;
    private Size windowSize;
    private Optional<GameObject> objectWithFocus;

    public Camera(Size windowSize) {
        this.position = new Position(0,0);
        this.windowSize = windowSize;
    }

    public void focusOn(GameObject gameObject) {
        this.objectWithFocus = Optional.of(gameObject);

    }

    public Position getPosition() {
        return position;
    }

    public  void update(State state) {
        if (objectWithFocus.isPresent()) {
            Position objectPosition = objectWithFocus.get().getPosition();
            this.position.setX(objectPosition.getX() - windowSize.getWidth() /2);
            this.position.setY(objectPosition.getY() - windowSize.getHeight() /2);
            clampWithInBounds(state);
        }
    }

    private void clampWithInBounds(State state) {
        if (position.getX() < 0) {
            position.setX(0);
        }
        if (position.getY() < 0) {
            position.setY(0);
        }
        if (position.getX() + windowSize.getWidth() > state.getGameMap().getWidth()) {
            position.setX(state.getGameMap().getWidth() - windowSize.getWidth());
        }
        if (position.getY() + windowSize.getHeight() > state.getGameMap().getHeight()) {
            position.setY(state.getGameMap().getHeight() - windowSize.getHeight());
        }
    }
}
