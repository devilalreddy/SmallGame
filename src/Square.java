import java.awt.*;
import java.awt.image.BufferedImage;

public class Square extends GameObject {

    @Override
    public void update() {
        position = new Position(position.getX() +1, position.getY());
    }

    @Override
    public Image getSprite() {
        BufferedImage bufferedImage = new BufferedImage(size.getWidth(), size.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setColor(Color.BLUE);
        graphics.fillRect(0,0,size.getWidth(),size.getHeight());
        graphics.dispose();
        return bufferedImage;
    }
}
