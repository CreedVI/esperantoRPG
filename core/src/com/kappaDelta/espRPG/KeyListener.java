package com.kappaDelta.espRPG;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class KeyListener implements InputProcessor {

    public KeyListener() {

    }

    public boolean handleMovementKeys() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {

            Player.facing = 'W';
            Assets.mainChar = Assets.mainCharLeft;
            if(!objectDetection.collide('W')) {
                Renderer.drawMainChar('a');
                Camera.checkBounds('W');
                return true;
            }
            
            return false;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {

            Player.facing = 'E';
            Assets.mainChar = Assets.mainCharRight;
            if(!objectDetection.collide('E')) {
                Renderer.drawMainChar('d');
                Camera.checkBounds('E');
                return true;
            }
             
            return false;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {

            Player.facing = 'N';
            Assets.mainChar = Assets.mainCharUp;
            if(!objectDetection.collide('N')) {
                Renderer.drawMainChar('w');
                Camera.checkBounds('N');
                return true;
            }
            return false;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {

            Player.facing = 'S';
            Assets.mainChar = Assets.mainCharForward;
            if(!objectDetection.collide('S')) {
                Renderer.drawMainChar('s');
                Camera.checkBounds('S');
                return true;
            }
            return false;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){

            Player.interact();

        }
        else if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){



        }

        return false;
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
