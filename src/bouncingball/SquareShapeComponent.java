package bouncingball;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

public class SquareShapeComponent extends Shape {
	public SquareShapeComponent(int x, int y, int width, Color color){
		super.x=x;
		super.y=y;
		super.width=width;
		super.height=width;
		super.color=color;
	}
	boolean clicked = false;
	boolean horizontalposi = true;
    boolean verticalposi = true;
    boolean horivelocposi = true;
    boolean verticalVELOCITYposi = true;
	int horivelocity = 1;
	int vertivelocity = 1;
//	public void click() {
//    	this.addMouseListener(new MouseAdapter() {
//            public void mousePressed(MouseEvent evt) {
//            	clicked = true;
//            }
//            public void mouseReleased(MouseEvent evt) {
//            	clicked = false;
//            }
//        });
//    	this.addMouseMotionListener(new MouseMotionAdapter() {
//            public void mouseDragged(MouseEvent evt) {
//            	clicked = true;
//            }
//        });
//    }
    public void paintComponent(Graphics g) {
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
    		if (verticalposi == true){
//    			y = y +vertivelocity;
    		} else {
//    			y = y -vertivelocity;
    		}
    	}
        Graphics2D graphics2d = (Graphics2D) g;
        graphics2d.setColor(color);
        graphics2d.fillRect(x,y,width,height);
        super.paintComponent(g);
    }
}