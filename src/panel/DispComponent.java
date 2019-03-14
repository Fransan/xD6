/**
 *
 * DispComponent.java
 *
 * The root awt component. DispComponent creates and manages painting all
 * elements of the xD6 display. To be implemented: DispComponent also creates
 * and updates DisplayGraphicsConfig
 * which is used by all xD6 elements to determine positions and sizes.
 *
 * To be implemented: This component is notified when new data
 * packets from the flight simulator
 * have been received and performs a repaint. This component is also triggered
 * by UIHeartbeat to detect situations without reception.
 */

package panel;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;



public class DispComponent extends Component {

    ArrayList subcomponents = new ArrayList();
    Graphics2D g2;


    public DispComponent (){

        this.repaint();
        subcomponents.add(new HorizonLine(this));
        subcomponents.add(new PlaneMarker(this));
        subcomponents.add(new PanelFrame(this));
        
    }
    public void paint(Graphics g) {

        drawAll(g);

    }
     public void drawAll(Graphics g) {
         g2 = (Graphics2D)g;

         for (int i=0; i<this.subcomponents.size(); i++) {

            // paint each of the subcomponents
            ((DispSubcomponent) this.subcomponents.get(i)).paint(g2);

        }
     }

}
