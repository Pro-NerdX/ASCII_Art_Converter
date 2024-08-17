package logic.image;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * for testing only
 */
public class Display extends ImageLoader {
    
    public Display() {}

    public void display() {
        if (this.image == null) {
            throw new RuntimeException("Display error: No image has been loaded!");
        }
        final JFrame frame = new JFrame();
        final JLabel label = new JLabel();
        frame.setSize(
            this.image.getWidth(),
            this.image.getHeight() 
        );
        label.setIcon(new ImageIcon(this.image));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
