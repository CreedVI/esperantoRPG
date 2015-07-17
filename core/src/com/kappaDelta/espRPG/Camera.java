package com.kappaDelta.espRPG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Camera {
	OrthographicCamera camera;
	
	public Camera() {
		camera = new OrthographicCamera();
		
		float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        
        camera.setToOrtho(false,w,h);
        camera.update();
	}
	
	public boolean update() {
		camera.update();
		return true;
	}
	
	public OrthographicCamera getCamera() {
		return camera;
	}
}
