package com.kappaDelta.espRPG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Renderer {

    static TiledMapRenderer tiledMapRenderer;
    Cam c;
    KeyListener kl;
    static Stage gameMenu;
    static Table menuTable;

    Texture arrow;

    public Renderer(Cam c, KeyListener kl) {
        this.c = c;
        this.kl = kl;

        arrow = new Texture(Gdx.files.internal("UISkin/TmpBG/selectArrow.png"));

        tiledMapRenderer = new OrthogonalTiledMapRenderer(Assets.currentMap);
    }



    public boolean render() {

        Assets.elapsedTime += Gdx.graphics.getDeltaTime();

        Gdx.gl.glClearColor(.5f, 0, .5f, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        c.update();

        tiledMapRenderer.setView(c.getCamera());
        tiledMapRenderer.render();

       if(Assets.gamePaused){
           kl.handleMainControls();

           gameMenu.act(Assets.elapsedTime);
           gameMenu.draw();

           Assets.batch.begin();
           Assets.batch.draw(arrow, Assets.arrowX, Assets.arrowY[Assets.arrowYIndex]);
           Assets.batch.end();


           System.out.println(Assets.menuOptions[Assets.optionIndex]);

       }

       else if(Assets.textShowing){

           Assets.batch.begin();
           Assets.batch.draw(Assets.mainChar, Player.xPos, Player.yPos);
           Assets.batch.end();

           Assets.gameStage.act();
           Assets.gameStage.draw();

       }

       else{

           if(!kl.handleMainControls()){
               Assets.batch.begin();
               Assets.batch.draw(Assets.mainChar, Player.xPos, Player.yPos);
               Assets.batch.end();
           }

       }

        return true;
    }

    public static boolean changeMap(MapObject mapObject){

        String map = mapObject.getProperties().get("Destination").toString();

        if(map == "cave1"){

            Assets.currentMap = Assets.caveMap;
            tiledMapRenderer = new OrthogonalTiledMapRenderer(Assets.currentMap);

            return true;

        }

        else if(map == "world"){

            Assets.currentMap = Assets.worldMap;
            tiledMapRenderer = new OrthogonalTiledMapRenderer(Assets.currentMap);

            return true;

        }

        else {

            return false;

        }
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

                Image bg = new Image(new Texture(Gdx.files.internal("UISkin/TmpBG/menuBG.png")));
                bg.setPosition(0, 0);

                Image layout = new Image(new Texture(Gdx.files.internal("UISkin/TmpBG/mainPauseMenuLayout.png")));
                layout.setPosition(0, 0);

                Image sideBar = new Image(new Texture(Gdx.files.internal("UISkin/TmpBG/menuSideBarComplete_UP.png")));
                sideBar.setPosition(607, 64);


                //ImageButton party = new ImageButton(Drawable btnUp, Drawable btnDown);

                gameMenu.addActor(bg);
                gameMenu.addActor(layout);
                gameMenu.addActor(sideBar);

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

                Gdx.app.getApplicationListener().dispose();

                gameMenu.dispose();
                Assets.dispose();

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
