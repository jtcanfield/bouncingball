package bouncingball;


import java.awt.Color;
import java.awt.Graphics;

public class Shape {
	public int x;
	public int y;
	public int width;
	public int height;
	public Color color;
	public void move(int changeInX, int changeInY){
        x += changeInX;
        y += changeInY;
	}
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