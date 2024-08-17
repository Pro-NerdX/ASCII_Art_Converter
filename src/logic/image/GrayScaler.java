package logic.image;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class GrayScaler extends ImageLoader {

    public GrayScaler() {}

    /**
     * @param weighted indicated, whether the average of each pixel should be weighted or not (shouldn't make much of a difference).
     *
     * @return a gray-scaled [BufferedImage]. 
     */
    public BufferedImage getGrayScale() {
        if (this.image == null) {
            throw new RuntimeException("GrayScaler: No image has been loaded!");
        }
        final int width = this.image.getWidth();
        final int height = this.image.getHeight();
        final BufferedImage res = new BufferedImage(
            width, height, BufferedImage.TYPE_BYTE_GRAY
        );
        final Graphics graphics = res.getGraphics();
        graphics.drawImage(this.image, 0, 0, null);
        graphics.dispose();
        return res;
    }
}
