package com.kappaDelta.espRPG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Cam extends Camera {

    static OrthographicCamera camera;

    public Cam() {
        camera = new OrthographicCamera();

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera.setToOrtho(false, w, h);
        camera.update();
    }

    public void update() {
        camera.update();
    }

    @Override
    public void update(boolean updateFrustum) {

    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public static void checkBounds(char direction) {
        if (direction == 'N' || direction == 'S') {
            if (Player.yPos == Assets.h / 2) {
                switch (direction) {
                    case 'N':

                        if (camera.position.y + (Assets.h / 2) >= Assets.mapPixelHeight) {
                            Player.yPos += Player.speed;
                            Player.pcoBody.y += Player.speed;
                        }
                        else {
                            camera.translate(0, 2);
                            Player.pcoBody.y += Player.speed;
                        }
                        break;

                    case 'S':
                        //check for y limit
                        if (camera.position.y - (Assets.h / 2) <= 0) {
                            
                            Player.yPos -= Player.speed;
                            Player.pcoBody.y -= Player.speed;

                        }
                        else {
                            camera.translate(0, -2);
                            Player.pcoBody.y -= Player.speed;
                        }
                        break;

                    default:
                        break;
                }
            }

            else if (Player.yPos != Assets.h / 2 ) {
                Player.moveChar(direction);
            }
        }

        else if (direction == 'E' || direction == 'W') {
            if (Player.xPos == Assets.w / 2) {
                switch (direction) {
                    case 'E':
                        if (camera.position.x + (Assets.w / 2) >= Assets.mapPixelWidth) {
                            Player.xPos += Player.speed;
                            Player.pcoBody.x += Player.speed;
                        }
                        else {
                            camera.translate(2, 0);
                            Player.pcoBody.x += Player.speed;
                        }
                        break;
                        
                    case 'W':

                        //check for x limit
                        if (camera.position.x - (Assets.w / 2) <= 0) {
                            Player.xPos -= Player.speed;
                            Player.pcoBody.x -= Player.speed;
                        }
                        else {
                            camera.translate(-2, 0);
                            Player.pcoBody.x -= Player.speed;
                        }
                        break;

                    default:
                        break;
                }
            }

            else if (Player.xPos != Assets.w / 2) {
                Player.moveChar(direction);
            }
        }
    }
}

