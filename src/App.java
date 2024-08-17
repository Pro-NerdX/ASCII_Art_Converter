import java.awt.image.BufferedImage;

import java.io.File;

import logic.FileOperation;
import logic.FileSelector;
import logic.OutputFileGenerator;
import logic.image.ASCIIConverter;
import logic.image.GrayScaler;

public class App {
    public static void main(String[] args) throws Exception {
        // set-up
        final FileSelector fileSelector = new FileSelector();
        final GrayScaler grayScaler = new GrayScaler();

        // main-loop
        while (true) {
            // select file to read
            fileSelector.selectFileTo(FileOperation.OPEN);
            final File file2open = fileSelector.getSelectedFileOrNull();

            // select destination file
            fileSelector.selectFileTo(FileOperation.SAVE);
            final File file2safe = fileSelector.getSelectedFileOrNull();

            // just for safety
            if (file2open == null || file2safe == null) {
                break;
            }

            // gray-scaling
            grayScaler.loadImage(file2open);
            final BufferedImage grayScaledImage = grayScaler.getGrayScale();

            // convert to ASCII-Art
            final ASCIIConverter converter = new ASCIIConverter(grayScaledImage);
            final char[][] asciiArt = converter.generateASCIIArt();

            // write to ouput
            final OutputFileGenerator outputGenerator = new OutputFileGenerator(asciiArt, file2safe);
            outputGenerator.writeOutput();
        }
    }
}
