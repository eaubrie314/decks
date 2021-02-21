package com.eaubrie314.controller.about;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class AboutTest {


    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testAboutEndpoint() {
        HttpResponse<AboutResponseDTO> response = client.toBlocking().exchange("/about", AboutResponseDTO.class);
        HttpStatus status = response.getStatus();

        assertEquals(HttpStatus.OK, status);
        assertEquals("Hello", response.body().getMessage());
    }
}