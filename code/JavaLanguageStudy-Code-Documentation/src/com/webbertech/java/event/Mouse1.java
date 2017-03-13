package com.webbertech.java.event;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class Mouse1 extends JFrame implements MouseListener, MouseMotionListener {

	int width, height;
	int mx, my;
	boolean isButtonPressed = false;
	JTextField display;
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		// TODO Auto-generated method stub
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
	    //change background color
		isButtonPressed = true;
		getContentPane().setBackground( Color.red );
		repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public Mouse1() {
		width = this.getWidth();
		height = this.getHeight();
		//set init color to black
		this.getContentPane().setBackground( Color.black );
        mx = width/2;
        my = height/2;
        display = new JTextField("try your mouse");
        display.setEditable(false);
        this.add(display);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setDefaultCloseOperation(getDefaultCloseOperation());
        this.setLocation(mx, 40);
        this.setSize(200, 200);
        this.setVisible(true);
	}
	

    public void paint(Graphics draw){
      //Here you can perform any drawing like an oval...
     

      getContentPane().setBackground(new Color(70,80,70));
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.fillOval(40, 40, 60, 50);
        g.setColor(Color.GREEN);
    }
    
	public static void main(String[] args) {
		Mouse1 m= new Mouse1();
	}
	
	
}
