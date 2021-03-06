package com.eaubrie314.service.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Suit {
    HEARTS("red"),
    DIAMONDS("red"),
    SPADES("black"),
    CLUBS("black");

    private final String color;
}
