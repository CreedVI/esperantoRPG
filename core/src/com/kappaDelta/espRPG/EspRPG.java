package com.kappaDelta.espRPG;

import com.badlogic.gdx.Screen;

public class EspRPG implements Screen {

    Renderer r;
    Player p;
    Camera c;
    KeyListener kl;

    @Override
    public void show() {
        c = new Camera();
        kl = new KeyListener();
        r = new Renderer(c, kl);
        p = new Player();
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
        
        Assets.gamePaused = true;

    }

    @Override
    public void resume() {

        Assets.gamePaused = false;

    }

    @Override
    public void hide() {

        dispose();

    }

    @Override
    public void dispose() {

        Assets.dispose();

    }
}
