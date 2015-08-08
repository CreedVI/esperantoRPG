package com.kappaDelta.espRPG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Renderer {
    
    TiledMap tiledMap;
    TiledMapRenderer tiledMapRenderer;
    Camera c;
    KeyListener kl;
    static Stage gameMenu;
    static Table menuTable;

    public Renderer(Camera c, KeyListener kl) {
        this.c = c;
        this.kl = kl;

        tiledMap = new TmxMapLoader().load("maps/demoMap.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
    }



    public boolean render() {

       if(Assets.gamePaused){
           kl.handleMainControls();

           Sprite bg = new Sprite(new Texture(Gdx.files.internal("UISkin/TmpBG/menuBG.png")));

           bg.setPosition(0, 0);

           Sprite layout = new Sprite(new Texture(Gdx.files.internal("UISkin/TmpBG/mainPauseMenuLayout.png")));
           layout.setPosition(0, 0);

           Assets.batch.begin();
           bg.draw(Assets.batch);
           layout.draw(Assets.batch);
           Assets.batch.end();

           gameMenu.act(Assets.elapsedTime);
           gameMenu.draw();

           System.out.println(Assets.menuOptions[Assets.optionIndex]);

       }

       else{

           Assets.elapsedTime += Gdx.graphics.getDeltaTime();

           Gdx.gl.glClearColor(.5f, 0, .5f, 1);
           Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
           Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

           c.update();

           tiledMapRenderer.setView(c.getCamera());
           tiledMapRenderer.render();

           if(!kl.handleMainControls()){
               Assets.batch.begin();
               Assets.batch.draw(Assets.mainChar, Player.xPos, Player.yPos);
               Assets.batch.end();
           }

       }

        return true;
    }

    public static boolean showMenu(char menu){

        /*
        m = main
        p = party
        i = inventory
        d = dictionary
        q = quests
        o = options
        e = quit
         */

        gameMenu = new Stage(new ScreenViewport());
        menuTable = new Table();

        switch (menu){

            case 'm':

                menuTable.align(Align.top | Align.center);
                menuTable.setWidth(Assets.w);
                menuTable.setPosition(0, Assets.h);

                //ImageButton party = new ImageButton(Drawable btnUp, Drawable btnDown);

                gameMenu.addActor(menuTable);

                Assets.gamePaused = true;
                System.out.println("Paused");

                break;

            case 'p':
                break;

            case 'i':
                break;

            case 'd':
                break;

            case 'q':
                break;

            case 'o':
                break;

            case 'e':

                Assets.dispose();
                gameMenu.dispose();


                System.exit(0);

                break;

            default:
                break;
        }

        return true;
    }

    public static boolean hideMenu(){

        gameMenu.clear();
        gameMenu.dispose();

        Assets.gamePaused = false;
        System.out.println("Resumed");

        return true;
    }

    public static boolean drawMainChar(char keyPressed){
        switch (keyPressed) {
            case 'a':
                System.out.println("a");
                
                Assets.batch.begin();
                Assets.batch.draw(Assets.walkLeft.getKeyFrame(Assets.elapsedTime, true), Player.xPos, Player.yPos);
                Assets.batch.end();

                break;

            case 's':
                System.out.println("s");
                
                Assets.batch.begin();
                Assets.batch.draw(Assets.walkForward.getKeyFrame(Assets.elapsedTime, true), Player.xPos, Player.yPos);
                Assets.batch.end();

                break;

            case 'd':
                System.out.println("d");
                
                Assets.batch.begin();
                Assets.batch.draw(Assets.walkRight.getKeyFrame(Assets.elapsedTime, true),Player.xPos, Player.yPos);
                Assets.batch.end();

                break;

            case 'w':
                System.out.println("w");
                
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
