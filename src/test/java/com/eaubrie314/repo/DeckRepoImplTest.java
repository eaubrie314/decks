package com.eaubrie314.repo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.eaubrie314.service.model.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DeckRepoImplTest {

    DeckRepo repo;
    DynamoDBMapper mapper;

    @BeforeEach
    void setUp(){
        mapper = mock(DynamoDBMapper.class);
        repo = new DeckRepoImpl(mapper);
    }

    @Test
    void testSaveDeck(){
        Deck expectedDeck = Deck.builder().name("savedDeck")
                .cards(Collections.emptyList()).build();
        repo.saveDeck(expectedDeck);
    }
}