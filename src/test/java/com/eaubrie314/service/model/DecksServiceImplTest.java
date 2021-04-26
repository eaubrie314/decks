package com.eaubrie314.service.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DecksServiceImplTest {

    DecksService service;

    @BeforeEach
    void setUp() {
        service = new DecksServiceImpl();
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