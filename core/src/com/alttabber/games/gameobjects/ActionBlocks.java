package com.alttabber.games.gameobjects;


import com.badlogic.gdx.math.Rectangle;

public class ActionBlocks {

    private static float enemyBlockWidth = 900;
    private static float enemyBlockHeight = 450;
    private static float enemyBlockX = 0;
    private static float enemyBlockY = 0;
    private static Rectangle enemyBlockRect;

    private static float craftBlockWidth = 400;
    private static float craftBlockHeight = 300;
    private static float craftBlockX = 900;
    private static float craftBlockY = 0;
    private static Rectangle craftBlockRect;

    public static Rectangle getEnemyBlockRect() {
        if(enemyBlockRect == null){
            enemyBlockRect = new Rectangle(enemyBlockX, enemyBlockY, enemyBlockWidth, enemyBlockHeight);
        }
        return enemyBlockRect;
    }

    public static Rectangle getCraftBlockRect(){
        if(craftBlockRect == null){
            craftBlockRect = new Rectangle(craftBlockX, craftBlockY, craftBlockWidth, craftBlockHeight);
        }
        return craftBlockRect;
    }
}
