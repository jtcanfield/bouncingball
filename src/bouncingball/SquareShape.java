package bouncingball;


import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class SquareShape extends Shape {
	public SquareShape(int x, int y, int width, Color color){
		super.x=x;
		super.y=y;
		super.width=width;
		super.height=width;
		super.color=color;
		super.clicked=clicked;
	}
	boolean horizontalposi = true;
    boolean verticalposi = true;
    boolean horivelocposi = true;
    boolean verticalVELOCITYposi = true;
	int horivelocity = 1;
	int vertivelocity = 1;
	public void draw(Graphics g){
		//WHEN THEY HIT EACH OTHER, THEY SHOULD EXPLODE AND HAVE PHYICS FOR THE REMAING PEIECES
		if (clicked == false){
    		//HORIZONTAL
    		if (x <=20){
    			horizontalposi = true;
    		}
    		if (x + width >=1340){
    			horizontalposi = false;
    		}
    		if (horizontalposi == true){
    			x = x +horivelocity;
    		} else {
    			x = x -horivelocity;
    		}
    		//VERTICAL
    		if (y <=40){
    			verticalposi = true;
    			verticalVELOCITYposi = true;
    		}
    		if (y + width >=700){	
    			verticalposi = false;
    			verticalVELOCITYposi = false;
    		}
    		if (vertivelocity == 0){
    			verticalVELOCITYposi = true;
    			verticalposi = true;
    		}
    		if (verticalVELOCITYposi == true && vertivelocity <= 30){
    			vertivelocity = vertivelocity +1;
    		} else if (verticalVELOCITYposi == false && vertivelocity >= 0){
    			vertivelocity = vertivelocity -1;
    		}
    		if (vertivelocity <= 1 && y + width >=700){
    			vertivelocity = 0;
    		}
    		if (verticalposi == true){
    			y = y +vertivelocity;
    		} else {
    			y = y -vertivelocity;
    		}
    	} else if (clicked == true) {
    		//Its not going to do anything while its being dragged
    	}
		g.setColor(color);
		g.fillRect(x,y,width,height);
	}
}