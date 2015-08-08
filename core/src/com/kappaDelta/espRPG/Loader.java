package com.kappaDelta.espRPG;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Loader implements Screen {

    private Stage stage = new Stage(new ScreenViewport());

    private Image splash =  new Image(new Texture(Gdx.files.internal("Splash/Splash.png")));
    private Image loadCircle = new Image(new Texture(Gdx.files.internal("Splash/circleLoader.png")));

    @Override
    public void show() {

        System.out.println("Loading....");

        loadCircle.setX((Gdx.graphics.getWidth() / 2) - (loadCircle.getWidth() / 2));
        loadCircle.setY(100f);
        loadCircle.setOrigin(loadCircle.getWidth() / 2, loadCircle.getHeight() / 2);

        stage.addActor(splash);
        stage.addActor(loadCircle);

        Assets.load();

        loadCircle.addAction(Actions.sequence(Actions.rotateBy(-2780, 2.5f), Actions.run(new Runnable() {
            @Override
            public void run() {
                //Assets.load();
                ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
            }
        })));

    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(0,0,0,1f);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
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
        stage.dispose();
    }

}
