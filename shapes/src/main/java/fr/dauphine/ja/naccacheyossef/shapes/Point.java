package fr.dauphine.ja.naccacheyossef.shapes;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class Point 
{

	private int x;
	private int y;
	private static int nb = 0;

	public Point(int px, int py) {
		this.x = px;
		this.y = py;
		this.nb = nb+1;
	}
	
	public void translate(int dx, int dy) {
		this.x += dx;
        this.y += dy;
	}
	
    public static void main( String[] args )
    {
    	/*Point p = new Point(5,6);
    	System.out.println(p);
    	System.out.println(nb);*/
    	
    	/*Point p1=new Point(1,2);
    	Point p2=p1;
    	Point p3=new Point(1,2);
    	
    	ArrayList<Point> list = new ArrayList<Point>();
    	list.add(p1);
    	System.out.println(list.indexOf(p2));
    	System.out.println(list.indexOf(p3));*/
    	
    	//boolean test = isSameAs(p1);
    	//System.out.println(test);
    	
    	/*Point p=new Point(1,2);
    	Circle c=new Circle(p,1);
    	Circle c2=new Circle(p,2);
    	c2.translate(1,1);
    	System.out.println(c+" "+c2);*/
    	
    	Circle c=new Circle(new Point(1,2), 1);
    	c.getCenter().translate(1,1);
    	System.out.println(c);


    }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	public static boolean isSameAs(Point p) {
		return (p.x == p.y) ? true : false ;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Point)) return false;
		Point p = (Point) obj;
		if ((x != p.x) || (y != p.y)) return false;
		return true;
	}
	
}
