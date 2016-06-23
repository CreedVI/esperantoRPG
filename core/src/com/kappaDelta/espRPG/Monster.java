package com.kappaDelta.espRPG;

import com.badlogic.gdx.Gdx;

public class Monster  {

    String species, element;
    static int stats[] = new int[6];
    static int atk,def,spd,mgkAtk,mgkDef,acc; //Attack, Defence, Speed, Magic Attack,Magic Defence, Accuracy

    public Monster(int rand){

        Gdx.app.log("Random Number","" + rand );

        switch(rand){

            case 0:
                species = "Rare thing";
                break;
            case 1:
            case 2:
            case 3:
                species = "Big Rat";
                break;
            case 4:
            case 5:
            case 6:
                species = "Goblin";
                break;
            case 7:
            case 8:
            case 9:
                species = "Faerie";
                break;
        }

        setStats();

    }

    public static void setStats(){

        int stat = (Random.getOnes() + Player.getLevel())/2;
        atk = stat;

        stat = (Random.getOnes() + Player.getLevel())/2;
        def = stat;

        stat = (Random.getOnes() + Player.getLevel())/2;
        spd = stat;

        stat = (Random.getOnes() + Player.getLevel())/2;
        mgkAtk = stat;

        stat = (Random.getOnes() + Player.getLevel())/2;
        mgkDef = stat;

        stat = (Random.getOnes() + Player.getLevel())/2;
        acc = stat;

        Gdx.app.log("stats","Attack: "+atk+"\n"+
                "Defence: "+def+"\n"+
                "Speed: "+spd+"\n"+
                "Magic Attack: "+mgkAtk+"\n"+
                "Magic Defence: "+mgkDef+"\n"+
                "Accuracy: "+acc+"\n");

    }

}
