package com.alttabber.games.gameobjects;

import com.alttabber.games.cards.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardFactory {

    private static List<Class<? extends Card>> cards;

    private static List<Class<? extends Card>> craftableCards;

    public static void initCards() {
        cards = new ArrayList<>();
        putCard(StickCard.class);
        putCard(RockCard.class);
        putCard(HerbsCard.class);
        putCard(BarkCard.class);
        putCard(IronOreCard.class);
       putCard(WaterCard.class);
//       putCard(FireCard.class);
        putCard(MushroomCard.class);
//       putCard(SandCard.class);
    }

    public static void initCraftable() {
        craftableCards = new ArrayList<>();
        craftableCards.add(StoneSpearCard.class);
        craftableCards.add(StoneKnifeCard.class);
        craftableCards.add(AttackPotionCard.class);
        craftableCards.add(PoisonDaggerCard.class);
        craftableCards.add(HealingPotionCard.class);
        craftableCards.add(BucklerCard.class);
    }


    public static Class<? extends Card> getCraftedCard(Card card1, Card card2) {
        for (Class<? extends Card> cardClass : craftableCards) {
            if (cardClass.isAnnotationPresent(Consumable.class)) {
                Consumable consumable = cardClass.getAnnotation(Consumable.class);
                if ((card1.getClass().equals(consumable.card1()) && card2.getClass().equals(consumable.card2())) ||
                        (card2.getClass().equals(consumable.card1()) && card1.getClass().equals(consumable.card2()))) {
                    return cardClass;
                }
            }
        }
        return JunkCard.class;
    }

    public static void putCard(Class<? extends Card> clazz) {
        cards.add(clazz);
    }

    public static Card getRandomCard() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<? extends Card> cardClass;
        if (cards.size() > 1)
            cardClass = cards.get(new Random().nextInt(cards.size()));
        else {
            cardClass = cards.get(0);
        }

        Card card = cardClass.getConstructor().newInstance();

        return card;
    }

}
