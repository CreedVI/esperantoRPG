package com.kappaDelta.espRPG;


import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;

import javax.sql.rowset.CachedRowSet;

public class objectDetection {

    public static boolean collide(char direction){

        MapObjects objects = Assets.currentMap.getLayers().get("objects").getObjects();
        MapObjects warps = Assets.currentMap.getLayers().get("transportZones").getObjects();

        switch (direction){
            case 'N':

                for(MapObject object : objects) {
                    if (object instanceof RectangleMapObject) {
                        Rectangle rect = ((RectangleMapObject) object).getRectangle();
                        // do something with rect...
                        //System.out.println("rect at " + rect.x +", "+ rect.y);

                        for(int i = 0 ; i <= Player.pcoWidth; i++) {
                            if (rect.contains(Player.pcoBody.x + i, Player.pcoBody.y + Player.pcoHeight + Player.speed)) {
                                return true;
                            }
                        }

                    }
                }

                for(MapObject warp : warps) {
                    if (warp instanceof RectangleMapObject) {
                        Rectangle rect = ((RectangleMapObject) warp).getRectangle();
                        // do something with rect...
                        //System.out.println("warp at " + rect.x +", "+ rect.y);

                        if(rect.contains(Player.pcoBody.x,Player.pcoBody.y)){
                            MapObject mapObject = warp;
                            System.out.println("Change maps");
                            Player.xPos = (int) ((RectangleMapObject) warp).getRectangle().getX();
                            Player.yPos = (int) ((RectangleMapObject) warp).getRectangle().getY() - 1;
                            Cam.camera.translate(((RectangleMapObject) warp).getRectangle().getX(),
                                    ((RectangleMapObject) warp).getRectangle().getY());
                            Renderer.changeMap(mapObject);
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
                        //System.out.println("rect at " + rect.x +", "+ rect.y);

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
                        //System.out.println("rect at " + rect.x + ", " + rect.y);

                        for(int i = 0 ; i <= Player.pcoWidth; i++) {
                            if (rect.contains(Player.pcoBody.x + i, Player.pcoBody.y - Player.speed)) {
                                return true;
                            }
                        }


                    }
                }

                break;

            case 'W':

                for(MapObject object : objects) {
                    if (object instanceof RectangleMapObject) {
                        Rectangle rect = ((RectangleMapObject) object).getRectangle();
                        // do something with rect...
                        //System.out.println("rect at " + rect.x +", "+ rect.y);

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

    public static boolean interact(char direction){

        MapObjects objects;
        String objName, obType;


        if(Assets.currentMap.getLayers().get("interactables") != null) {
            objects = Assets.currentMap.getLayers().get("interactables").getObjects();

            switch (direction) {
                case 'N':

                    for (MapObject object : objects) {
                        if (object instanceof RectangleMapObject) {
                            Rectangle rect = ((RectangleMapObject) object).getRectangle();
                            // do something with rect...
                            System.out.println("rect at " + rect.x + ", " + rect.y);

                            if (rect.contains(Player.pcoBody.x, Player.pcoBody.y + Player.pcoHeight + Player.speed)) {
                                if(object.getProperties().get("Name") != null && object.getProperties().get("Type") != null) {

                                    objName = object.getProperties().get("Name").toString();
                                    obType = object.getProperties().get("Type").toString();

                                    System.out.println(objName + ", " + obType + ", " + rect.x + ", " + rect.y);

                                    npcInteraction.interact(objName, obType);

                                    return true;
                                }
                            }

                        }
                    }

                    break;

                case 'E':

                    for (MapObject object : objects) {
                        if (object instanceof RectangleMapObject) {
                            Rectangle rect = ((RectangleMapObject) object).getRectangle();
                            // do something with rect...
                            System.out.println("rect at " + rect.x + ", " + rect.y);

                            for (int i = 0; i <= Player.pcoHeight; i++) {
                                if (rect.contains(Player.pcoBody.x + Player.pcoWidth + Player.speed, Player.pcoBody.y + i)) {

                                    objName = object.getProperties().get("Name").toString();
                                    obType = object.getProperties().get("Type").toString();

                                    System.out.println(objName + ", " + obType + ", " + rect.x + ", " + rect.y);;

                                    npcInteraction.interact(objName, obType);

                                    return true;
                                }

                            }
                        }
                    }

                    break;

                case 'S':

                    for (MapObject object : objects) {
                        if (object instanceof RectangleMapObject) {
                            Rectangle rect = ((RectangleMapObject) object).getRectangle();
                            // do something with rect...
                            System.out.println("rect at " + rect.x + ", " + rect.y);

                            if (rect.contains(Player.pcoBody.x, Player.pcoBody.y - Player.speed)) {

                                objName = object.getProperties().get("Name").toString();
                                obType = object.getProperties().get("Type").toString();

                                System.out.println(objName + ", " + obType + ", " + rect.x + ", " + rect.y);

                                npcInteraction.interact(objName, obType);

                                return true;
                            }

                        }
                    }

                    break;

                case 'W':

                    for (MapObject object : objects) {
                        if (object instanceof RectangleMapObject) {
                            Rectangle rect = ((RectangleMapObject) object).getRectangle();
                            // do something with rect...
                            System.out.println("rect at " + rect.x + ", " + rect.y);

                            for (int i = 0; i <= Player.pcoHeight; i++) {
                                if (rect.contains(Player.pcoBody.x - Player.speed, Player.pcoBody.y + i)) {

                                    objName = object.getProperties().get("Name").toString();
                                    obType = object.getProperties().get("Type").toString();

                                    System.out.println(objName + ", " + obType + ", " + rect.x + ", " + rect.y);

                                    npcInteraction.interact(objName, obType);

                                    return true;
                                }

                            }
                        }
                    }

                    break;

                default:
                    break;
            }
        }

        return false;
    }

}
