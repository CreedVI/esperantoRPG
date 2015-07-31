package com.kappaDelta.espRPG;

import com.badlogic.gdx.Screen;

public class EspRPG implements Screen {

    Renderer r;
    Player p;
    Camera c;
    KeyListener kl;
    Strigo strigo;

    @Override
    public void show() {
        c = new Camera();
        kl = new KeyListener();
        r = new Renderer(c, kl);
        p = new Player();
        strigo = new Strigo();

        Assets.gameWorld.addActor(p);
        Assets.gameWorld.addActor(strigo);
    }

    @Override
    public void render(float delta) {
        r.render();
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

    }

    @Override
    public void dispose() {

    }
}
