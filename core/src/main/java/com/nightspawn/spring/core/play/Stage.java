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
	public static final int FLOOR_Y = Spring.SCREENHEIGHT - FLOOR_HEIGHT;
	public static final float GRAVITY = 35.0f;
	private Area floor;
	private Player player;

	public Stage(Player p) {
		floor = new Area(new Dimension(Spring.SCREENWIDTH, 100));
		floor.setBoundaryColor(Color.rgb(0, 0, 0));
		floor.setDrawBoundary(true);
		floor.translate(new Vector(0, FLOOR_Y));
		addChild(floor);

		this.player = p;
		addChild(p);
	}

	@Override
	public void update(float deltams) {
		super.update(deltams);
		// player
		if (player.getWorldBound().maxY() >= FLOOR_Y) {
			// player.land();
		} else {
			// player.translate(new Vector(0.0f, GRAVITY / deltams));
		}
	}
}
