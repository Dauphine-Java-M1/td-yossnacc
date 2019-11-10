package fr.dauphine.ja.naccacheyossef.view;

import java.awt.Graphics;

import fr.dauphine.ja.naccacheyossef.model.Ring;


public class RingDrawer extends Drawer{
	public Ring r;

	public RingDrawer(Ring r) {
		this.r=r;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawOval(r.getC().getCenter().getX(),r.getC().getCenter().getY(),r.getC().getRayon(),r.getC().getRayon());
		g.drawOval(r.getC().getCenter().getX()+r.getRayonInterne(),r.getC().getCenter().getY()+r.getRayonInterne(),
				(r.getC().getRayon())-r.getRayonInterne()*2,(r.getC().getRayon())-r.getRayonInterne()*2);
	}

}
