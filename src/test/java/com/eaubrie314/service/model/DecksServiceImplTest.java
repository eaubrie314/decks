package com.eaubrie314.service.model;

import com.eaubrie314.repo.DeckRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
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
    void testGetDeck() {
        Deck expectedDeck = Deck.builder().name("newDeck")
                .cards(Collections.emptyList()).build();
        when(repo.getDeck(anyString())).thenReturn(expectedDeck);

        Deck result = service.getDeck("newDeck");

        verify(repo).getDeck("newDeck");
        assertEquals(expectedDeck, result);
    }

    @Test
    void testDeleteDeck() {
        service.deleteDeck("newDeck");
        verify(repo).deleteDeck("newDeck");
    }

    @Test
    void testCreateDeckSavesDeck() {
        Deck result = service.createDeck("createdDeck");
        verify(repo, times(1)).saveDeck(any());
    }

    @Test
    void testCreatesDeckWithCorrectName() {
        when(repo.saveDeck(any())).thenAnswer(invocation -> invocation.getArgument(0));
        Deck result = service.createDeck("createdDeck");
        assertEquals("createdDeck", result.getName());
    }

    @Test
    void testCreatesFullDeck(){
        when(repo.saveDeck(any())).thenAnswer(invocation -> invocation.getArgument(0));
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