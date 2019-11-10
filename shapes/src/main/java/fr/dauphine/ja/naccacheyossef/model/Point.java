package fr.dauphine.ja.naccacheyossef.model;

import java.util.ArrayList;


/**
 * Hello world!
 *
 */
public class Point 
{
	private int x;
	private int y;
	private static int nbPoint=0;
	
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
		this.nbPoint+=1;
	}
	
	public Point(Point p) {
		this.x=p.x;
		this.y=p.y;
		this.nbPoint+=1;
	}
	
    public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public static int getNbPoint() {
		return nbPoint;
	}

	public String toString() {
		return "("+x+','+y+")\n";
	}
	
	public boolean isSameAs(Point p) {
		return p.x==x && p.y==y;
	}
	
	
	public boolean equals(Object x) {
		if( x instanceof Point) {
			Point obj = (Point)x;
			return obj.x==this.x && obj.y==this.y ;
		}
		return false;
	}	
	
	//Soit considérer de changer les coordonnées du point, soit comme en maths considéré comme étant un nouveau Point
	public void translate(int dx, int dy) {
		this.x=dx;
		this.y=dy;
	}
	
	public static void main( String[] args )
    {
		Point p1=new Point(1,2);
		Point p2=p1;
		Point p3=new Point(1,2);
		System.out.println(p1==p2);
        System.out.println(p1==p3);
        
        System.out.println("Nb de point:"+Point.getNbPoint());
		System.out.print(p1);
        System.out.println("p1 is same as p3 ? :"+p1.isSameAs(p3));
        
        ArrayList<Point> list = new ArrayList<Point>();
        list.add(p1);
        System.out.println(list.indexOf(p2));
        System.out.println(list.indexOf(p3));
        
    }
}
