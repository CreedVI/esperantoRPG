package com.kappaDelta.espRPG;

public class Player {

    // Can the player move (N, E, S, W)?
    boolean canMove = true, canMoveN = true, canMoveE = true, canMoveS = true, canMoveW = true;
    static boolean N = false, E = false, S = false, W = false;

    // In which direction is the player facing (N, E, S, W)?
    // S as default value so char sprite is facing the camera.
    static char facing = 'S';

    static int speed = 2; // Player speed in tiles per second
    static int pcoWidth = 32; // Player Controlled Object (PCO) is 32 pixels tall 
    static int pcoHeight = 32; // Player Controlled Object (PCO) is 32 pixels wide
    static int xPos = Assets.w/2 - (pcoWidth/2);
    static int yPos = Assets.h/2;

    public void setFacing(char direction) {
        facing = direction;
    }

    public char getFacing() {
        return facing;
    }

    public boolean canMove(char direction) {
        boolean status = false;

        switch (direction) {
            case 'N':
                status = canMoveN;
                break;
            case 'E':
                status = canMoveE;
                break;
            case 'S':
                status = canMoveS;
                break;
            case 'W':
                status = canMoveW;
                break;
            case 'X':
                status = canMove;
                break; // 'X' stands for general canMove
        }

        return status;
    }

    public boolean canMove() {
        return canMove('X'); // Return the general canMove if no direction is given
    }
    
    public int getY(){
        return yPos;
    }
    
    public int getX(){
        return xPos;
    }
    
    public static void moveChar(char direction){
        
        switch(direction){
            case 'N':
                if(yPos + pcoHeight < Assets.h){
                    yPos += speed;
                }
                break;
            
            case 'E':
                if(xPos + pcoWidth < Assets.w){
                    xPos += speed;
                }
                break;
            
            case 'S':
                if(yPos > 0){
                    yPos -= speed;
                }
                break;
                
            case 'W':
                if(xPos > 0){
                    xPos -= speed;
                }
                break;
                
            default:
                break;
        }
        
    }
    
}
