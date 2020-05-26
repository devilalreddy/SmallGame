package display;

import core.Position;
import game.Game;
import game.state.State;
import map.GameMap;
import map.Tile;

import java.awt.*;

public class Renderer {
    public void render(State state, Graphics graphics) {
        renderMap(state,graphics);
        Camera camera = state.getCamera();
        state.getGameObject().stream().filter(gameObject -> camera.isInView(gameObject))
        .forEach(gameObject -> graphics.drawImage(
                gameObject.getSprite(),
                gameObject.getPosition().intX() - camera.getPosition().intX() - gameObject.getSize().getWidth() /2,
                gameObject.getPosition().intY() - camera.getPosition().intY() - gameObject.getSize().getHeight() /2,
                null
        ));
    }

    private void renderMap(State state, Graphics graphics) {
        GameMap gameMap = state.getGameMap();
        Camera camera = state.getCamera();
        Position start = gameMap.getViewableStartingGridPosition(camera);
        Position end = gameMap.getViewableEndingGridPosition(camera);

        for (int x = start.intX(); x< end.intX(); x++) {
                for (int y = start.intY(); y<end.intY(); y++) {
                        graphics.drawImage(
                                gameMap.getTiles()[x][y].getSprite(),
                                x * Game.SPRITE_SIZE - camera.getPosition().intX(),
                                  y * Game.SPRITE_SIZE - camera.getPosition().intY(),
                                null
                        );
                }
        }
    }
}
