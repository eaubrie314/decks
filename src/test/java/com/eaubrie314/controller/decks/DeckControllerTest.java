package com.eaubrie314.controller.decks;

import io.micronaut.http.HttpMethod;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.simple.SimpleHttpRequest;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class DeckControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testDecksEndpoint() {
        String deck = "CardDeck";
        HttpResponse<?> response = client.toBlocking()
                .exchange(new SimpleHttpRequest<>(HttpMethod.PUT,
                        "/decks/"+deck,null));

        assertEquals(HttpStatus.CREATED, response.getStatus());
    }
}