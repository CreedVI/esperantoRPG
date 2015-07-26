package com.kappaDelta.espRPG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Assets {

    static float elapsedTime;
    
    static Player pco;

    static SpriteBatch batch;
    
    static TextureAtlas walkRightSpriteSheet,walkLeftSpriteSheet,
            walkForwardSpriteSheet,walkUpSpriteSheet;

    static Texture mainCharForward,mainCharLeft,mainCharRight,
            mainCharUp,mainChar;

    
    static Animation walkLeft,walkRight,walkUp,walkForward;
    
    static TiledMap tiledMap;
    
    static BitmapFont font;
    
    static int w = Gdx.graphics.getWidth();
    static int h = Gdx.graphics.getHeight();

    public static void load() {
        
        batch = new SpriteBatch();
        
        pco = new Player();
        
        tiledMap = new TmxMapLoader().load("maps/demoMap.tmx");
        
        walkRightSpriteSheet = new TextureAtlas(Gdx.files.internal("Sprites/SpriteSheets/right/StickmanWalkingRight.atlas"));
        walkForwardSpriteSheet = new TextureAtlas(Gdx.files.internal("Sprites/SpriteSheets/forward/StickmanWalkingForward.atlas"));
        walkLeftSpriteSheet = new TextureAtlas(Gdx.files.internal("Sprites/SpriteSheets/left/StickmanWalkingLeft.atlas"));
        walkUpSpriteSheet = new TextureAtlas(Gdx.files.internal("Sprites/SpriteSheets/up/StickmanWalkingUp.atlas"));
        
        walkRight = new Animation(1f / 15f, walkRightSpriteSheet.getRegions());
        walkForward = new Animation(1f/13f, walkForwardSpriteSheet.getRegions());
        walkLeft = new Animation(1f / 15f, walkLeftSpriteSheet.getRegions());
        walkUp = new Animation(1f/13f, walkUpSpriteSheet.getRegions());
        
        mainCharForward = new Texture(Gdx.files.internal("Sprites/RawSprites/forward/f0.png"));
        mainCharRight = new Texture(Gdx.files.internal("Sprites/RawSprites/right/f0.png"));
        mainCharLeft = new Texture(Gdx.files.internal("Sprites/RawSprites/left/f0.png"));
        mainCharUp = new Texture(Gdx.files.internal("Sprites/RawSprites/up/f0.png"));

        
        font = new BitmapFont();
        
        mainChar = mainCharForward;
    }
}
