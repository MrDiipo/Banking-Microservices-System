package com.mrdiipo.limitsmicroservice.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-microservice")
@Getter
@Setter
public class Configuration {

    private int maximum;
    private int minimum;

}
