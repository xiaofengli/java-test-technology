package com.webbertech.java.genericmore;
import java.util.List;
import java.util.ArrayList;

public class Canvas {
   
    public void draw(Shape s) {
        s.draw(this);
    }
    
    public void drawAll(List<? extends Shape> shapes) {
        for (Shape s: shapes) {
            s.draw(this);
       }
    }
    
    public void addRectangle(List<? extends Shape> shapes) {
        // Compile-time error!
    	Shape r = new Rectangle();
        //shapes.add(0, r);
    }
    
    public static void main(String[] args) {
    	Canvas c = new Canvas();
    	Circle circle = new Circle(); 
    	Rectangle rectangle = new Rectangle();
    
    	//c.draw(circle);
    	//c.draw(rectangle);
    	
    	List<Shape> shapes = new ArrayList<>();
    	shapes.add(circle);
    	shapes.add(rectangle);
    	c.drawAll(shapes);
    	
    	List<Circle> circles = new ArrayList<>();
    	c.drawAll(circles);
    }
}