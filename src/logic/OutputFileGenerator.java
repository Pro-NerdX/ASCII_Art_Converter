package logic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFileGenerator {
    
    final char[][] asciiMatrix;
    final File outputFile;

    public OutputFileGenerator(final char[][] ascii, final File outputFile) {
        this.asciiMatrix = ascii;
        if (outputFile == null) {
            this.outputFile = new File("output.txt");
        } else {
            this.outputFile = outputFile;
        }
    }

    public void writeOutput() throws IOException {
        final FileWriter fileWriter = new FileWriter(this.outputFile);
        for (int h = 0; h < this.asciiMatrix.length; h++) {
            String line = "";
            for (int w = 0; w < this.asciiMatrix[0].length; w++) {
                line += this.asciiMatrix[h][w];
            }
            line += "\n";
            fileWriter.write(line);
        }
        fileWriter.close();
    }
}
