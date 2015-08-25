package com.kappaDelta.espRPG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class KeyListener implements InputProcessor {

    public KeyListener() {

    }

    public boolean handleMainControls() {
        if (!Assets.gamePaused && !Assets.textShowing) {

            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {

                Player.facing = 'W';
                Assets.mainChar = Assets.mainCharLeft;
                if (!objectDetection.collide('W')) {
                    Renderer.drawMainChar('a');
                    Cam.checkBounds('W');
                    return true;
                }

                return false;
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {

                Player.facing = 'E';
                Assets.mainChar = Assets.mainCharRight;
                if (!objectDetection.collide('E')) {
                    Renderer.drawMainChar('d');
                    Cam.checkBounds('E');
                    return true;
                }

                return false;
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {

                Player.facing = 'N';
                Assets.mainChar = Assets.mainCharUp;
                if (!objectDetection.collide('N')) {
                    Renderer.drawMainChar('w');
                    Cam.checkBounds('N');
                    return true;
                }
                return false;
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {

                Player.facing = 'S';
                Assets.mainChar = Assets.mainCharForward;
                if (!objectDetection.collide('S')) {
                    Renderer.drawMainChar('s');
                    Cam.checkBounds('S');
                    return true;
                }
                return false;
            }
            else if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {

                objectDetection.interact(Player.facing);

            }
            else if (Gdx.input.isKeyJustPressed(Input.Keys.TAB)) {

                Renderer.showMenu('m');

                return true;

            }
        }

        else if(Assets.textShowing){

        }

        else if (Assets.gamePaused) {

            if (Gdx.input.isKeyJustPressed(Input.Keys.W) || Gdx.input.isKeyJustPressed(Input.Keys.UP)) {

                if (Assets.optionIndex == 0) {

                    Assets.optionIndex = Assets.menuOptions.length - 1;
                    Assets.arrowYIndex = Assets.arrowY.length - 1;


                }
                else {

                    Assets.optionIndex--;
                    Assets.arrowYIndex--;

                }
            }

            else if (Gdx.input.isKeyJustPressed(Input.Keys.S)||Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {

                if (Assets.optionIndex == Assets.menuOptions.length - 1) {

                    Assets.optionIndex = 0;
                    Assets.arrowYIndex = 0;

                }

                else {

                    Assets.optionIndex++;
                    Assets.arrowYIndex++;

                }

            }

            else if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){

                /*
                m = main
                p = party
                i = inventory
                d = dictionary
                q = quests
                o = options
                e = quit
                */

                switch(Assets.optionIndex){

                    case 0:

                        Renderer.gameMenu.clear();
                        Renderer.showMenu('p');

                        break;

                    case 1:

                        Renderer.gameMenu.clear();
                        Renderer.showMenu('i');

                        break;

                    case 2:

                        Renderer.gameMenu.clear();
                        Renderer.showMenu('d');

                        break;

                    case 3:

                        Renderer.gameMenu.clear();
                        Renderer.showMenu('q');

                        break;

                    case 4:

                        Renderer.gameMenu.clear();
                        Renderer.showMenu('o');

                        break;

                    case 5:

                        Renderer.gameMenu.clear();
                        Renderer.showMenu('e');

                        break;

                    default:
                        break;

                }

            }


            else if (Gdx.input.isKeyJustPressed(Input.Keys.TAB)) {

                Renderer.hideMenu();

                return true;

            }

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
