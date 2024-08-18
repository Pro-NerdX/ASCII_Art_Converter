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
                if (grayValue < 20) {
                    res[h][w] = '@';
                } else if (grayValue < 35) {
                    res[h][w] = '&';
                } else if (grayValue < 50) {
                    res[h][w] = '$';
                } else if (grayValue < 65) {
                    res[h][w] = '§';
                } else if (grayValue < 80) {
                    res[h][w] = '%';
                } else if (grayValue < 95) {
                    res[h][w] = '€';
                } else if (grayValue < 110) {
                    res[h][w] = '#';
                } else if (grayValue < 125) {
                    res[h][w] = '?';
                } else if (grayValue < 140) {
                    res[h][w] = '+';
                } else if (grayValue < 155) {
                    res[h][w] = '*';
                } else if (grayValue < 170) {
                    res[h][w] = '°';
                } else if (grayValue < 185) {
                    res[h][w] = '=';
                } else if (grayValue < 200) {
                    res[h][w] = '~';
                } else if (grayValue < 215) {
                    res[h][w] = '-';
                } else if (grayValue < 230) {
                    res[h][w] = ';';
                } else if (grayValue < 245) {
                    res[h][w] = ',';
                } else if (grayValue < 254) {
                    res[h][w] = '.';
                } else if (grayValue < 256) {
                    res[h][w] = ' ';
                } else {
                    throw new RuntimeException("ASCIIConverter: Gray value error!");
                }
            }
        }
        return res;
    }
}
