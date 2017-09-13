package bouncingball;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Shape extends JPanel {
	public int x;
	public int y;
	public int width;
	public int height;
	public Color color;
	public boolean clicked;
	public void move(int changeInX, int changeInY){
        x += changeInX;
        y += changeInY;
	}
    public void paintComponent(Graphics g) {
    	//must be overridden in the subclass
    }
	public boolean canmove(int changeInX, int changeInY){
		//must be overridden in the subclass
		return false;
	}
	public void draw(Graphics g){
		//must be overridden in the subclass
	}
}