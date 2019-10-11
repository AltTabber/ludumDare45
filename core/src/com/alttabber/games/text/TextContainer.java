package com.alttabber.games.text;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class TextContainer {

    private static BitmapFont buttonPrimaryFont;
    private static BitmapFont labelHeaderFont;
    private static GlyphLayout layout = new GlyphLayout();

    public static BitmapFont getButtonFont(){
        if(buttonPrimaryFont == null) {
            FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/CormorantUnicase-Bold.ttf"));
            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
            parameter.size = 30;
            parameter.color = new Color(0x5c4e4bff);
            buttonPrimaryFont = generator.generateFont(parameter);
        }
        return buttonPrimaryFont;
    }

    public static BitmapFont getHeaderLabelFont(){
        if(labelHeaderFont == null) {
            FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/YesevaOne-Regular.ttf"));
            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
            parameter.size = 24;
            parameter.borderWidth = 4;
            parameter.borderStraight = true;
            parameter.borderColor = new Color(0x5c4e4bff);
            parameter.spaceX = -2;
            parameter.color = new Color(0xf6d4b5ff);
            labelHeaderFont = generator.generateFont(parameter);
        }
        return labelHeaderFont;
    }

    public static GlyphLayout getLayout() {
        return layout;
    }
}
