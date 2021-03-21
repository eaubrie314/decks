package com.eaubrie314.controller.decks;

import lombok.Builder;
import lombok.Value;

import java.util.Collection;

@Value
@Builder(toBuilder = true)
public class DeckDTO {
    String name;
    Collection<CardDTO> cards;
}
