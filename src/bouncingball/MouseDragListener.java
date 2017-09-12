package bouncingball;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
//import org.w3c.dom.events.MouseEvent;

public abstract /*static*/ class MouseDragListener extends Shape {
    java.awt.Component component;
//    Shape component;
    MouseEvent dragStart;

    public MouseDragListener(java.awt.Component component) {
        super();
        this.component = component;
        component.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
            	System.out.println("Its Been Clicked");
                dragStart = null;
            }

            public void mouseDragged(MouseEvent e) {
                if (dragStart == null)
                    dragStart = e;
            }
        });
        component.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (dragStart != null) {
//                    dragReleased(dragStart, e);
                }
            }
        });
    }}