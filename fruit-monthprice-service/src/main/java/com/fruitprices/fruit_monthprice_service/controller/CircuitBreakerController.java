package com.fruitprices.fruit_monthprice_service.controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    public String SampleApi(){
        return "Sample API";
    }

    @GetMapping("/dummy-url")
    @Retry(name = "default")
    // purposely failing the rest api call the using @Retry
    public String SampleApi2(){
        logger.info("dummy url call received");
        ResponseEntity<String>  forEntity =  new RestTemplate().getForEntity("http://localhost:8080/circuit-breaker", String.class);

        return forEntity.getBody();
    }
}
