package gfx;

import core.Size;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageUtils {

    public  static final int ALPHA_OPAQUE = 1;
    public static final int ALPHA_BIT_MASKED  = 2;
    public static final int ALPHA_BLEND = 3;

    public static Image loadImage(String filePath){
        try {
            Image imageFromDisk = ImageIO.read(ImageUtils.class.getResource(filePath));
            BufferedImage  compatibleImage = (BufferedImage) createCompatibleImage(
                    new Size(imageFromDisk.getWidth(null),imageFromDisk.getHeight(null)),
                            ALPHA_BIT_MASKED
            );
            Graphics2D graphics2D = compatibleImage.createGraphics();
            graphics2D.drawImage(imageFromDisk,0,0,null);
            graphics2D.dispose();
            return compatibleImage;
        } catch (IOException exception) {
            System.out.println("Could not load a image from the path:"+ filePath);
        }
            return null;
    }
    public static Image createCompatibleImage(Size size, int transparency) {
        GraphicsConfiguration graphicsConfiguration = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();
        return graphicsConfiguration.createCompatibleImage(size.getWidth(), size.getHeight(), transparency);
    }
}
