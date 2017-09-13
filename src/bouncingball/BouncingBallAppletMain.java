package bouncingball;

import java.awt.*;
import java.awt.event.*;
import bouncingball.Shape;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
//import java.awt.geom.Area;
//import javax.swing.BorderFactory;
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
//import bouncingball.JavaPaintUI.Panel2;

//ASK KELLY WHAT DAYS ARE LAB DAYS

@SuppressWarnings("serial")
public class BouncingBallAppletMain extends JFrame /*implements MouseListener*/ {
	boolean dragging = false;
	Shape rect1 = new SquareShapeComponent(50, 50, 100, Color.red);
	Shape rect2 = new SquareShapeComponent(1000, 500, 100, Color.green);
	Shape rect3 = new SquareShapeComponent(200, 200, 100, Color.black);
	background background=new background();
    public static void main(String[] args) {
    	BouncingBallAppletMain app = new BouncingBallAppletMain();
        app.setVisible(true);
    }
	public BouncingBallAppletMain(){
		final Shape [] rectanglesdrawn = new Shape[3];
		rectanglesdrawn[0]=rect1;
		rectanglesdrawn[1]=rect2;
		rectanglesdrawn[2]=rect3;
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setSize(1360, 720);
		refresh thread= new refresh();	
		thread.myapplet = this;
		thread.start();
		jPanelvar = new FullWindowPanel();
		jPanelvar.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jPanel2MousePressed(evt, rectanglesdrawn);
            }
            public void mouseReleased(MouseEvent evt) {
                jPanel2MouseReleased(evt, rectanglesdrawn);
            }
        });
        jPanelvar.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                jPanel2MouseDragged(evt, rectanglesdrawn);
            }
        });
        // add the component to the frame to see it!
        this.setContentPane(jPanelvar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
	}
	private JPanel jPanelvar;
    class FullWindowPanel extends JPanel {
    	FullWindowPanel() {
            // set a preferred size for the custom panel.
            setPreferredSize(new Dimension(1360, 720));
        }
    }
	public void paint(Graphics g){
    	//Void means the function does not return anything
		background.draw(g);
		rect1.paintComponent(g);
		rect2.paintComponent(g);
		rect3.paintComponent(g);
	}
	public void animation(Graphics g){
		try{
	//		super.paint(g);
		} catch (NullPointerException e){
		}
	}
	public boolean intersects(JPanel testa, JPanel testb){
	    Rectangle rectB = testb.getBounds();
	    Rectangle result = SwingUtilities.computeIntersection(testa.getX(), testa.getY(), testa.getWidth(), testa.getHeight(), rectB);
	    return (result.getWidth() > 0 && result.getHeight() > 0);
	}
	public class refresh extends Thread{
		public BouncingBallAppletMain myapplet;
		public void run(){
			while(true){
			myapplet.repaint();
			animation(myapplet.getGraphics());
				try {
					sleep(20);
					final Shape [] rectanglesdrawn = new Shape[3];
					rectanglesdrawn[0]=rect1;
					rectanglesdrawn[1]=rect2;
					rectanglesdrawn[2]=rect3;
					for (Shape selected : rectanglesdrawn) {
						for (Shape secondselected : rectanglesdrawn) {
							if(selected != secondselected){
								System.out.println(intersects(selected, secondselected));
//								if(selected.x+100 == secondselected.x && ((selected.y >= secondselected.y && selected.y <= secondselected.y+100) || (secondselected.y >= selected.y && secondselected.y <= selected.y+100))){
//									selected.flipx = true;
//									secondselected.flipx = true;
//								}
//								if(((selected.y >= secondselected.y && selected.y <= secondselected.y+100) || (secondselected.y >= selected.y && secondselected.y <= selected.y+100)) && ((selected.x >= secondselected.x && selected.x <= secondselected.x+100) || (secondselected.x >= selected.x && secondselected.x <= selected.x+100))){
//									selected.flipy = true;
//									secondselected.flipy = true;
//								}
								if(((selected.y >= secondselected.y && selected.y <= secondselected.y+100) || (secondselected.y >= selected.y && secondselected.y <= selected.y+100)) && ((selected.x >= secondselected.x && selected.x <= secondselected.x+100) || (secondselected.x >= selected.x && secondselected.x <= selected.x+100))){
									secondselected.width = 0;
									secondselected.height = 0;
									secondselected.x = 0;
									secondselected.y = 0;
									secondselected.clicked = true;
								}
							}
						}
			    	}
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	
    public void jPanel2MousePressed(MouseEvent evt, Shape[] rectanglesdrawn) {
    	for (Shape selected : rectanglesdrawn) {
    		//selected is basically each item in the rectanglesdrawn array
    		if ((evt.getX() >= selected.x && evt.getX() <= selected.x +100) && (evt.getY() >= selected.y && evt.getY() <= selected.y +100)){
        		dragging = true;
        		selected.clicked = true;
        	}
    	}
    }
    public void jPanel2MouseDragged(MouseEvent evt, Shape[] rectanglesdrawn) {
        if (dragging == true) {
        	for (Shape selected : rectanglesdrawn) {
        		if (selected.clicked == true){
            		selected.x = evt.getX()-50;
            		selected.y = evt.getY()-50;	
        		}
        	}
        }
    }
    public void jPanel2MouseReleased(MouseEvent evt, Shape[] rectanglesdrawn) {
    	dragging = false;
    	for (Shape selected : rectanglesdrawn) {
    		if (selected.clicked == true){
        		selected.clicked = false;
    		}
    	}
    }
}