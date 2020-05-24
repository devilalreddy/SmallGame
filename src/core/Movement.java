package core;

import controller.Controller;

public class Movement {
    private Vector2D vector2D;
    private double speed;

    public Movement(double speed) {
        this.speed = speed;
        this.vector2D = new Vector2D(0,0);
    }

    public Movement(Vector2D vector2D) {
        this.vector2D = vector2D;
    }

    public Vector2D getVector2D() {
        return vector2D;
    }

    public void update(Controller controller) {
        int deltaX = 0;
        int deltaY = 0;
        if (controller.isRequestingUp())  {
            deltaY--;
        }
        if (controller.isRequestingDown())  {
            deltaY++;
        }
        if (controller.isRequestingLeft())  {
            deltaX--;
        }
        if (controller.isRequestingRight())  {
            deltaX++;
        }

        vector2D = new Vector2D(deltaX,deltaY);
        vector2D.normalize();
        vector2D.multiply(speed);
        System.out.println(vector2D.length());
    }

}
