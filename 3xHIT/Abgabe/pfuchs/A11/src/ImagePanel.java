import javax.swing.*;
import java.awt.*;

/**
 * Adds a background-image<br>
 * Unused in this program though
 * 
 * @author Peter Fuchs
 * @version 21 Dec 2016
 */
@SuppressWarnings("serial")
class ImagePanel extends JComponent {
    private Image image;
    
    /**
     * Constructor
     * 
     * @param image the image
     */
    public ImagePanel(Image image) {
        this.image = image;
    }
    
    /**
     * Paints the image
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
