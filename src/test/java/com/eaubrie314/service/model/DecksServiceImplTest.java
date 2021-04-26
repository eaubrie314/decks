package com.eaubrie314.service.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertEquals ("createdDeck", result.getName());
        
    }
}