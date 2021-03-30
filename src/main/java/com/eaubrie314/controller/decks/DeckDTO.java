package com.eaubrie314.controller.decks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Introspected
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder(toBuilder = true)
public class DeckDTO {
    @JsonProperty
    private String name;
    @JsonProperty
    private Collection<CardDTO> cards;
}
