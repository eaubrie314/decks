package com.eaubrie314.service.model;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder
public class Deck {
    private String name;
    private Collection<Card> cards;
}
