package com.eaubrie314.service.model;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Singleton
public class DecksServiceImpl implements DecksService {

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


    @Override
    public Deck createDeck(String name) {
        return new Deck(name, ALL_CARDS);
    }

    @Override
    public Deck shuffleDeck(String name) {
        throw new RuntimeException("fix me");
    }

    @Override
    public void deleteDeck(String name) {
        throw new RuntimeException("fix me");
    }

    private static Card makeCard(String name, Suit suit) {
        return Card.builder()
                .suit(suit)
                .name(name)
                .build();
    }
}
