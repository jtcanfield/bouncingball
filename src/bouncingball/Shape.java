package bouncingball;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Shape extends JPanel {
	public int x;
	public int y;
	public int width;
	public int height;
	public Color color;
	public void move(int changeInX, int changeInY){
        x += changeInX;
        y += changeInY;
	}
    public void paintComponent(Graphics g) {
    	//must be overridden in the subclass
    }
//    public void click() {
    	//must be overridden in the subclass
//    }
	public boolean canmove(int changeInX, int changeInY){
		//must be overridden in the subclass
		return false;
	}
	public void draw(Graphics g){
		//must be overridden in the subclass
	}
	public void rotate(int direction){
		//must be overridden in the subclass
	}
}