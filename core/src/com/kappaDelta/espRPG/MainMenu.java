package com.kappaDelta.espRPG;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenu implements Screen {

    Stage menu;
    Skin uiskin;
    TextButton button0,button1,button2;
    Table table;

    @Override
    public void show() {

        setup();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        menu.act();
        menu.draw();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        menu.dispose();

    }

    public boolean setup(){

        table = new Table();

        menu = new Stage(new ScreenViewport());
        uiskin = new Skin(Gdx.files.internal("UISkin/uiskin.json"));

        button0 = new TextButton("New Game", uiskin, "default");
        button1 = new TextButton("Continue", uiskin, "default");
        button2 = new TextButton("Settings", uiskin, "default");

        button0.setWidth(200f);
        button0.setHeight(50f);

        button1.setWidth(200f);
        button1.setHeight(50f);

        button2.setWidth(200f);
        button2.setHeight(50f);

        table.setWidth(Assets.w);
        table.align(Align.center | Align.top);
        table.setPosition(0, Assets.h);

        table.padTop(32);
        table.add(button0).padBottom(32);
        table.row();
        table.add(button1).padBottom(32);
        table.row();
        table.add(button2);


        button0.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y){
                ((Game) Gdx.app.getApplicationListener()).setScreen(new EspRPG());
            }
        });

        menu.addActor(table);

        Gdx.input.setInputProcessor(menu);

        return true;
    }

}
