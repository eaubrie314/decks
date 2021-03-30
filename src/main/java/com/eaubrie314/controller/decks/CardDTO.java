package com.eaubrie314.controller.decks;

import com.eaubrie314.service.model.Suit;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

@Introspected
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder(toBuilder = true)
public class CardDTO {
    @JsonProperty
    private String name;
    @JsonProperty
    private Suit suit;
}
