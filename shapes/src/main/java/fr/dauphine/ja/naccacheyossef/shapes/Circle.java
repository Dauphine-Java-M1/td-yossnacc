package fr.dauphine.ja.naccacheyossef.shapes;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class Circle 
{

	private Point center;
    private double radius;

	public Circle(Point center, double radius) {
		this.center = new Point(center.getX(),center.getY());
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "point : (" + center.getX() + "," + center.getY() + ") et l'anggle : " + radius;
	}
	
	public void translate(int dx, int dy) {
		this.center.translate(dx, dy);
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double surface() {
        return 3.1415 * this.radius * this.radius;
    }
	
	public boolean contains(Point p) {
        double distance;
        distance = Math.sqrt(Math.pow(p.getX() - this.center.getX(), 2) + Math.pow(p.getY() - this.center.getY(), 2));

        return distance <= this.radius;
    }

	public static boolean contains(Point p, Circle... circles) {
		boolean test = false;
		for (Circle c : circles) {
		    if (c != null && c.contains(p)) {
		        test = true;
		    }
		}
		return test;
	}
	 
	/*@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Point)) return false;
		Point p = (Point) obj;
		if ((x != p.x) || (y != p.y)) return false;
		return true;
	}*/
	
	
}
