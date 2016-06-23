package com.kappaDelta.espRPG;

import com.badlogic.gdx.Gdx;

public class Random {

    static int random;

    public static int getOnes(){

        random = (int) (Math.random()*10);

        if(random == 0){
            random++;
        }

        //Gdx.app.log("Random ones value",""+random);

        return random;
    }

    public static int getTens(){

        random = (int) (Math.random()*100);

        //Gdx.app.log("Random tens value",""+random);

        if(random < 10){
            random += 10;
        }

        return random;
    }

    public static int getHundreds() {

        random = (int) (Math.random()*1000);

        if(random < 100){
            random += 100;
        }

        //Gdx.app.log("Random Hundreds value",""+random);

        return random;
    }

    public static boolean calculateEncounter() {

        //random = (getTens()-2)/(getOnes() + Player.getLevel());

        //Gdx.app.log("Encounter", "" + random);

        /*if(random < 6 && random >3 ) {

            System.out.println("FIGHT!");

            return true;
        }*/

        return false;
    }
}
