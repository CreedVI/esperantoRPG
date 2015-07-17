package com.kappaDelta.espRPG;

import com.badlogic.gdx.ApplicationAdapter;

public class Game extends ApplicationAdapter {
	Renderer r;
	Player p;
	Camera c;
	KeyListener kl;
        
	@Override
	public void create () {
		c = new Camera();
		kl = new KeyListener();
		r = new Renderer(c, kl);
		p = new Player();
	}

	@Override
	public void render () {
		r.render();
	}
}
