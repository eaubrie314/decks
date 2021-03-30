package com.eaubrie314.controller.decks;

import com.eaubrie314.service.model.Deck;
import com.eaubrie314.service.model.DecksService;
import com.eaubrie314.service.model.DecksServiceImpl;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Put;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class DeckController {

    private final DecksService decksService;

    @Put(uri = "/decks/{deckName}", produces = MediaType.APPLICATION_JSON)
    HttpResponse<DeckDTO> deck(@PathVariable String deckName) {
        Deck deck = decksService.createDeck(deckName);
        return HttpResponse.created(DeckDTO.builder()
                .name(deck.getName())
                .cards(deck.getCards().stream()
                    .map(card -> CardDTO.builder()
                            .suit(card.getSuit())
                            .name(card.getName())
                            .build())
                .collect(Collectors.toList()))
                .build());
    }
}
