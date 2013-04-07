package com.nightspawn.spring.core.play;

import playn.core.Color;
import pythagoras.f.Dimension;
import pythagoras.f.Vector;

import com.nightspawn.sg.Area;
import com.nightspawn.sg.GroupNode;
import com.nightspawn.sg.Spatial;
import com.nightspawn.spring.core.Spring;

public class Stage extends GroupNode<Spatial> {
	private static final int FLOOR_HEIGHT = 100;
	private Area floor;

	public Stage() {
		floor = new Area(new Dimension(Spring.SCREENWIDTH, 100));
		floor.setBoundaryColor(Color.rgb(0, 0, 0));
		floor.setDrawBoundary(true);
		floor.translate(new Vector(0, Spring.SCREENHEIGHT - FLOOR_HEIGHT));
		addChild(floor);
	}

}
