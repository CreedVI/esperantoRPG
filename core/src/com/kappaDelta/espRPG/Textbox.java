package com.kappaDelta.espRPG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Textbox {

    static Dialog dialog;

    public Textbox(String title, Skin skin, String iDunno, String message){

        dialog = new Dialog(title, skin, iDunno) {

            @Override
            public float getPrefHeight() {
                return 128;
            }

            @Override
            public float getPrefWidth() {
                return Assets.w;
            }

            @Override
            public void setPosition(float x, float y) {
                super.setPosition(0, 0);
            }



            @Override
            protected void result(Object object) {

                Assets.textShowing = false;
                System.out.println("Chosen: " + object);
                dialog.clear();
                dialog.cancel();

            }

        }.text(message)
            .button("Yes", true).button("No", false);

        dialog.setMovable(false);

        dialog.setPosition(0, 0);

        dialog.show(Assets.gameStage);

        Gdx.input.setInputProcessor(Assets.gameStage);



    }

}
