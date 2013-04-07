package com.nightspawn.spring.core.play;

import static playn.core.PlayN.assets;
import playn.core.Color;
import playn.core.Image;
import pythagoras.f.Dimension;
import pythagoras.f.Vector;

import com.nightspawn.sg.GroupNode;
import com.nightspawn.sg.Sprite;

public class Player extends GroupNode<Sprite<Image>> {
	private static final String TEXTURE_PATH = "images/player.png";
	private static final int LEG_FRAMES = 6;
	private static final int LEG_MS_PER_FRAME = 100;
	private static final int TORSO_BOB_MS = 150;
	private static final int TORSO_BOB_PIXELS = 1;
	private static final Dimension legDimension = new Dimension(32f, 20f);
	private static final Vector legOffset = new Vector(0.0f, 11.0f);
	private static final Dimension torsoDimension = new Dimension(32f, 18f);
	private static final Vector torsoOffset = new Vector(0.0f, 46.0f);
	private int currentLegFrame = 0;
	private int legFrameChange = 0;
	private int torsoBob = 0;
	private int torsoBobDirection = 1;
	private Sprite<Image> legs;
	private Sprite<Image> torso;

	public Player() {
		legs = new Sprite<Image>(assets().getImage(TEXTURE_PATH), legDimension,
				legOffset);
		legs.translate(legOffset);
		addChild(legs);

		torso = new Sprite<Image>(assets().getImage(TEXTURE_PATH),
				torsoDimension, torsoOffset);
		torso.translate(new Vector(5.0f, -3.0f));
		torso.setBoundaryColor(Color.rgb(0, 255, 0));

		addChild(torso);

		translate(new Vector(100, 100));
		scale(2.0f);

		setDrawBoundary(true);
		setBoundaryColor(Color.rgb(255, 0, 0));
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		// leg animation
		legFrameChange += delta;
		if (legFrameChange >= LEG_MS_PER_FRAME) {
			currentLegFrame++;
			currentLegFrame %= LEG_FRAMES;
			legs.setFrame(currentLegFrame);
			legFrameChange %= LEG_MS_PER_FRAME;
		}
		// torso animation
		torsoBob += delta;
		torso.translate(new Vector(0.0f, torsoBobDirection * TORSO_BOB_PIXELS
				* torsoBob / TORSO_BOB_MS));
		if (torsoBob >= TORSO_BOB_MS) {
			torsoBob %= TORSO_BOB_MS;
			torsoBobDirection *= -1;
		}
	}
}
