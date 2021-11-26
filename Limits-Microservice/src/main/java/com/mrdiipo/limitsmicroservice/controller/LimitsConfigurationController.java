package com.mrdiipo.limitsmicroservice.controller;

import com.mrdiipo.limitsmicroservice.config.Configuration;
import com.mrdiipo.limitsmicroservice.models.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

   @Autowired private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitConfiguration(){
        return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum()
                );
    }
}
