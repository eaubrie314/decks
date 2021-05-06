package com.eaubrie314.controller.decks;

import com.eaubrie314.service.model.Deck;
import com.eaubrie314.service.model.DecksService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import java.util.stream.Collectors;

@RequiredArgsConstructor(onConstructor_ = {@Inject})
@Controller
public class DeckController {

    private final DecksService decksService;

    @Put(uri = "/decks/{deckName}", produces = MediaType.APPLICATION_JSON)
    HttpResponse<DeckDTO> createDeck(@PathVariable String deckName) {
        Deck deck = decksService.createDeck(deckName);
        return HttpResponse.created(convertToDTO(deck));
    }

    @Get(uri = "/decks/{deckName}", produces = MediaType.APPLICATION_JSON)
    HttpResponse<DeckDTO> getDeck(@PathVariable String deckName) {
        Deck deck = decksService.getDeck(deckName);
        return HttpResponse.ok(convertToDTO(deck));
    }

    @Delete(uri = "/decks/{deckName}", produces = MediaType.APPLICATION_JSON)
    HttpResponse<?> deleteDeck(@PathVariable String deckName) {
        decksService.deleteDeck(deckName);
        return HttpResponse.ok();
    }

    private DeckDTO convertToDTO(Deck deck) {
        return DeckDTO.builder()
                .name(deck.getName())
                .cards(deck.getCards().stream()
                        .map(card -> CardDTO.builder()
                                .suit(card.getSuit())
                                .name(card.getName())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
