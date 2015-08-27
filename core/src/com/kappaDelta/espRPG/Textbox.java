package com.kappaDelta.espRPG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.XmlReader;

import java.io.File;
import java.io.IOException;

public class Textbox {

    static Dialog dialog;

    public Textbox(String title, Skin skin, String iDunno, String message, byte i){

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

    public Textbox(final String title, final Skin skin, final String NPCName){

        dialog = new Dialog(title, skin) {

            @Override
            public float getPrefWidth() {
                return Assets.w;
            }

            @Override
            public void setPosition(float x, float y) {
                super.setPosition(0, 0);
            }



            @Override
            protected void result(final Object object) {


                if(object == "positive" || object == "true"){

                    new Textbox(title, skin, NPCName, object.toString());

                }
                else if(object == "negative" || object == "false"){

                    //new Textbox(title, skin, NPCName, object.toString());
                    dialog.clear();
                    loadXMLDialog(NPCName, object.toString());

                }
                else if(object == "exit") {

                    Assets.textShowing = false;
                    System.out.println("Chosen: " + object);
                    dialog.clear();
                }


            }

        };

        loadXMLDialog(NPCName);

        dialog.setMovable(false);

        dialog.setPosition(0, 0);

        dialog.show(Assets.gameStage);

        Gdx.input.setInputProcessor(Assets.gameStage);

    }

    /*
    WHERE YOU LEFT OFF

    YOU WERE WORKING ON REFORMING THE XML DIALOGUE METHOD
    SO IT COULD DO FOR MULTIPLE DIALOGUES
    AS WELL AS WORKING OUT THE DIALOGUE TREE BUSINESS
    SO YEAH
    GOOD LUCK
    CARLOS SHOULD BE ABLE TO HELP OUT SOME TOO
     */

    public Textbox(String title, Skin skin, String NPCName, String response){

        dialog = new Dialog(title, skin) {

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

                if(object == "positive" || object == "true"){

                }
                else if(object == "negative" || object == "false"){

                }
                else if(object == "exit") {

                    Assets.textShowing = false;
                    System.out.println("Chosen: " + object);
                    dialog.clear();
                }

            }

        };

        loadXMLDialog(NPCName, response);

        dialog.setMovable(false);

        dialog.setPosition(0, 0);

        dialog.show(Assets.gameStage);

        Gdx.input.setInputProcessor(Assets.gameStage);

    }

    private String loadXMLDialog(String speaker, String attitude){

        XmlReader xmlReader = new XmlReader();
        File textFile;
        String message = "";
        XmlReader.Element root = null;
        String options[][] ={
                {"",""},
                {"",""},
                {"",""}
        };

        textFile = new File(Gdx.files.internal("XML/Dialog/"+speaker+".xml").toString());

        if(textFile.exists()){
            Gdx.app.log("file found", "found speaker's xml file");

            try {
                root = xmlReader.parse(Gdx.files.internal("XML/Dialog/" + speaker + ".xml"));

                if(attitude == "negative"){

                    message = root.getChildByName("NegativeReply").getAttribute("Message");

                    options[0][0] = root.getChildByName("NegativeReply").getChildByName("btn1").get("Text");
                    options[0][1] = root.getChildByName("NegativeReply").getChildByName("btn1").get("Return");

                    options[1][0] = root.getChildByName("NegativeReply").getChildByName("btn2").get("Text");
                    options[1][1] = root.getChildByName("NegativeReply").getChildByName("btn2").get("Return");

                    options[2][0] = root.getChildByName("NegativeReply").getChildByName("btn3").get("Text");
                    options[2][1] = root.getChildByName("NegativeReply").getChildByName("btn3").get("Return");
                }

                else if(attitude == "positive"){

                    message = root.getChildByName("PositiveReply").getAttribute("Message");

                    options[0][0] = root.getChildByName("PositiveReply").getChildByName("btn1").get("Text");
                    options[0][1] = root.getChildByName("PositiveReply").getChildByName("btn1").get("Return");

                    options[1][0] = root.getChildByName("PositiveReply").getChildByName("btn2").get("Text");
                    options[1][1] = root.getChildByName("PositiveReply").getChildByName("btn2").get("Return");

                    options[2][0] = root.getChildByName("PositiveReply").getChildByName("btn3").get("Text");
                    options[2][1] = root.getChildByName("PositiveReply").getChildByName("btn3").get("Return");
                }

            } catch (IOException e){
                e.printStackTrace();
            }

            Gdx.app.log("Message: ", message);

            dialog.text(message);
            if(options[0][0] != "" && options[0][1] != "") {
                dialog.button(options[0][0], options[0][1]);
            }
            if(options[1][0] != "" && options[1][1] != "") {
                dialog.button(options[1][0], options[1][1]);
            }
            if(options[2][0] != "" && options[2][1] != "") {
                dialog.button(options[2][0], options[2][1]);
            }

        }

        return message;
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

                Gdx.app.log("GET", "btn1");
                options[0][0] = root.getChildByName("Greeting").getChildByName("btn1").getAttribute("Text").toString();
                options[0][1] = root.getChildByName("Greeting").getChildByName("btn1").getAttribute("Return").toString();

                Gdx.app.log("GET", "btn2");
                options[1][0] = root.getChildByName("Greeting").getChildByName("btn2").getAttribute("Text").toString();
                options[1][1] = root.getChildByName("Greeting").getChildByName("btn2").getAttribute("Return").toString();

                Gdx.app.log("GET", "btn3");
                options[2][0] = root.getChildByName("Greeting").getChildByName("btn3").getAttribute("Text").toString();
                options[2][1] = root.getChildByName("Greeting").getChildByName("btn3").getAttribute("Return").toString();

            } catch (IOException e){
                e.printStackTrace();
            }

            Gdx.app.log("Message", message);

            dialog.text(message);

            for(byte i = 0; i < 3;i++){
                for(byte o = 0; o < 2;o++){

                    System.out.println(options[i][o]);

                }
            }

            if(options[0][0] != "" && options[0][1] != "") {
                dialog.button(options[0][0], options[0][1]);
            }
            if(options[1][0] != "" && options[1][1] != "") {
                dialog.button(options[1][0], options[1][1]);
            }
            if(options[2][0] != "" && options[2][1] != "") {
                dialog.button(options[2][0], options[2][1]);
            }
        }

        return message;
    }

}
