package com.ejerciciodeprogramacion.ejercicio.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class Controller {

    private final RestTemplate restTemplate;

    @Autowired
    public Controller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/test")
    public Object getApi(){
        String url = "http://data-env.eba-pwemrg4q.us-east-1.elasticbeanstalk.com/data/sensorElement/783/measurement?from=2022-04-22T04:00:00.000Z&to=2022-04-23T03:59:59.000Z&timeUnit=SEC";
        Object forObject = restTemplate.getForObject(url, Object.class);
        log.info("Result " + forObject);
        return forObject;
    }
}
