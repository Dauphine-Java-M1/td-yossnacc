package fr.dauphine.ja.naccacheyossef.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;


/**
 * Hello world!
 *
 */
public class LigneBrisee {
	
	private LinkedList<Point> listPoints;
	//private int nbMaxPoint;
	
	public LigneBrisee(/*int nbMaxPoint*/) {
		this.listPoints =new LinkedList<Point>();
		//this.nbMaxPoint=nbMaxPoint;
	
	}
	
	public void add(Point p) {
		Objects.requireNonNull(p, "ne peut ajouter un point null");
		listPoints.add(p);
	}
	
	public int nbPoints() {
		return listPoints.size();
	}
	
	public boolean contains(Point p) {
		Objects.requireNonNull(p, "ne peut être null");
		return listPoints.contains(p);
	}
	
	/*public void add (Point p) {
		Point tmp =Objects.requireNonNull(p);
		if(tmp==null) return;
		for(Point point : listPoints) {
			if(point==null) {
				point=p;
				return;
			}
		}
	}
	
	public int pointCapacity() {
		return nbMaxPoint;
	}
	
	public int nbPoints() {
		int nb=0;
		for(Point point : listPoints) {
			if(point==null) nb+=1;
		}
		return nb;
	}
	
	public boolean contains(Point p) {
		Point tmp =Objects.requireNonNull(p);
		if(tmp==null) return false;
		for(Point point: listPoints) {
			if(point.equals(p)) return true;
		}
		return false;
	}*/
	
	
}

