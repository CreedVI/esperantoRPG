package com.kappaDelta.espRPG;

import com.badlogic.gdx.ApplicationAdapter;

public class Game extends ApplicationAdapter {
	Renderer r;
	Player p;
        
	@Override
	public void create () {
		r = new Renderer();
		p = new Player();
	}

	@Override
	public void render () {
		r.render();
	}
}
