package com.kappaDelta.espRPG;


import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;

public class objectDetection {

    public static boolean collide(char direction){

        MapObjects objects = Assets.tiledMap.getLayers().get("objects").getObjects();

        switch (direction){
            case 'N':

                for(MapObject object : objects) {
                    if (object instanceof RectangleMapObject) {
                        Rectangle rect = ((RectangleMapObject) object).getRectangle();
                        // do something with rect...
                        System.out.println("rect at " + rect.x +", "+ rect.y);

                        if(rect.contains(Player.pcoBody.x,Player.pcoBody.y + Player.pcoHeight + Player.speed)){
                            return true;
                        }

                    }
                }

                break;

            case 'E':

                for(MapObject object : objects) {
                    if (object instanceof RectangleMapObject) {
                        Rectangle rect = ((RectangleMapObject) object).getRectangle();
                        // do something with rect...
                        System.out.println("rect at " + rect.x +", "+ rect.y);

                        for(int i = 0 ; i <= Player.pcoHeight; i++) {
                            if (rect.contains(Player.pcoBody.x + Player.pcoWidth + Player.speed, Player.pcoBody.y + i)) {
                                return true;
                            }
                        }

                    }
                }

                break;

            case 'S':

                for(MapObject object : objects) {
                    if (object instanceof RectangleMapObject) {
                        Rectangle rect = ((RectangleMapObject) object).getRectangle();
                        // do something with rect...
                        System.out.println("rect at " + rect.x + ", " + rect.y);

                        if (rect.contains(Player.pcoBody.x, Player.pcoBody.y - Player.speed)) {
                            return true;
                        }


                    }
                }

                break;

            case 'W':

                for(MapObject object : objects) {
                    if (object instanceof RectangleMapObject) {
                        Rectangle rect = ((RectangleMapObject) object).getRectangle();
                        // do something with rect...
                        System.out.println("rect at " + rect.x +", "+ rect.y);

                        for(int i = 0 ; i <= Player.pcoHeight; i++) {
                            if (rect.contains(Player.pcoBody.x - Player.speed, Player.pcoBody.y + i)) {
                                return true;
                            }
                        }

                    }
                }

                break;
        }

        /*for(MapObject object : objects) {
            if (object instanceof RectangleMapObject) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                // do something with rect...
                System.out.println("rect at " + rect.x +", "+ rect.y);
            }
            else if (object instanceof PolygonMapObject) {
                Polygon polygon = ((PolygonMapObject) object).getPolygon();
                // do something with polygon...
            }
            else if (object instanceof PolylineMapObject) {
                Polyline chain = ((PolylineMapObject) object).getPolyline();
                // do something with chain...
            }
            else if (object instanceof CircleMapObject) {
                Circle circle = ((CircleMapObject) object).getCircle();
                // do something with circle...
            }
        }*/

        return false;
    }

    public boolean interact(char direction){

        MapObjects objects = Assets.tiledMap.getLayers().get("objects").getObjects();

        switch(direction){
            case 'N':

                break;

            case 'E':
                break;

            case 'S':
                break;

            case 'W':
                break;

            default:
                break;
        }

        return false;
    }

}
