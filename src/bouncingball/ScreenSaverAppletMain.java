package bouncingball;


import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
//import java.applet.Applet;
//import java.awt.Cursor;
//import java.awt.Event;
//import java.awt.MouseInfo;
//import java.awt.image.BufferedImage;
//import java.util.Random;
//import java.util.TimerTask;
//import javax.swing.Timer;

@SuppressWarnings("serial")
public class ScreenSaverAppletMain extends JFrame  {
	    public static void main(String[] args) {
	    	ScreenSaverAppletMain app = new ScreenSaverAppletMain();
	        app.setVisible(true);
	    }
 
//	public Rectangle rect1;
	public ScreenSaverAppletMain(){
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1360, 720);
//		rect1 = new Rectangle();
//		rect1.x = 100;
//		rect1.y = 100;
//		rect1.width = 100;
//		rect1.height = 100;
		refresh thread= new refresh();	
		thread.myapplet = this;
		thread.start();
	}
	Shape rect1 = new SquareShape(30, 30, 100, Color.red);
	background e=new background();
public void paint(Graphics g){
//	super.paint(g);
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
//	g.setColor(Color.red);
//	g.fillRect(rect1.x,rect1.y,rect1.width,rect1.height);
//	rect2Color=colors[i]; //stops color for being random
	e.draw(g);
	rect1.draw(g);
}
public void animation(Graphics g){
	try{
//		super.paint(g);  
	} catch (NullPointerException e){
	}
}
public class refresh extends Thread{
	public ScreenSaverAppletMain myapplet;
	boolean horizontalposi = true;
    boolean verticalposi = true;
	public int velocity = 1;
	public void run(){
//		myapplet.repaint();
//		animation(myapplet.getGraphics());
		while(true){
		myapplet.repaint();
		animation(myapplet.getGraphics());
		try {
			sleep(2);
			
				if (myapplet.rect1.x <=20){
					horizontalposi = true;
				}
				if (myapplet.rect1.x + myapplet.rect1.width >=1340){
					horizontalposi = false;
				}
				if (myapplet.rect1.y <=40){
					verticalposi = true;
				}
				if (myapplet.rect1.y + myapplet.rect1.width >=700){	
					verticalposi = false;
				}
				if (horizontalposi == true){
					myapplet.rect1.x = myapplet.rect1.x +velocity;
				} else {
					myapplet.rect1.x = myapplet.rect1.x -velocity;
				}
				if (verticalposi == true){
					myapplet.rect1.y = myapplet.rect1.y +velocity;
				} else {
					myapplet.rect1.y = myapplet.rect1.y -velocity;					
				}
				
			} catch (InterruptedException e){
				e.printStackTrace();
			}
}}}}