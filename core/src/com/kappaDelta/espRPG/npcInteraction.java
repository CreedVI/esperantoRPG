package com.kappaDelta.espRPG;

public class npcInteraction {

    static Textbox textbox;

    public static boolean interact(String name, String type) {

        System.out.println(type + " " + name);

        if (type.equals("testingTree")) {

            System.out.println("Tree found");

            if (name.equals("Frank Sinatra")) {

                System.out.println("Create dialog");

                Assets.textShowing = true;

                 textbox = new Textbox(name + ": ", Assets.uiskin, "dialog", "Are you enjoying this demo, Adventurer?");


                return true;

            }

            else if (name.equals("Sammy Davis Jr")) {

                System.out.println("Create dialog");

                Assets.textShowing = true;

                textbox = new Textbox(name + ": ", Assets.uiskin, "dialog", "Are you enjoying this demo, Adventurer?");

                return true;

            }

            else if (name.equals("Dean Martin")) {

                System.out.println("Create dialog");

                Assets.textShowing = true;

                textbox = new Textbox(name + ": ", Assets.uiskin, "dialog", "Are you enjoying this demo, Adventurer?");

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


