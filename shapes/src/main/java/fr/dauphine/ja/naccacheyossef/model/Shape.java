package fr.dauphine.ja.naccacheyossef.model;

import fr.dauphine.ja.naccacheyossef.view.Drawer;

public abstract class Shape {
	public Drawer drawer;
	public abstract boolean contains (Point p);
	public abstract void translate(int dx, int dy );
}