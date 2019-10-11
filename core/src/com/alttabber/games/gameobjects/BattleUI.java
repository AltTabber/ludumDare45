package com.alttabber.games.gameobjects;

import com.alttabber.games.cards.BlankCard;
import com.alttabber.games.cards.ClosedCard;
import com.alttabber.games.gameobjects.player.Player;
import com.alttabber.games.text.Button;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class BattleUI {

    private HandContainer handContainer;
    private Player player;
    private Stage stage;

    Card deckCard;
    Card discardCard;

    Button endTurnButton;
    Button craftButton;
    Button endBattleButton;

    SmithBlock smithBlock;

    public BattleUI(Player player, Stage stage) {
        this.player = player;
        this.stage = stage;

        deckCard = new ClosedCard();
        discardCard = new BlankCard();

        endTurnButton = createEndTurnButton();

        craftButton = createCraftButton();

        endBattleButton = createEndBattleButton();

        handContainer = new HandContainer(player, stage);

        smithBlock = new SmithBlock(player, stage);

    }

    public Button createEndTurnButton(){
        Button button = new Button("End turn", stage);
        button.setXY(1060,260);
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Battle.getCurrentBattle().endTurn();
                com.alttabber.games.gameobjects.BattleUI.this.player.getDeck().draw(3);
            }
        });
        return button;
    }

    public Button createCraftButton(){
        Button button = new Button("Craft", stage);
        button.setXY(1100,350);
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                try {
                    Battle.getCurrentBattle().getPlayer().getDeck().craftCard();
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }
            }
        });
        return button;
    }

    public Button createEndBattleButton(){
        Button button = new Button("Go further", stage);
        button.setXY(1060,260);
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(Battle.getCurrentBattle().state == Battle.BattleState.END) {
                    Battle battle = new Battle();
                }
            }
        });
        return button;
    }

    public void draw(Batch batch){
        deckCard.addToStage(stage);
        deckCard.setXY(1140, 20);
        deckCard.draw(batch);
        deckCard.clearListeners();

        discardCard.addToStage(stage);
        discardCard.setXY(1000, 20);
        discardCard.draw(batch);
        discardCard.clearListeners();

        smithBlock.draw(batch);

        player.draw(batch);

        if(Battle.getCurrentBattle().state == Battle.BattleState.END){
            if(endBattleButton == null){
                endBattleButton = createEndBattleButton();
            }
            endBattleButton.draw(batch);
            if(endTurnButton != null || craftButton != null){
                endTurnButton = null;
                craftButton = null;
            }
        }else{
            if(endTurnButton == null || craftButton == null){
                endTurnButton = createEndTurnButton();
                craftButton = createCraftButton();
            }
            endTurnButton.draw(batch);
            craftButton.draw(batch);
            if(endBattleButton != null){
                endBattleButton = null;
            }
        }

        handContainer.draw(batch, 50, -50);
    }


}
