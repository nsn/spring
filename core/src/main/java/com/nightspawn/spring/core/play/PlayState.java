package com.nightspawn.spring.core.play;

import playn.core.Color;
import playn.core.Surface;
import pythagoras.f.Rectangle;

import com.nightspawn.sg.GroupNode;
import com.nightspawn.sg.Scene;
import com.nightspawn.sg.Spatial;
import com.nightspawn.spring.core.GameState;
import com.nightspawn.spring.core.PlayNRenderer;

public class PlayState extends GameState {
	private Player player;
	private Scene scene;

	public PlayState(PlayNRenderer renderer) {
		super(GameState.STATE.PLAY, renderer);
		player = new Player();
		GroupNode<Spatial> root = new GroupNode<Spatial>();
		root.addChild(player);
		scene = new Scene(root);
	}

	@Override
	public void onEntry() {
	}

	@Override
	public void onExit() {
	}

	@Override
	public void paint(Surface surface, Rectangle renderRect, float alpha) {
		surface.clear();
		surface.setFillColor(Color.rgb(255, 255, 255));
		surface.fillRect(0.0f, 0.0f, renderRect.width, renderRect.height);
		renderer.render(scene, renderRect, surface);
	}

	@Override
	public void update(float delta) {
		scene.update(delta);
	}

}
