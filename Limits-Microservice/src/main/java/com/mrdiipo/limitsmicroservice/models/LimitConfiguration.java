package com.mrdiipo.limitsmicroservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
public class LimitConfiguration {

    @Value("${limits-service.maximum}")
    private int maximum;
    @Value("${limits-service.minimum}")
   private int minimum;

    protected LimitConfiguration() {
    }
}
