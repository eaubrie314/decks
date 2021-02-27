package com.eaubrie314.controller.about;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class AboutController {
    static Logger log = LoggerFactory.getLogger(AboutController.class);
    @Get(uri = "/about", produces = MediaType.APPLICATION_JSON)
    HttpResponse<AboutResponseDTO> about() {
        log.info("about info called");
        AboutResponseDTO body = new AboutResponseDTO("Hello");
        MutableHttpResponse<AboutResponseDTO> hello = HttpResponse.ok(body);
        return hello;
    }
}
