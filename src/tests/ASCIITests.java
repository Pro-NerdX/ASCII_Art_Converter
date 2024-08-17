package tests;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import logic.OutputFileGenerator;
import logic.image.ASCIIConverter;
import logic.image.GrayScaler;

public class ASCIITests extends Tests {
    
    /**
     * emoji.png is of size 400 x 400
     */
    @Test
    public void asciiFromPngTest() {
        final File inputFile = new File(this.inputPath + "emoji.png");
        final File outputFile = new File(this.outputPath + "emojiPng.txt");
        final GrayScaler gs = new GrayScaler();
        gs.loadImage(inputFile);
        final BufferedImage grayScaledImg = gs.getGrayScale();
        final ASCIIConverter ac = new ASCIIConverter(grayScaledImg);
        final OutputFileGenerator ofg = new OutputFileGenerator(ac.generateASCIIArt(), outputFile);
        try {
            ofg.writeOutput();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("FAILED: 'asciiFromPngTest'");
        }
    }
}
