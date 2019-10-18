package fr.dauphine.ja.naccacheyossef.shapes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Hello world!
 *
 */
public class BrokenLine 
{
	
	//private Point points[];
	//private int max;
	private LinkedList<Point> points;
	
	public BrokenLine() {
		points = new LinkedList<Point>();
	}
	
	/*public BrokenLine(int max) {
		this.max = max;
		this.points = new Point[max];
	}*/
	
	public void addPoint(Point p) {
		/*int i = 0;
		for (Point pt : this.points) {	
			if (pt == null) 
				{
					this.points[i]=p;
					break;
				}
			i=i+1;
		}*/
		points.add(p);
	}
	
	public int nbPoints() {
		int i = 0;
		for (Point p : this.points) {	
			if (p != null) 
				{
					i++;
				}
		}
		return i;
	}
	
	/*public int pointCapacity() {
		return this.max+1;
	}*/
	
	public boolean contains(Point p) {
		Objects.requireNonNull(p);
		boolean bool = false;
		for(Point pt : this.points) {
			if (pt.equals(p)) {
				bool = true;
				break;
			}
	  	}
		return bool;
	}
	
    public static void main( String[] args )
    {

    }
}
