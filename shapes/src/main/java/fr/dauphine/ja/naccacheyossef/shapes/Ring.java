package fr.dauphine.ja.naccacheyossef.shapes;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class Ring extends Circle 
{

	private Circle internCircle;

	public Ring(Point center, double externRadius, double internRadius) {
        super(center, externRadius);
        if (externRadius < internRadius) throw new IllegalArgumentException("The radius is not valid !");
        this.internCircle = new Circle(center, internRadius);
    }

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Ring)) return false;
		Ring r = (Ring) obj;
		if (super.getCenter().equals(r.getCenter()) && super.getRadius() == r.getRadius() && this.internCircle.equals(r.internCircle)) return false;
		return true;
	}
	
	@Override
    public String toString() {
        return "(extern circle is : " + super.toString() + ", intern circle is : " + this.internCircle + ")";
    }

	@Override
    public boolean contains(Point p) {
        if(super.contains(p) && !this.internCircle.contains(p)) return true;
        return false;
    }
	
	public static boolean contains(Point p, Ring... rings) {
        for (Ring r : rings) {
            if (r != null && r.contains(p)) {
                return true;
            }
        }
        return false;
    }
}
