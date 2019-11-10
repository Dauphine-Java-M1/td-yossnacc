package fr.dauphine.ja.naccacheyossef.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.dauphine.ja.naccacheyossef.model.*;

public class MouseController implements MouseMotionListener {
	public World w;
	public JFrame frame;

	public MouseController(World w, JFrame frame) {
		// TODO Auto-generated constructor stub
		this.w = w;
		this.frame = frame;
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		Point p = new Point(e.getX(), e.getY());
		int i = 0;
		for (Shape s : w.getShapes()) {
			if (s.contains(p)) {
				w.getShapes().get(i).translate(e.getX(), e.getY());
				frame.repaint();
				return;
			}
			i++;
		}
	}

	public void mouseMoved(MouseEvent e) {
		w.getShapes().get(w.getShapes().size()-1).translate(e.getX(), e.getY());
		frame.repaint();
	}

}
