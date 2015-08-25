package com.kappaDelta.espRPG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.XmlReader;

import java.io.File;
import java.io.IOException;

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

    public Textbox(String title, Skin skin, String NPCName){

        dialog = new Dialog(title, skin) {

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

            }

        };

        loadXMLDialog(NPCName);

        dialog.setMovable(false);

        dialog.setPosition(0, 0);

        dialog.show(Assets.gameStage);

        Gdx.input.setInputProcessor(Assets.gameStage);

    }

    private String loadXMLDialog(String Speaker){

        XmlReader xmlReader = new XmlReader();
        File textFile;
        String message = "";
        XmlReader.Element root = null;
        String options[][] ={
                {"",""},
                {"",""},
                {"",""}
        };

        textFile = new File(Gdx.files.internal("XML/Dialog/"+Speaker+".xml").toString());

        if(textFile.exists()){
            Gdx.app.log("file found","found speaker's xml file");

            try {
                root = xmlReader.parse(Gdx.files.internal("XML/Dialog/" + Speaker + ".xml"));

                message = root.getChildByName("Greeting").getAttribute("Message");

                options[0][0] = root.getChildByName("Greeting").getChildByName("Options").getChildByName("btn1").get("Text");
                options[0][1] = root.getChildByName("Greeting").getChildByName("Options").getChildByName("btn1").get("Return");

            } catch (IOException e){
                e.printStackTrace();
            }

            Gdx.app.log("Message: ", message);

            dialog.text(message);
            dialog.button(options[0][0], options[0][1]);

        }

        return message;
    }

}
