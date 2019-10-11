package com.alttabber.games.gameobjects.enemies.actions;

import com.alttabber.games.gameobjects.enemies.EnemyAction;
import com.alttabber.games.gameobjects.player.Player;

public class AttackAction implements EnemyAction {

    private float damage;
    private Player player;

    public AttackAction() {
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    @Override
    public void doAction() {
        this.player.minusHP(damage);
    }

}
