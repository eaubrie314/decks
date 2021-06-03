package com.eaubrie314.repo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.eaubrie314.repo.dao.CardDAO;
import com.eaubrie314.repo.dao.DeckDAO;
import com.eaubrie314.service.model.Deck;

import java.util.stream.Collectors;

public class DeckRepoImpl implements DeckRepo {

    private final DynamoDBMapper mapper;

    public DeckRepoImpl(DynamoDBMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public Deck getDeck(String deckName) {
        throw new RuntimeException("fix me");
    }

    @Override
    public void deleteDeck(String deckName) {
        throw new RuntimeException("fix me");
    }

    @Override
    public Deck saveDeck(Deck saveDeck) {
        DeckDAO newDeck = DeckDAO.builder()
                .deckId(saveDeck.getName())
                .cards(saveDeck.getCards().stream()
                    .map(card -> CardDAO.builder()
                            .name(card.getName())
                            .suit(card.getSuit())
                            .build())
                    .collect(Collectors.toList()))
                .build();
        mapper.save(newDeck);
        return saveDeck;
    }
}
