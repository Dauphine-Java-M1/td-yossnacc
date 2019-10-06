package fr.dauphine.ja.naccacheyossef.shapes;

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
	
    public static void main( String[] args )
    {
    	Point p = new Point(5,6);
    	System.out.println(p);
    	System.out.println(nb);

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
	
	
}
