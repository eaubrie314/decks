package com.eaubrie314.controller.decks;

import com.eaubrie314.service.model.Deck;
import com.eaubrie314.service.model.DecksService;
import com.eaubrie314.service.model.DecksServiceImpl;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Put;

@Controller
public class DeckController {
    @Put(uri = "/decks/{deckName}", produces = MediaType.APPLICATION_JSON)
    HttpResponse<?> deck(@PathVariable String deckName) {
        DecksService decksService = new DecksServiceImpl();
        decksService.createDeck(deckName);
        return HttpResponse.created("");
    }
}
