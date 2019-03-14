/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package panel;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author frans
 */
public class PanelFrame extends DispSubcomponent{
    private BufferedImage frame;

    public PanelFrame (Component parent_component){
        super(parent_component);

        try {
            frame = ImageIO.read(new File("/Users/frans/NetBeansProjects/xD6/src/panel/xD6.png"));
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }


    @Override
    public void paint(Graphics2D g2) {
        drawFrame(g2);
    }
    public void drawFrame(Graphics2D g2){
        g2.drawImage(frame, 0, 0, null);
    }
}
