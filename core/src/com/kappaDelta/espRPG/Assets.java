package com.kappaDelta.espRPG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import javafx.scene.Scene;

import java.awt.event.ActionEvent;

public class Assets {

    static float elapsedTime;
    
    static Player pco;

    static SpriteBatch batch;
    
    static TextureAtlas walkRightSpriteSheet,walkLeftSpriteSheet,
            walkForwardSpriteSheet,walkUpSpriteSheet;

    static Texture mainCharForward,mainCharLeft,mainCharRight,
            mainCharUp,mainChar,strigo;

    
    static Animation walkLeft,walkRight,walkUp,walkForward;
    
    static TiledMap tiledMap;
    
    static MapProperties prop;
    
    static BitmapFont font;
    
    static int w = Gdx.graphics.getWidth();
    static int h = Gdx.graphics.getHeight();
    static int mapWidth, mapHeight, tilePixelWidth, tilePixelHeight, mapPixelWidth, mapPixelHeight;

    static Stage gameWorld;

    public static Action load() {

        gameWorld = new Stage(new ScreenViewport());

        batch = new SpriteBatch();
        
        pco = new Player();
        
        tiledMap = new TmxMapLoader().load("maps/demoMap.tmx");
        prop = tiledMap.getProperties();
        
        mapWidth = prop.get("width", Integer.class);
        mapHeight = prop.get("height", Integer.class);
        tilePixelWidth = prop.get("tilewidth", Integer.class);
        tilePixelHeight = prop.get("tileheight", Integer.class);
        
        mapPixelWidth = mapWidth * tilePixelWidth;
        mapPixelHeight = mapHeight * tilePixelHeight;
        
        walkRightSpriteSheet = new TextureAtlas(Gdx.files.internal("Sprites/MainCharTmp/SpriteSheets/right/StickmanWalkingRight.atlas"));
        walkForwardSpriteSheet = new TextureAtlas(Gdx.files.internal("Sprites/MainCharTmp/SpriteSheets/forward/StickmanWalkingForward.atlas"));
        walkLeftSpriteSheet = new TextureAtlas(Gdx.files.internal("Sprites/MainCharTmp/SpriteSheets/left/StickmanWalkingLeft.atlas"));
        walkUpSpriteSheet = new TextureAtlas(Gdx.files.internal("Sprites/MainCharTmp/SpriteSheets/up/StickmanWalkingUp.atlas"));
        
        walkRight = new Animation(1f / 15f, walkRightSpriteSheet.getRegions());
        walkForward = new Animation(1f/13f, walkForwardSpriteSheet.getRegions());
        walkLeft = new Animation(1f / 15f, walkLeftSpriteSheet.getRegions());
        walkUp = new Animation(1f/13f, walkUpSpriteSheet.getRegions());
        
        mainCharForward = new Texture(Gdx.files.internal("Sprites/MainCharTmp/RawSprites/forward/f0.png"));
        mainCharRight = new Texture(Gdx.files.internal("Sprites/MainCharTmp/RawSprites/right/f0.png"));
        mainCharLeft = new Texture(Gdx.files.internal("Sprites/MainCharTmp/RawSprites/left/f0.png"));
        mainCharUp = new Texture(Gdx.files.internal("Sprites/MainCharTmp/RawSprites/up/f0.png"));
        strigo = new Texture(Gdx.files.internal("Sprites/Animals/S/Strigo.png"));
        
        font = new BitmapFont();
        
        mainChar = mainCharForward;
        return null;
    }

    public static void dispose(){
        batch.dispose();
        font.dispose();

        mainChar.dispose();
        mainCharForward.dispose();
        mainCharLeft.dispose();
        mainCharRight.dispose();
        mainCharUp.dispose();

        walkRightSpriteSheet.dispose();
        walkForwardSpriteSheet.dispose();
        walkLeftSpriteSheet.dispose();
        walkUpSpriteSheet.dispose();

        tiledMap.dispose();
        gameWorld.dispose();
    }
}
