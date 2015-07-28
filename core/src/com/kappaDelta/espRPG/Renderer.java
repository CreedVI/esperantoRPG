package com.kappaDelta.espRPG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Renderer {
    
    TiledMap tiledMap;
    TiledMapRenderer tiledMapRenderer;
    Camera c;
    KeyListener kl;

    public Renderer(Camera c, KeyListener kl) {
        this.c = c;
        this.kl = kl;

        tiledMap = new TmxMapLoader().load("maps/demoMap.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
    }

    public boolean render() {
        
        Assets.elapsedTime += Gdx.graphics.getDeltaTime();
        
        Gdx.gl.glClearColor(.5f, 0, .5f, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        c.update();
        
        tiledMapRenderer.setView(c.getCamera());
        tiledMapRenderer.render();
        
        if(!kl.handleMovementKeys(c.getCamera())){
            Assets.batch.begin();
            Assets.batch.draw(Assets.mainChar, Player.xPos, Player.yPos);
            Assets.batch.end();
        }
        System.out.println(Player.xPos +", "+ Player.yPos);

        return true;
    }
    
    public static boolean drawMainChar(char keyPressed){
        switch (keyPressed) {
            case 'a':
                System.out.println("a");
                
                Player.facing = 'W';
                Assets.mainChar = Assets.mainCharLeft;
                
                Assets.batch.begin();
                Assets.batch.draw(Assets.walkLeft.getKeyFrame(Assets.elapsedTime, true), Player.xPos, Player.yPos);
                Assets.batch.end();

                break;

            case 's':
                System.out.println("s");
                
                Player.facing = 'S';
                Assets.mainChar = Assets.mainCharForward;
                
                Assets.batch.begin();
                Assets.batch.draw(Assets.walkForward.getKeyFrame(Assets.elapsedTime, true), Player.xPos, Player.yPos);
                Assets.batch.end();

                break;

            case 'd':
                System.out.println("d");

                Player.facing = 'E';
                Assets.mainChar = Assets.mainCharRight;
                
                Assets.batch.begin();
                Assets.batch.draw(Assets.walkRight.getKeyFrame(Assets.elapsedTime, true),Player.xPos, Player.yPos);
                Assets.batch.end();

                break;

            case 'w':
                System.out.println("w");
                
                Player.facing = 'N';
                Assets.mainChar = Assets.mainCharUp;
                
                Assets.batch.begin();
                Assets.batch.draw(Assets.walkUp.getKeyFrame(Assets.elapsedTime, true), Player.xPos, Player.yPos);
                Assets.batch.end();

                break;

            default:
                //Assets.batch.begin();

                //Assets.batch.end();
                break;
        }
        
        return true;
    }
}
