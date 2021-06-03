package com.eaubrie314.repo.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.eaubrie314.service.model.Suit;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

@Introspected
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder(toBuilder = true)
@DynamoDBDocument
public class CardDAO {
    private String name;
    private Suit suit;
}
