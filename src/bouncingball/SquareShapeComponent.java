package bouncingball;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class SquareShapeComponent extends Shape {
	public SquareShapeComponent(int x, int y, int width, Color color){
		super.x=x;
		super.y=y;
		super.width=width;
		super.height=width;
		super.color=color;
	}
	
	boolean horizontalposi = true;
    boolean verticalposi = true;
    boolean horivelocposi = true;
    boolean verticalVELOCITYposi = true;
	int horivelocity = 1;
	int vertivelocity = 1;
	@SuppressWarnings("serial")
	JPanel panel = new JPanel(){
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D graphics2d = (Graphics2D) g;
            graphics2d.setColor(color);
            graphics2d.fillRect(x,y,width,height);
            g.setColor(color);
            g.fillRect(x,y,width,height);
            super.paintComponents(g);
        }
    };
	public void draw(Graphics g){
		g.setColor(color);
		g.fillRect(x,y,width,height);
	}
}