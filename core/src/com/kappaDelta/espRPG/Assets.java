package com.kappaDelta.espRPG;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Assets {
    
    static Player pco;
    
    static SpriteBatch batch;
    
    static Texture img, charSprite;
    
    public static void load(){
        img = new Texture("badlogic.jpg");
        charSprite = new Texture("Sprites/tmpPCO.png");
        batch = new SpriteBatch();
        pco = new Player();
    }
    
}
