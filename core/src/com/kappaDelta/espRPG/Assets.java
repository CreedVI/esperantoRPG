package com.kappaDelta.espRPG;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Assets {

    static float timer;
    
    static Player pco;

    static SpriteBatch batch;

    static Texture img, mainChar;

    static TextureRegion mainCharSprite,
            mainCharUp_Still,
            mainCharDown_Still,
            mainCharLeft_Still,
            mainCharRight_Still;
    
    static TiledMap tiledMap;

    public static void load() {
        img = new Texture("badlogic.jpg");
        mainChar = new Texture("Sprites/tmpPCO.png");
        mainCharDown_Still = new TextureRegion(mainChar,0,0,32,32);
        batch = new SpriteBatch();
        pco = new Player();
        tiledMap = new TmxMapLoader().load("maps/demoMap.tmx");
    }

}
