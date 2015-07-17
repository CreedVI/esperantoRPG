package com.kappaDelta.espRPG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Renderer {
	Texture img;
    TiledMap tiledMap;
    TiledMapRenderer tiledMapRenderer;
    Camera c;
    KeyListener kl;
    
	public Renderer(Camera c, KeyListener kl) {
		this.c = c;
		this.kl = kl;
		
        tiledMap = new TmxMapLoader().load("maps/demoMap.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
	}
	
	public boolean render() {
		kl.handleMovementKeys(c.getCamera());
		
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        c.update();
        tiledMapRenderer.setView(c.getCamera());
        tiledMapRenderer.render();
        
		return true;
	}
}