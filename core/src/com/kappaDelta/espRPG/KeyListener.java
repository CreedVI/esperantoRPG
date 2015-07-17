package com.kappaDelta.espRPG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class KeyListener implements InputProcessor {
	public KeyListener() {
		
	}
	
	public boolean handleMovementKeys(OrthographicCamera camera) {
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            camera.translate(-8,0);
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            camera.translate(8,0);
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            camera.translate(0,8);
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            camera.translate(0,-8);
        
        return true;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
				return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
