package com.kappaDelta.espRPG;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class Game extends ApplicationAdapter {

    float halfW;
    float halfH;
    
    @Override
    public void create() {
        halfW = Gdx.graphics.getWidth()/2;
        halfH = Gdx.graphics.getHeight()/2;
        Assets.load();

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Assets.batch.begin();
        Assets.batch.draw(Assets.charSprite, halfW-16, halfH-16);
        Assets.batch.end();
    }
}
