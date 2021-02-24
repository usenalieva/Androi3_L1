package com.makhabatusen.lesson_1.domain;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game<Content> {

    private final List<Card<Content>> cards = new ArrayList<>();
    private Card<Content> card;
    private boolean isGameFinished = false;


    public boolean isGameFinished() {
        return isGameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        isGameFinished = gameFinished;
    }

    public Game(List<Content> contents) {
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>((i * 2) + 1, false, false, contents.get(i)));
            cards.add(new Card<>(i * 2, false, false, contents.get(i)));
        }
        Collections.shuffle(cards);
    }

    public void choose(Card<Content> card) {
        card.setFaceUp(!card.isFaceUp());
        checkPairs(card);
        remove();
        gameFinished();
    }


    private void gameFinished() {
        if (cards.isEmpty()) {
            setGameFinished(true);
        }
    }

    private void checkPairs(Card<Content> card) {
        this.card = card;
        for (Card<Content> anotherCard : cards) {
            if (card.isFaceUp() && anotherCard.isFaceUp()) {
                if (card.equals(anotherCard)
                        && card.getId() != anotherCard.getId()) {
                    card.setMatched(true);
                    anotherCard.setMatched(true);
                    Log.e("ololo", "MATCH!");
                } else if (!card.equals(anotherCard)) {
                    card.setFaceUp(false);
                    anotherCard.setFaceUp(false);
                    Log.e("ololo", "FACE DOWN!");
                }
            }
        }
    }

    private void remove() {
        List<Card<Content>> resultCards = new ArrayList<>(cards);
        for (Card<Content> c : cards) {
            if (c.isMatched())
                resultCards.remove(c);
        }
        cards.clear();
        cards.addAll(resultCards);
    }

    public List<Card<Content>> getCards() {
        return cards;
    }
}
