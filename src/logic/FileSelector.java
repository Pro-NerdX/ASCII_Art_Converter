package logic;

import java.io.File;

import javax.swing.JFileChooser;

public class FileSelector {
    
    private File selectedFile = null;

    public FileSelector() {
        // empty constructor
    }

    // START: Constructors for testing
    public FileSelector(final String path) {
        this.selectedFile = new File(path);
    }

    public FileSelector(final File file) {
        this.selectedFile = file;
    }
    // END: Constructors for testing

    public boolean fileHasBeenSelected() {
        return this.selectedFile != null;
    }

    public File getSelectedFileOrNull() {
        return this.selectedFile;
    }

    public void setSelectedFile() {
        this.selectedFile = null;
    }

    public void selectFileTo(final FileOperation fo) {
        final JFileChooser fileChooser = new JFileChooser();
        final int response;
        switch (fo) {
            case OPEN:
                response = fileChooser.showOpenDialog(null);
                break;
            case SAVE:
                response = fileChooser.showSaveDialog(null);
                break;
            default:
                throw new IllegalArgumentException("FileSelector: Invalid FileOperation given!");
        }
        if (response == JFileChooser.APPROVE_OPTION) {
            this.selectedFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
            return;
        }
        this.selectedFile = null;
    }
}
