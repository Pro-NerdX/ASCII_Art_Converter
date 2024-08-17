package logic.image;

import java.awt.image.BufferedImage;

public class ASCIIConverter extends ImageLoader {
    
    public ASCIIConverter() {}

    /**
     * @implNote Note: The given parameter must have been runned through the [GrayScaler] for this constructor
     *
     * @param img a gray-scaled image
     */
    public ASCIIConverter(final BufferedImage img) {
        this.image = img;
    }

    public int[][] getGrayValueMatrix() {
        if (this.image == null) {
            throw new RuntimeException("ASCIIConverter: No image has been loaded!");
        }
        final int width, height;
        width = this.image.getWidth();
        height = this.image.getHeight();
        final int[][] res = new int[height][width];
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                res[h][w] = PixelUtil.getGrayValue(this.image.getRGB(w, h));
            }
        }
        return res;
    }
    
    public char[][] generateASCIIArt() {
        final int[][] grayValues = this.getGrayValueMatrix();
        final int width, height;
        height = grayValues.length;
        width = grayValues[0].length;
        final char[][] res = new char[height][width];
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                final int grayValue = grayValues[h][w];
                if (grayValue < 25) {
                    res[h][w] = '@';
                } else if (grayValue < 50) {
                    res[h][w] = '#';
                } else if (grayValue < 70) {
                    res[h][w] = '&';
                } else if (grayValue < 90) {
                    res[h][w] = '$';
                } else if (grayValue < 110) {
                    res[h][w] = '§';
                } else if (grayValue < 130) {
                    res[h][w] = '%';
                } else if (grayValue < 145) {
                    res[h][w] = '?';
                } else if (grayValue < 160) {
                    res[h][w] = '+';
                } else if (grayValue < 180) {
                    res[h][w] = '*';
                } else if (grayValue < 200) {
                    res[h][w] = '=';
                } else if (grayValue < 215) {
                    res[h][w] = '~';
                } else if (grayValue < 230) {
                    res[h][w] = '-';
                } else if (grayValue < 245) {
                    res[h][w] = ',';
                } else if (grayValue < 255) {
                    res[h][w] = '.';
                } else if (grayValue == 255) {
                    res[h][w] = ' ';
                } else {
                    throw new RuntimeException("ASCIIConverter: Gray value error!");
                }
            }
        }
        return res;
    }
}
