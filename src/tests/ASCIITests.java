package tests;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import logic.OutputFileGenerator;
import logic.image.ASCIIConverter;
import logic.image.GrayScaler;

public class ASCIITests extends Tests {

    private void sendHelp(final String inFileName, final String outFileName) {
        final File inputFile = new File(this.inputPath + inFileName);
        final File outputFile = new File(this.outputPath + outFileName);
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
    
    /**
     * emoji.png is of size 400 x 400
     */
    @Test
    public void asciiFromPngTest() {
        this.sendHelp("emoji.png", "emojiPng.txt");
    }

    /**
     * emoji.jpg is of size 840 x 859
     */
    @Test
    public void asciiFromJpgTest() {
        this.sendHelp("emoji.jpg", "emojiJpg.txt");
    }

    /**
     * stonks.webp is of size 316 x 316
     */
    @Test(expected = RuntimeException.class)
    public void asciiFromWebpTest() {
        this.sendHelp("stonks.webp", "stonksWebp.txt");
    }

    /**
     * bobRoss.jpg is of size 402 x 402
     */
    @Test
    public void asciiFromDetailedImageTest() {
        this.sendHelp("bobRoss.jpg", "bobRossDetailedJpg.txt");
    }
}
