package gfx;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class ImageUtils {
    public static Image loadImage(String filePath){
        try {
            return ImageIO.read(ImageUtils.class.getResource(filePath));
        } catch (IOException exception) {
            System.out.println("Could not load a image from the path:"+ filePath);
        }
            return null;
    }
}
