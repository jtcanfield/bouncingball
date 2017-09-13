package bouncingball;


import java.awt.Graphics;
import java.awt.Color;

public class background {
	public background(){
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0,0,1360,720);
		g.setColor(Color.white);
		g.fillRect(20,40,1320,660);
    }
}