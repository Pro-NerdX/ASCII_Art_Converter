package tests;

import java.awt.image.BufferedImage;

import org.junit.Test;

import logic.image.Display;
import logic.image.GrayScaler;

public class GrayScaleTests extends Tests {
    
    @Test
    public void displayGrayScaleSpherePngTest() {
        final GrayScaler gs = new GrayScaler();
        gs.loadImage(this.inputPath + "sphere.png");
        final BufferedImage grayScale = gs.getGrayScale();
        final Display display = new Display();
        display.loadImage(grayScale);
        display.display();
        this.waitForIt(3);
    }
}
