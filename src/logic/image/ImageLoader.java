package logic.image;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
    
    protected BufferedImage image = null;

    public void loadImage(final BufferedImage image) {
        this.image = image;
    }

    public void loadImage(final File file) {
        BufferedImage img;
        try {
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(
                "GrayScaler: Load image error!"
            );
        }
        this.loadImage(img);
    }

    public void loadImage(final String path) {
        final File file = new File(path);
        this.loadImage(file);
    }

    public BufferedImage getImageOrNull() {
        return this.image;
    }
}
