package fr.dauphine.ja.naccacheyossef.model;

import java.util.ArrayList;
import java.util.Observable;
import fr.dauphine.ja.naccacheyossef.view.MyDisplay;

public class World {
	public ArrayList<Shape> shapes;

	public World() {
		// TODO Auto-generated constructor stub
		shapes = new ArrayList<Shape>();
		shapes.add(new Circle(new Point(100,50),50));
		shapes.add(new Ring(new Circle(new Point (50,50),50),10));
		shapes.add(new Circle (new Point(300,100),100));
	}
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	
}
