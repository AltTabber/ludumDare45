package com.alttabber.games.gameobjects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.TYPE })
public @interface Consumable {

    public Class<? extends Card> card1();

    public Class<? extends Card> card2();

}
