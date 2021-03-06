package com.eaubrie314.service.model;

public interface DecksService {
    Deck createDeck(String name);
    Deck shuffleDeck(String name);
    void deleteDeck(String name);
}
