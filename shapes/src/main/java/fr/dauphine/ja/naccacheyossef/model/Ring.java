package fr.dauphine.ja.naccacheyossef.model;

import java.util.ArrayList;

import fr.dauphine.ja.naccacheyossef.view.RingDrawer;


/**
 * Hello world!
 *
 */
public class Ring extends Shape{
	
	private Circle c;
	private int rayonInterne;

	public Ring(Circle c, int rayonInterne) {
		this.c=c;
		this.rayonInterne=rayonInterne;
		super.drawer= new RingDrawer(this);
	}
	
	public Circle getC() {
		return c;
	}
	public int getRayonInterne() {
		return rayonInterne;
	}



	public boolean equals(Object x) {
		if( x instanceof Ring) {
			Ring obj = (Ring)x;
			return obj.c.equals(c) && obj.rayonInterne==this.rayonInterne;
		}
		return false;
	}
	
	public String toString() {
		return c.toString()+" rayonInterne :"+rayonInterne;
	}

	public boolean contains(Point p) {
		return c.contains(p) &&
				Math.sqrt((p.getX()-c.getCenter().getX())*(p.getX()-c.getCenter().getX())+(c.getCenter().getY()-p.getY()))>rayonInterne;
	}
	
	public static boolean contains(Point p, Ring...rings){
		for(Ring r: rings) {
			if(r.contains(p)) return true;
		}
		return false;
	}
	@Override
	public void translate(int dx, int dy) {
		// TODO Auto-generated method stub
		c.translate(dx, dy);
	}

	
}