/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package panel;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
 *
 * @author frans
 */
public class HorizonLine extends DispSubcomponent{

    int x1;
    int x2;
    int y1;
    int y2;

    int xpoints[] = {x1, x2, 293, 0};
    int ypoints[] = {y1, y2, 265, 265};
    int npoints = 4;

    public HorizonLine (Component parent_component){
       super(parent_component);
       this.calculateHorizonLine();
    }
    public void paint(Graphics2D g2) {
        HorizonLineLine horizon = new HorizonLineLine();
        horizon.paint(g2);
    }
    public void calculateHorizonLine() {
        float alfa = 0;
        double tangente_of_alfa = Math.tan(Math.toRadians((double) alfa));

        if ((alfa >= -45 && alfa <= 45) || (alfa >= 135 && alfa <= 225) || (alfa >= 315 && alfa <= 360))
        {
            x1= 0;
            x2 = 293;
            y1 = 125 + ((int) (125 * tangente_of_alfa));
            y2 = 250 - y1;

        }
        else if (alfa > 45 && alfa < 135 )
        {
            y1 = 300;
            y2 = 0;
            x1 = 150 - ((int) (150 / tangente_of_alfa));
            x2 = 300 - x1;
        }
        else
        {
            x1 = 0;
            y1 = 150;
            x2 = 300;
            y2 = 150;
        }
        xpoints[0] = x1;
        xpoints[1] = x2;
        xpoints[2] = 293;
        xpoints[3] = 0;

        ypoints[0] = y1;
        ypoints[1] = y2;
        ypoints[2] = 265;
        ypoints[3] = 265;
    }
    class HorizonLineLine extends JPanel{
        Graphics2D g2;
        public void paint(Graphics g) {

            g2 = (Graphics2D) g;
            g2.setColor(new Color(102, 104, 46));
            g2.fillPolygon (xpoints, ypoints, npoints);

            Line2D lin = new Line2D.Float(x1, y1, x2, y2);
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(0.5f,1,1));
            g2.draw(lin);
        }
    }
}
