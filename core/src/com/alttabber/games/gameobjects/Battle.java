package com.alttabber.games.gameobjects;

import com.alttabber.games.gameobjects.enemies.Enemy;
import com.alttabber.games.gameobjects.enemies.EnemyGenerator;
import com.alttabber.games.gameobjects.player.Player;

public class Battle {

    Player player;
    Enemy enemy;
    BattleUI battleUI;

    public static com.alttabber.games.gameobjects.Battle currentBattle;

    public BattleState state = BattleState.NOT_INIT;

    public Battle(Player player, Enemy enemy, BattleUI battleUI) {
        this.player = player;
        this.enemy = enemy;
        this.battleUI = battleUI;

        currentBattle = this;
        getCurrentBattle();
        startPlayerTurn();
    }

    public Battle(Enemy enemy){
        if(currentBattle != null){
            this.player = currentBattle.player;
            this.battleUI = currentBattle.battleUI;
        }
        this.enemy = enemy;
        currentBattle = this;
        getCurrentBattle();
        startPlayerTurn();
    }

    public Battle(){
        this(EnemyGenerator.nextEnemy());
    }

    public static Battle getCurrentBattle(){
        if(currentBattle.state == BattleState.NOT_INIT){
            currentBattle.state = BattleState.STARTED;
        }
        return currentBattle;
    }

    public void playCard(Card card){
        if(this.state == BattleState.PLAYER_TURN) {
            if(this.player.getDeck().getHand().contains(card)){
                card.play();
                player.getDeck().playCard(card);
            }
        }
    }

    public void addToCraft(Card card) {
        if(this.state == BattleState.PLAYER_TURN) {
            if(this.player.getDeck().getHand().contains(card)){
                player.getDeck().moveToCraft(card);
            }
        }
    }

    public void startPlayerTurn(){
        player.clearEffects();
        if(this.state == BattleState.STARTED){
            player.getDeck().draw(4);
        }
        if(this.state == BattleState.ENEMY_TURN || this.state == BattleState.STARTED) {
            this.state = BattleState.PLAYER_TURN;
            System.out.println(this.state);
        }
    }

    public void endTurn(){
        if(this.state == BattleState.PLAYER_TURN){
            this.state = BattleState.ENEMY_TURN;
            System.out.println(this.state);
            if (enemy.getState() == Enemy.EnemyState.ALIVE) {
                enemy.doAction();
            }
            endEnemyTurn();
        }
    }

    public void endEnemyTurn(){
        if(this.state == BattleState.ENEMY_TURN){
            this.state = BattleState.PLAYER_TURN;
            System.out.println(this.state);
            player.clearEffects();
        }
    }

    public void endBattle(){
        this.state = BattleState.END;
    }

    public void addToHand(Card card) {
        player.addToHand(card);
    }

    public BattleUI getBattleUI() {
        return battleUI;
    }




    public enum BattleState{
        NOT_INIT,
        STARTED,
//        BEFORE_PLAYER_TURN,
        PLAYER_TURN,
//        AFTER_PLAYER_TURN,
//        BEFORE_ENEMY_TURN,
        ENEMY_TURN,
//        AFTER_ENEMY_TURN,
        END,
        GAME_OVER;

        @Override
        public String toString() {
            return "BattleState{" + this.name() + "}";
        }
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
