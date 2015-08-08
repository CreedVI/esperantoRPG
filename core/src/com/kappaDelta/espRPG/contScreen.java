package com.kappaDelta.espRPG;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class contScreen implements Screen {

    String fileContents;
    String[] fileData;

    File save;

    @Override
    public void show() {

        cont();

    }

    @Override
    public void render(float delta) {

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

    public void cont(){
        fileData= new String[100];

        save = new File(String.valueOf(Gdx.files.internal("Saves/s001.txt")));

        if(save.exists()){
            System.out.println("file found");

            try {
                fileContents = new Scanner(save).useDelimiter("\\A").next();
            } catch (FileNotFoundException e) {}

            System.out.println(fileContents);

            for(int i = 0; i < fileContents.length();i++){

                String tmp = "";
                int v = 0;

                if(fileContents.charAt(i) != '|'){
                    tmp += fileContents.charAt(i);
                }
                else{
                    fileData[v] = tmp;
                    tmp = "";
                    v++;
                }

            }

            System.out.println(fileData);

        }
        else{
            System.out.println("file not found");
            ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
        }
    }

    public void load(){



    }
}
