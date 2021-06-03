package com.eaubrie314.repo.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Introspected
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder(toBuilder = true)
@DynamoDBTable(tableName="decks-table")
public class DeckDAO {
    @DynamoDBHashKey
    private String deckId;
    private Collection<CardDAO> cards;
}
