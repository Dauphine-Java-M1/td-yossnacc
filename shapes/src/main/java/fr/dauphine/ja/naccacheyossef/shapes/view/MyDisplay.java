package fr.dauphine.ja.naccacheyossef.shapes.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyDisplay extends JPanel { 

	public static void main(String []args){
		JFrame frame = new JFrame("Java Avanc´e - Graphic Display");
		frame.setSize(new Dimension(500,500));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyDisplay d = new MyDisplay();
		frame.add(d);
	}
	
	public void paintComponent(Graphics g){
		
		 g.drawLine(0, 250, this.getWidth(), 250); 
		 
	}

	
}
