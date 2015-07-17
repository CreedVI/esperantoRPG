package com.kappaDelta.espRPG;

public class Player {
    
	// Can the player move (N, E, S, W)?
    boolean canMove = true, canMoveN = true, canMoveE = true, canMoveS = true, canMoveW = true;
    
    // In which direction is the player facing (N, E, S, W)?
    // N as default value
    char facing = 'N';
    
    int speed = 2; // Player speed in tiles per second
    int pcoWidth = 32; // Player Controlled Object (PCO) is 32 pixels tall 
    int pcoHeight = 32; // Player Controlled Object (PCO) is 32 pixels wide
    
    public void setFacing(char direction) {
    	facing = direction;
    }
    
    public char getFacing() {
    	return facing;
    }
    
    public boolean canMove(char direction) {
    	boolean status = false;
    	
    	switch (direction) {
    	case 'N' : status = canMoveN; break;
    	case 'E' : status = canMoveE; break;
    	case 'S' : status = canMoveS; break;
    	case 'W' : status = canMoveW; break;
    	case 'X' : status = canMove; break; // 'X' stands for general canMove
    	}
    	
    	return status;
    }
    
    public boolean canMove() {
    	return canMove('X'); // Return the general canMove if no direction is given
    }
}
