package fr.dauphine.ja.naccacheyossef.model;

import java.util.ArrayList;

import fr.dauphine.ja.naccacheyossef.view.CircleDrawer;


/**
 * Hello world!
 *
 */
public class Circle extends Shape {
	
	private Point center;
	private int rayon;
	
	public Circle(Point center, int rayon) {
		super();
		this.center = center;
		this.rayon = rayon;
		super.drawer=new CircleDrawer(this);
	}
	
	public int getRayon() {
		return rayon;
	}

	public String toString() {
		return "centre :"+center.toString()+"rayon:"+rayon+" surface :"+this.surface();
	}
	
	public void translate(int dx,int dy) {
		center.translate(dx, dy);
	}
	
	public Point getCenter() {
		return center;
	}
	public double surface() {
		return Math.pow(rayon, 2)*Math.PI;
	}
	
	public boolean contains(Point p) {

		return Math.sqrt((p.getX()-center.getX())*(p.getX()-center.getX())+(center.getY()-p.getY()))<rayon;
	}
	
	public static boolean contains (Point p, Circle...circles) {
		for(Circle c: circles) {
			if(c.contains(p)) return true;
		}
		return false;
	}
	
}