package com.makhabatusen.lesson_1.ui;

import android.app.AlertDialog;
import android.content.Context;

import com.makhabatusen.lesson_1.R;
import com.makhabatusen.lesson_1.domain.Card;
import com.makhabatusen.lesson_1.domain.Game;

import java.util.List;


public class EmojiGame {
    private final Game<String> game;
    private final Context context;

    public EmojiGame(Context context) {
        this.context = context;
        game = new Game<>(List.of("🐶", "🐱", "🐼"));

    }

    public void choose(Card<String> card) {
        game.choose(card);
        if (game.isGameFinished()) {
            message();
        }
    }

    private void message() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(R.layout.dialog).show();
    }

    public List<Card<String>> getCards() {
        return game.getCards();
    }


}
