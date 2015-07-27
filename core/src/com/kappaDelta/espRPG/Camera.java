package com.kappaDelta.espRPG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Camera {

    static OrthographicCamera camera;

    public Camera() {
        camera = new OrthographicCamera();

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera.setToOrtho(false, w, h);
        camera.update();
    }

    public boolean update() {
        camera.update();
        return true;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
    
    public static void checkBounds(char direction){
        
        switch(direction){
            case 'N':
                
                if(camera.position.y + (Assets.h/2) >= Assets.mapPixelHeight){
                    
                }
                else{
                    camera.translate(0,2);
                }
                break;
                
            case 'E':
                if(camera.position.x + (Assets.w/2) >= Assets.mapPixelWidth){
                    
                }
                else{
                    camera.translate(2,0);
                }
                break;
                
                
            case 'S':
                //check for y limit
                if(camera.position.y - (Assets.h/2) <= 0){
                   /*if(camera.position.y - (Assets.h/2) < 0){

                   } 
                   else{

                   }*/
                }
                else{
                    camera.translate(0, -2);
                }
                break;
                
            case 'W':
                
                 //check for x limit
                if(camera.position.x - (Assets.w/2) <= 0){
                        /*if(camera.position.x - (Assets.w/2) < 0){

                        }
                        else{

                        }*/
                    }  
                else{
                    camera.translate(-2, 0);
                }
                break;
                
            default:
                break;
        }
        
    }
}
