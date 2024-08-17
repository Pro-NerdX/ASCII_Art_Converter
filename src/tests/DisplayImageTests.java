package tests;

import org.junit.Test;

import logic.image.Display;

public class DisplayImageTests extends Tests {

    @Test
    public void displaySpherePngTest() {
        final Display display = new Display();
        display.loadImage(this.inputPath + "sphere.png");
        display.display();
        this.waitForIt(3);
    }
}
