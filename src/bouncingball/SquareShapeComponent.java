package bouncingball;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

@SuppressWarnings("serial")
public class SquareShapeComponent extends Shape {
	public SquareShapeComponent(int x, int y, int width, Color color){
		super.x=x;
		super.y=y;
		super.width=width;
		super.height=width;
		super.color=color;
		super.clicked=clicked;
		super.flipx=flipx;
		super.flipy=flipy;
	}
	boolean horizontalposi = true;
    boolean verticalposi = true;
    boolean horivelocposi = true;
    boolean verticalVELOCITYposi = true;
	int horivelocity = 1;
	int vertivelocity = 1;
    public void paintComponent(Graphics g) {
    	if (clicked == false){
    		//HORIZONTAL
    		if (x <=20){
    			horizontalposi = true;
    		}
    		if (x + width >=1340){
    			horizontalposi = false;
    		}
    		if(flipx == true){
    			flipx = false; 
    			if (horizontalposi == true){
    				horizontalposi = false;
        		} else {
        			horizontalposi = true;
        		}
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
    		if(flipy == true){
    			flipy = false; 
    			if (verticalposi == true){
    				verticalposi = false;
        		} else {
        			verticalposi = true;
        		}
    		}
    		if (verticalposi == true){
    			y = y +vertivelocity;
    		} else {
    			y = y -vertivelocity;
    		}
    		if (y >= 602){
    			y = 600;
    		}
    	} else if (clicked == true) {
    		//Its not going to do anything while its being dragged
    	}
        Graphics2D graphics2d = (Graphics2D) g;
        graphics2d.setColor(color);
        graphics2d.fillRect(x,y,width,height);
        super.paintComponent(g);
    }
}