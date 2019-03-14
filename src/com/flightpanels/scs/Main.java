/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flightpanels.scs;

/**
 *
 * @author frans
 */

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

import panel.DispComponent;


public class Main {

    private JFrame xd6_frame;
    private DispComponent disp_ui;
    private Thread receiver_thread;
    private static final short demo_sw_revision = 1;
    private static final short demo_node_id = 255;
    public Receiver receiver;


    public static void main(String[] args) {
        Main D6 = new Main();
        D6.init();
    }

    public void init (){

        receiver = new Receiver(demo_sw_revision, demo_node_id, "localhost",50707, 50707);

        create_UI();

        receiver_thread = new Thread(runner);
	receiver_thread.start();
    }

    public void create_UI() {
        // xD60 master window
        this.xd6_frame = new JFrame("xD60 v 0.1");

        // Exit on Close, otherwise the window will close, but java will still be running
        this.xd6_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TO-DO: icon for window bar
        // TO-DO: menu bar

        this.disp_ui = new DispComponent ();

        this.xd6_frame.getContentPane().add(disp_ui);

        this.xd6_frame.setBackground(new Color(36, 65, 188));
        this.xd6_frame.setSize(new Dimension(294, 265));
        this.xd6_frame.setAlwaysOnTop(true);
        this.xd6_frame.setVisible(true);
    }
    private Runnable runner = new Runnable() {

		public void run() {
			while (true) {
				try {
					Thread.sleep(150);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				receiver.run();
			}
		}
    };

}
