package com.eaubrie314.controller.decks;

import com.eaubrie314.service.model.*;
import io.micronaut.http.*;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.simple.SimpleHttpRequest;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
class DeckControllerTest {

    private static final List<String> ALL_CARD_NAMES = Stream.of(
            IntStream.rangeClosed(2, 10)
                .mapToObj(Integer::toString)
                .collect(Collectors.toList()),
            Arrays.asList("A", "K", "Q", "J"))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

    private static final List<Card> ALL_CARDS = Arrays.stream(Suit.values())
            .map(suit -> ALL_CARD_NAMES.stream()
                    .map(name -> makeCard(name, suit))
                    .collect(Collectors.toList()))
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

    private static final Deck EXPECTED_DECK = Deck.builder()
            .name("Deck")
            .cards(ALL_CARDS)
            .build();
    @Inject
    @Client("/")
    HttpClient client;

    @Inject
    DecksService service;

    @MockBean(DecksServiceImpl.class)
    public DecksService createDecksService() {
        this.service = mock(DecksService.class);
        return service;
    }

    @Test
    void testDecksEndpoint() {
        when(service.createDeck(anyString())).thenReturn(EXPECTED_DECK);
        String deck = "CardDeck";
        MutableHttpRequest<String> request = new SimpleHttpRequest<String>(
                    HttpMethod.PUT,
                    "/decks/" + deck,
                    null)
                .accept(MediaType.APPLICATION_JSON);
        HttpResponse<String> response = client.toBlocking()
                .exchange(request, String.class);

        assertEquals(HttpStatus.CREATED, response.getStatus());
        assertTrue(response.getBody().isPresent());
    }

    private static Card makeCard(String name, Suit suit) {
        return Card.builder()
                .suit(suit)
                .name(name)
                .build();
    }
}