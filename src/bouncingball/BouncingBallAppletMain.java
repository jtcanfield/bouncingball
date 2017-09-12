package bouncingball;

import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.*;
//import java.awt.event.*;
//import java.awt.Rectangle;
//import java.applet.Applet;
//import java.awt.Cursor;
//import java.awt.Event;
//import java.awt.MouseInfo;
//import java.awt.image.BufferedImage;
//import java.util.Random;
//import java.util.TimerTask;
//import javax.swing.Timer;

@SuppressWarnings("serial")
public class BouncingBallAppletMain extends JFrame  {
//	public Component rect3 = new SquareShape(50, 50, 100, Color.red);
	Shape rect1 = new SquareShape(50, 50, 100, Color.red);
	Shape rect2 = new SquareShape(1000, 500, 100, Color.green);
	background background=new background();
    public static void main(String[] args) {
    	BouncingBallAppletMain app = new BouncingBallAppletMain();
        app.setVisible(true);
    }
	public BouncingBallAppletMain(){
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1360, 720);
		refresh thread= new refresh();	
		thread.myapplet = this;
		thread.start();
	}
	MouseDragListener MouseDragListener1 = new MouseDragListener(background){
	    void dragReleased(MouseEvent start,MouseEvent end){
	    	System.out.println("Its Been Clicked");
	    	
	    }
	};
	public void paint(Graphics g){
	//	Random r = new Random();
	//	Color [] colors = new Color[9];
	//	colors[0]=Color.black;
	//	colors[1]=Color.blue;
	//	colors[2]=Color.cyan;
	//	colors[3]=Color.magenta;
	//	colors[4]=Color.green;
	//	colors[5]=Color.orange;
	//	colors[6]=Color.pink;
	//	colors[7]=Color.red;
	//	colors[8]=Color.yellow;
	//	int i1 = r.nextInt(8);
	//	g.setColor(colors[i1]);
	//	g.fillRect(rect1.x,rect1.y,rect1.width,rect1.height);
		background.draw(g);
		rect1.draw(g);
		rect2.draw(g);
	}
	public void animation(Graphics g){
		try{
	//		super.paint(g);
//			e.draw(g);
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
}