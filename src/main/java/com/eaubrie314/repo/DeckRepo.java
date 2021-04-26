package com.eaubrie314.repo;

import com.eaubrie314.service.model.Deck;

public interface DeckRepo {
    Deck getDeck(String deckName);
    void deleteDeck(String deckName);
    Deck saveDeck(Deck saveDeck);
}
