package com.kappaDelta.espRPG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.utils.Align;

public class npcInteraction {

    static Dialog dialog;

    public static boolean interact(String name, String type) {

        System.out.println(type + " " + name);

        if (type.equals("testingTree")) {

            System.out.println("Tree found");

            if (name.equals("Frank Sinatra")) {

                System.out.println("Create dialog");

                Assets.textShowing = true;

                 dialog = new Dialog("Frank Sinatra:", Assets.uiskin, "dialog") {
                    protected void result (Object object) {

                        Assets.textShowing = false;
                        System.out.println("Chosen: " + object);

                    }
                }.text("Are you enjoying this demo, Adventurer?").button("Yes", true).button("No", false)
                         .show(Assets.gameStage);

                Gdx.input.setInputProcessor(Assets.gameStage);

                return true;

            }

            else if (name.equals("Sammy Davis Jr")) {


                return true;

            }

            else if (name.equals("Dean Martin")) {


                return true;

            }

        }

        else if (type.equals("Enviornmental")) {

            if (name.equals("")) {

            }

        }

        return false;

    }
}


