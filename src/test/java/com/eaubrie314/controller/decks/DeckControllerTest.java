package com.eaubrie314.controller.decks;

import com.eaubrie314.service.model.*;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpMethod;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.simple.SimpleHttpRequest;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@MicronautTest
class DeckControllerTest {

    private static final Deck EXPECTED_DECK = Deck.builder()
            .name("Deck")
            .cards(CollectionUtils.setOf(
                    makeCard()
            ))
            .build();
    @Inject
    @Client("/")
    HttpClient client;
    DecksService service;

    @MockBean(DecksServiceImpl.class)
    DecksService createDecksService() {
        service = Mockito.mock(DecksService.class);
        return service;
    }

    @Test
    void testDecksEndpoint() {
        when(service.createDeck(anyString())).thenReturn()
        String deck = "CardDeck";
        HttpResponse<?> response = client.toBlocking()
                .exchange(new SimpleHttpRequest<>(HttpMethod.PUT,
                        "/decks/"+deck,null));

        assertEquals(HttpStatus.CREATED, response.getStatus());
    }

    private static Card makeCard(String name, Suit suit) {
        return Card.builder()
                .suit(suit)
                .name(name)
                .build();
    }
}