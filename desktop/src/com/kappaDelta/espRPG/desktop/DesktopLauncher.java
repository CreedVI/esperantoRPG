package com.kappaDelta.espRPG.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kappaDelta.espRPG.Game;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = 
                new LwjglApplicationConfiguration();

        config.title = "[place holder]";
        config.width = 960;
        config.height = 640;
        config.resizable = false;

        LwjglApplication lwjglApplication = new LwjglApplication(new Game(), config);
    }
}
