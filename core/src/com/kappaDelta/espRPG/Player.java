package com.kappaDelta.espRPG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player {
    
    boolean canMove = true, canMoveN = true, canMoveE = true, canMoveS = true, canMoveW = true;
    
    boolean N = false, E = false, S = false, W = false; //Compass directions North, East, South, West
    char facing = 's'; //Where n = north, e = east,w = west, s = south
    
    int speed = 2; //How fast the player moves
    int pcoWidth = 32; //Player Controled Object (PCO) is 32 pixels tall 
    int pcoHeight = 32; //Player Controled Object (PCO) is 32 pixels wide
    
    void controlls(){
        
        if(canMove){

            if ((Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) && canMoveN) {
                N = true;
                facing = 'n';
                System.out.println("Up");
            } else if ((Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) && canMoveS) {
                S = true;
                facing = 's';
                System.out.println("Down");
            } else if ((Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) && canMoveW) {
                W = true;
                facing = 'w';
                System.out.println("Left");
            } else if ((Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) && canMoveE) {
                E = true;
                facing = 'e';
                System.out.println("Right");
            }
        }
        
    }
    
    void move(){
        if(canMove){
            if(N){
                
            }
            else if(S){
                
            }
            else if(E){
                
            }
            else if(W){
                
            }
        }
    }
}
