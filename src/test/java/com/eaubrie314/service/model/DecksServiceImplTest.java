package com.eaubrie314.service.model;

import com.eaubrie314.repo.DeckRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DecksServiceImplTest {

    DecksService service;
    DeckRepo repo;

    @BeforeEach
    void setUp() {
        repo = mock(DeckRepo.class);
        service = new DecksServiceImpl(repo);
    }

    @Test
    void testCreateDeckSavesDeck() {
        Deck result = service.createDeck("createdDeck");
        verify(repo, times(1)).saveDeck(any());
    }

    @Test
    void testCreatesDeckWithCorrectName() {
        Deck result = service.createDeck("createdDeck");
        assertEquals("createdDeck", result.getName());
    }

    @Test
    void testCreatesFullDeck(){
        List<String> cardNames = Arrays.asList("A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2");
        Deck result = service.createDeck("createdDeck");
        assertTrue(result.getCards().stream()
                .filter(card -> Suit.HEARTS.equals(card.getSuit()))
                .map(Card::getName)
                .collect(Collectors.toList()).containsAll(cardNames));
        assertTrue(result.getCards().stream()
                .filter(card -> Suit.CLUBS.equals(card.getSuit()))
                .map(Card::getName)
                .collect(Collectors.toList()).containsAll(cardNames));
        assertTrue(result.getCards().stream()
                .filter(card -> Suit.DIAMONDS.equals(card.getSuit()))
                .map(Card::getName)
                .collect(Collectors.toList()).containsAll(cardNames));
        assertTrue(result.getCards().stream()
                .filter(card -> Suit.SPADES.equals(card.getSuit()))
                .map(Card::getName)
                .collect(Collectors.toList()).containsAll(cardNames));
    }
}