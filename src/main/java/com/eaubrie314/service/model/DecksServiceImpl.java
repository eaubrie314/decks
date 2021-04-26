package com.eaubrie314.service.model;

import javax.inject.Singleton;
import java.util.Collections;

@Singleton
public class DecksServiceImpl implements DecksService {

    @Override
    public Deck createDeck(String name) {
        return new Deck(name, Collections.emptyList());
    }

    @Override
    public Deck shuffleDeck(String name) {
        throw new RuntimeException("fix me");
    }

    @Override
    public void deleteDeck(String name) {
        throw new RuntimeException("fix me");
    }
}
