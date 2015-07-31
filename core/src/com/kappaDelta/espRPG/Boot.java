package com.kappaDelta.espRPG;

import com.badlogic.gdx.Game;

public class Boot extends Game {

    @Override
    public void create() {
        System.out.println("Booting....");
        setScreen(new Loader());
    }

}
