/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package panel;

import java.awt.Component;
import java.awt.Graphics2D;

/**
 *
 * @author frans
 */
public abstract class DispSubcomponent extends Component{

    Component parent_component;

    public DispSubcomponent (Component parent_component){

        this.parent_component = parent_component;

    }

    public abstract void paint(Graphics2D g2);
}
