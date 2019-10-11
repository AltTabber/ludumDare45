package com.alttabber.games.gameobjects.enemies;

import com.alttabber.games.gameobjects.enemies.actions.AttackAction;
import com.alttabber.games.gameobjects.player.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;

import java.util.UUID;

public class ZombieEnemy extends Enemy {

    private static Texture texture = new Texture(Gdx.files.internal("enemies/enemy_zombie.png"));
    public ZombieEnemy(Player player) {

        this.name = "Zombie";
        this.id = name + "-" + UUID.randomUUID();
        this.enemyTexture = texture;
        this.width = texture.getWidth() / 2.5f;
        this.height = texture.getHeight() / 2.5f;
        setXY(300, 200);
        this.maxHp = 30;
        this.hp = 30;
        this.widthHpBar = 250.f;

        hpBar = new ProgressBar(0.f, this.maxHp, 1.f, false, this.hpBarStyle);
        hpBar.setX(this.x + this.width / 2 - widthHpBar / 2);
        hpBar.setY(650);

        hpBar.setWidth(widthHpBar);

        AttackAction attackAction = new AttackAction();
        attackAction.setDamage(7);
        attackAction.setPlayer(player);

        actions.add(attackAction);
    }

    @Override
    public void doAction() {
        EnemyAction action = actions.remove(0);
        actions.add(action);

        action.doAction();
    }
}
