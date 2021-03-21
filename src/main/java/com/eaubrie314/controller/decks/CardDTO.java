package com.eaubrie314.controller.decks;

import com.eaubrie314.service.model.Suit;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class CardDTO {
    String name;
    Suit suit;
}
