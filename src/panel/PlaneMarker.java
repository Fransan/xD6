/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package panel;

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
public class PlaneMarker extends DispSubcomponent{

    public PlaneMarker (Component parent_component){
       super(parent_component);
    }
    public void paint(Graphics2D g2) {
        drawPlaneMarker(g2);
    }

    public void drawPlaneMarker(Graphics2D g2){
        Shape circle = new Ellipse2D.Float(141.0f, 119.0f, 12.0f, 12.0f);

        Line2D h_line_left = new Line2D.Float(125,125,141,125);
        Line2D h_line_right = new Line2D.Float(153,125,169,125);
        Line2D v_line = new Line2D.Float(147,109,147,119);

        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(3.0f,1,1));
        g2.draw(circle);
        g2.draw(h_line_left);
        g2.draw(h_line_right);
        g2.draw(v_line);
    }

}
