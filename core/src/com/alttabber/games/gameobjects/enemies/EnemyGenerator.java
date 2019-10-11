package com.alttabber.games.gameobjects.enemies;

import com.alttabber.games.gameobjects.player.Player;

import java.util.ArrayList;
import java.util.List;

public class EnemyGenerator {

    private static List<Enemy> enemies = new ArrayList<>();
    private static int i = 0;

    public static void initEnemyGenerator(Player player) {
        enemies.add(new WolfEnemy(player));
        enemies.add(new ZombieEnemy(player));
        enemies.add(new NecromancerEnemy(player));
        i = 0;
    }

    public static Enemy nextEnemy() {
        if (i < enemies.size())
            return enemies.get(i++);
        else
            return null;
    }
}
