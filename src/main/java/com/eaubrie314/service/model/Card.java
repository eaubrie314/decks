package com.eaubrie314.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Card {
    private String name;
    private Suit suit;
}
