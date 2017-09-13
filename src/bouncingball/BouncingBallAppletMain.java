package bouncingball;

import java.awt.*;
import java.awt.event.*;

//import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
//import java.awt.event.*;
//import java.awt.event.MouseEvent;
//import java.awt.Rectangle;
//import java.applet.Applet;
//import java.awt.Cursor;
//import java.awt.Event;
//import java.awt.MouseInfo;
//import java.awt.image.BufferedImage;
//import java.util.Random;
//import java.util.TimerTask;
//import javax.swing.Timer;
//import javax.swing.border.BevelBorder;
import bouncingball.Shape;
//import bouncingball.JavaPaintUI.Panel2;

//ASK KELLY WHAT DAYS ARE LAB DAYS

@SuppressWarnings("serial")
public class BouncingBallAppletMain extends JFrame /*implements MouseListener*/ {
	boolean dragging = false;
	Shape rect1 = new SquareShape(50, 50, 100, Color.red);
	Shape rect2 = new SquareShape(1000, 500, 100, Color.green);
	Shape rect3 = new SquareShapeComponent(200, 200, 100, Color.black);
	background background=new background();
    public static void main(String[] args) {
    	BouncingBallAppletMain app = new BouncingBallAppletMain();
        app.setVisible(true);
    }
	public BouncingBallAppletMain(){
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setSize(1360, 720);
		refresh thread= new refresh();	
		thread.myapplet = this;
		thread.start();
		jPanel2 = new Panel2();
        jPanel2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
            public void mouseReleased(MouseEvent evt) {
                jPanel2MouseReleased(evt);
            }
        });
        jPanel2.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });

        // add the component to the frame to see it!
        this.setContentPane(jPanel2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
	}
	private JPanel jPanel2;
    class Panel2 extends JPanel {
        Panel2() {
            // set a preferred size for the custom panel.
            setPreferredSize(new Dimension(1360, 720));
        }
    }
	public void paint(Graphics g){
		background.draw(g);
		rect1.draw(g);
		rect2.draw(g);
		rect3.paintComponent(g);
	}
	public void animation(Graphics g){
		try{
	//		super.paint(g);
		} catch (NullPointerException e){
		}
	}
	public class refresh extends Thread{
		public BouncingBallAppletMain myapplet;
		public void run(){
			while(true){
			myapplet.repaint();
			animation(myapplet.getGraphics());
				try {
					sleep(20);
					} catch (InterruptedException e){
						e.printStackTrace();
				}
			}
		}
	}
    public void jPanel2MousePressed(MouseEvent evt) {
    	if ((evt.getX() >= rect3.x && evt.getX() <= rect3.x +100) && (evt.getY() >= rect3.y && evt.getY() <= rect3.y +100)){
    		rect3.x = evt.getX()-50;
        	rect3.y = evt.getY()-50;
    		dragging = true;
    		rect3.clicked = true;
    		System.out.println(rect3.clicked);
    	}
    }
    public void jPanel2MouseDragged(MouseEvent evt) {
    	//Void means the function does not return anything
        if (dragging == true) {
        	rect3.x = evt.getX()-50;
        	rect3.y = evt.getY()-50;
        	System.out.println(rect3.clicked);
        }
    }
    public void jPanel2MouseReleased(MouseEvent evt) {
    	dragging = false;
    	rect3.clicked = false;
    	System.out.println("Released Fired");
    	System.out.println(rect3.clicked);
    }
}